package com.nareshak.demo

import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic
import io.micronaut.runtime.event.annotation.EventListener

@CompileStatic
class Application {

    static final Long AGILE_INDIA = 1L
    static final Long GR8_CONF = 2L

    final ScheduledPresentationRepository scheduledPresentationRepository


    Application(ScheduledPresentationRepository scheduledPresentationRepository) {
        this.scheduledPresentationRepository = scheduledPresentationRepository
    }

    static void main(String[] args) {
        Micronaut.run(Application)
    }

    @EventListener
    void init(StartupEvent event) {
        List<ScheduledPresentation> scheduledPresentations = [
                new ScheduledPresentation(conferenceId: AGILE_INDIA, presentationId: 1L),
                new ScheduledPresentation(conferenceId: AGILE_INDIA, presentationId: 2L),
                new ScheduledPresentation(conferenceId: AGILE_INDIA, presentationId: 3L),
                new ScheduledPresentation(conferenceId: GR8_CONF, presentationId: 4L),
        ]
        scheduledPresentationRepository.saveAll(scheduledPresentations)
    }
}