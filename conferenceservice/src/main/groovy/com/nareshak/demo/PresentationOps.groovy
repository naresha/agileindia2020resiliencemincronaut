package com.nareshak.demo

import io.micronaut.http.annotation.Get

interface PresentationOps {

    @Get("/{presentationId}")
    PresentationInfo getPresentationInfo(Long presentationId)
}