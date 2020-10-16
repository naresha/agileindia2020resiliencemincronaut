package com.nareshak.demo

import io.micronaut.http.client.annotation.Client

@Client(id = "presentationservice")
interface PresentationClientAlternate extends PresentationOps {
}
