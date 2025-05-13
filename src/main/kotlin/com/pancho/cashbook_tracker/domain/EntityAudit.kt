package com.pancho.cashbook_tracker.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.time.Instant

@Embeddable
class EntityAudit (
    @Column(name = "createdOn")
    val createdOn: Instant,
    @Column(name = "createdBy")
    val createdBy: String,
    @Column(name = "updatedOn")
    val updatedOn: Instant,
    @Column(name = "updatedBy")
    val updatedBy: Instant
)