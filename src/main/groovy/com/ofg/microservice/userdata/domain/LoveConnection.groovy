package com.ofg.microservice.userdata.domain
import groovy.transform.Canonical
import groovy.transform.TypeChecked
import org.hibernate.annotations.OptimisticLockType
import org.hibernate.annotations.OptimisticLocking

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Version

@TypeChecked
@Entity
@Table(name = 'LOVE_CONNECTION')
@OptimisticLocking(type = OptimisticLockType.VERSION)
@Canonical
class LoveConnection {

    @Id
    @Column(name = "ID")
    String id

    @Version
    @Column(name = "ENTITY_VERSION", nullable = false)
    Long version

    @ManyToOne
    @JoinColumn(name = "CELEBRITY_ID")
    UserLink celebrity

    @ManyToOne
    @JoinColumn(name = "PEASANT_ID")
    UserLink peasant
}
