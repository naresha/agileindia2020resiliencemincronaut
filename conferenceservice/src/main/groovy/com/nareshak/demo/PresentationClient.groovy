package com.nareshak.demo


import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker

@Client(value = "http://localhost:8081/")
@CircuitBreaker(reset = "20s", attempts = "1")
interface PresentationClient extends PresentationOps {
}