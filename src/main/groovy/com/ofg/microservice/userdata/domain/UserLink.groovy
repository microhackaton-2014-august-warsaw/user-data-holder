package com.ofg.microservice.userdata.domain

import com.ofg.microservice.userdata.links.NewLinkRequest
import groovy.transform.Canonical
import groovy.transform.TypeChecked
import org.hibernate.annotations.OptimisticLockType
import org.hibernate.annotations.OptimisticLocking

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Version

@TypeChecked
@Entity
@Table(name = 'USER_LINKS')
@OptimisticLocking(type = OptimisticLockType.VERSION)
@Canonical
class UserLink {

    @Id
    @Column(name = "ID")
    String id

    @Version
    @Column(name = "ENTITY_VERSION", nullable = false)
    Long version

    @Column(name = "FACEBOOK")
    String facebook

    @Column(name = "TWITTER")
    String twitter

    @Column(name = "GOOGLEPLUS")
    String googleplus

    @Column(name = "NAME")
    String name

    @Column(name = "RSS")
    String rss

    @Column(name = "GITHUB")
    String github

    static UserLink fromLinkRequest(NewLinkRequest linkRequest) {
        return new UserLink(
                id: UUID.randomUUID().toString(),
                facebook: linkRequest.facebook,
                twitter: linkRequest.twitter,
                googleplus: linkRequest.googleplus,
                name: linkRequest.name,
                rss: linkRequest.rss,
                github : linkRequest.github
        )
    }
}
