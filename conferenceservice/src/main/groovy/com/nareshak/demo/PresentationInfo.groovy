package com.nareshak.demo

import groovy.transform.ToString

@ToString(includePackage = false)
class PresentationInfo implements Serializable {
    Long id
    String title
    Integer durationInMinutes
    Long speakerId
}
