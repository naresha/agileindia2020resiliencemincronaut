package com.nareshak.demo

import io.micronaut.retry.annotation.Fallback

@Fallback
class PresentationClientFallback implements PresentationOps {
    @Override
    PresentationInfo getPresentationInfo(Long presentationId) {
        new PresentationInfo(title: "TBD")
    }
}
