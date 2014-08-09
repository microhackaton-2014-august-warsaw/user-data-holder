package com.ofg.microservice.userdata.links

import groovy.transform.Canonical
import groovy.transform.TypeChecked

@TypeChecked
@Canonical
class CreatePairRequest {
    String peasantId
    String celebrityId
}
