package com.nareshak.demo

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.H2)
interface ScheduledPresentationRepository extends CrudRepository<ScheduledPresentation, Long> {
    Iterable<Long> findPresentationId(Long conferenceId)
}