package com.nareshak.demo

import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Retryable

@Client(value = "http://localhost:8081/")
@Retryable(attempts = "5", delay = "2s", multiplier = "2.01")
interface PresentationClientRetry extends PresentationOps {

}