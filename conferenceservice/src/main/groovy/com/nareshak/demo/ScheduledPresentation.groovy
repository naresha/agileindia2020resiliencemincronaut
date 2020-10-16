package com.nareshak.demo

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity
class ScheduledPresentation {
    @Id
    @GeneratedValue
    Long id
    Long conferenceId
    Long presentationId
}
