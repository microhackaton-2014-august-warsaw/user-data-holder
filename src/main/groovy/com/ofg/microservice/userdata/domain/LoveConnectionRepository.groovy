package com.ofg.microservice.userdata.domain

import groovy.transform.TypeChecked
import org.springframework.data.jpa.repository.JpaRepository

@TypeChecked
interface LoveConnectionRepository extends JpaRepository<LoveConnection, String> {
}
