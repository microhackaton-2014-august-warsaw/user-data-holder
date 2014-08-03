package com.ofg.microservice.userdata.links
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@TypeChecked
@Slf4j
@RestController
@RequestMapping(value = "/link")
class LinkGeneratorController {

    @RequestMapping(method = RequestMethod.PUT,
            consumes = UserDataHolderAPI.JSON_V1,
            produces = UserDataHolderAPI.JSON_V1)
    ResponseEntity<String> createNewLink(@RequestBody NewLinkRequest request) {
        log.info("New link: $request")

        return new ResponseEntity('http://domain:port/' + UUID.randomUUID(), HttpStatus.OK)
    }
}
