package com.ofg.microservice.userdata.links

import com.ofg.microservice.userdata.domain.JsonStringWrapper
import com.ofg.microservice.userdata.domain.LoveConnection
import com.ofg.microservice.userdata.domain.LoveConnectionRepository
import com.ofg.microservice.userdata.domain.UserLink
import com.ofg.microservice.userdata.domain.UserLinkRepository
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@TypeChecked
@Slf4j
@RestController
@RequestMapping(value = "/link")
class LinkGeneratorController {

    private UserLinkRepository linkRepository
    private LoveConnectionRepository loveConnectionRepository

    @Autowired
    LinkGeneratorController(UserLinkRepository linkRepository, LoveConnectionRepository loveConnectionRepository) {
        this.linkRepository = linkRepository
        this.loveConnectionRepository = loveConnectionRepository
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = UserDataHolderAPI.JSON_V1,
            produces = UserDataHolderAPI.JSON_V1)
    ResponseEntity<JsonStringWrapper> createNewLink(@RequestBody NewLinkRequest request) {
        log.info("New link: $request")

        UserLink link = linkRepository.save(UserLink.fromLinkRequest(request))

        log.info("persisted ${link}")

        return new ResponseEntity(new JsonStringWrapper(link.id), HttpStatus.OK)
    }

    @RequestMapping(value = '/pair', method = RequestMethod.PUT,
            consumes = UserDataHolderAPI.JSON_V1,
            produces = UserDataHolderAPI.JSON_V1)
    ResponseEntity<JsonStringWrapper> createPair(@RequestBody CreatePairRequest request) {
        log.info("New pair: $request")

        LoveConnection loveConnection = loveConnectionRepository.save(
                new LoveConnection(
                        id: UUID.randomUUID().toString(),
                        celebrity: linkRepository.findOne(request.celebrityId),
                        peasant: linkRepository.findOne(request.peasantId)))

        log.info("persisted ${loveConnection}")

        return new ResponseEntity(new JsonStringWrapper(loveConnection.id), HttpStatus.OK)
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST,
            consumes = UserDataHolderAPI.JSON_V1,
            produces = UserDataHolderAPI.JSON_V1)
    ResponseEntity<UserLink> getLink(@PathVariable("id") String id) {
        UserLink userLink = linkRepository.findOne(id)
        return new ResponseEntity(userLink, HttpStatus.OK)
    }
}
