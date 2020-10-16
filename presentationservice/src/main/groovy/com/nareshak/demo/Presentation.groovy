package com.nareshak.demo

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity
class Presentation {
    @Id
    @GeneratedValue
    Long id

    String title
    Integer durationInMinutes
    Long speakerId
}
