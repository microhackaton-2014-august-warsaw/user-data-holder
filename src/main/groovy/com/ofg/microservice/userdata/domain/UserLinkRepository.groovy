package com.ofg.microservice.userdata.domain

import groovy.transform.TypeChecked
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

@TypeChecked
interface UserLinkRepository extends JpaRepository<UserLink, String> {
}
