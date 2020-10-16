package com.nareshak.demo

import groovy.util.logging.Slf4j
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.retry.annotation.Retryable

@Controller("/")
@Slf4j
class PresentationController {

    final PresentationRepository presentationRepository

    PresentationController(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    Iterable<Presentation> index() {
        presentationRepository.findAll()
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    Optional<Presentation> get(@PathVariable Long id) {
        if (id == 4) {
            Thread.sleep(11000)
        } else if (id == 1) {
            long millis = System.currentTimeMillis()
            log.info("Time: {}", millis)
            if (millis % 2 == 0) {
                Thread.sleep(11000)
            }
        }
        presentationRepository.findById(id)
    }
}
