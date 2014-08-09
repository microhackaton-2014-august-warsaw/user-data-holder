package com.ofg.microservice.userdata.links

import groovy.transform.Canonical
import groovy.transform.TypeChecked

@TypeChecked
@Canonical
class NewLinkRequest {
    String name
    String twitter
    String facebook
    String googleplus
    String rss
    String github
}
