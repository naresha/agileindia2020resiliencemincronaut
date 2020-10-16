package com.nareshak.demo

import groovy.util.logging.Slf4j
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.retry.annotation.CircuitBreaker
import io.micronaut.retry.annotation.Fallback
import io.micronaut.retry.annotation.Retryable

@Controller("/presentationDetail")
@Slf4j
class PresentationDetailController {

    final PresentationClient presentationClient
    final PresentationClientAlternate presentationClientAlternate
    final PresentationClientRetry presentationClientRetry

    PresentationDetailController(PresentationClient presentationClient,
                                 PresentationClientAlternate presentationClientAlternate,
                                 PresentationClientRetry presentationClientRetry) {
        this.presentationClient = presentationClient
        this.presentationClientAlternate = presentationClientAlternate
        this.presentationClientRetry = presentationClientRetry
    }

    @Get(value = "/timeout", produces = MediaType.APPLICATION_JSON)
    PresentationInfo get() {
        //presentationClient.getPresentationInfo(4L)
        presentationClientAlternate.getPresentationInfo(4L)
    }


    @Get(value = "/retry", produces = MediaType.APPLICATION_JSON)
    //@Retryable
    //@Retryable(attempts = "5", delay = "2s", multiplier = "2.01")
    PresentationInfo getPresentation() {
        log.info("Calling presentation service {}", System.currentTimeMillis())
        PresentationInfo presentationInfo = presentationClientRetry.getPresentationInfo(1L)
        log.info("Received: {}", presentationInfo)
        presentationInfo
    }


    @Get(value = "/fallback", produces = MediaType.APPLICATION_JSON)
    PresentationInfo getTalk() {
        presentationClient.getPresentationInfo(4L)
    }

    @Get(value = "/cb", produces = MediaType.APPLICATION_JSON)
    PresentationInfo getThatTalk() {
        presentationClient.getPresentationInfo(4L)
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    PresentationInfo getThatTalkById(@PathVariable Long id) {
        presentationClient.getPresentationInfo(id)
    }
}
