package com.ofg.microservice.userdata.domain.config

import groovy.transform.TypeChecked
import org.springframework.boot.orm.jpa.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement


@TypeChecked
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ofg.microservice.userdata.domain")
@EntityScan("com.ofg.microservice.userdata.domain")
class DbConfiguration {

}
