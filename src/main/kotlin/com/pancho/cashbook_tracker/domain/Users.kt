package com.pancho.cashbook_tracker.domain

import jakarta.persistence.*
import org.apache.commons.lang3.builder.ToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle
import java.util.*


@Entity(name = "users")
@Table(name = "users")
class Users (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "name")
    val name: String,
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val partners: Partners,
    @Embedded
    val audit: EntityAudit,
) {

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        if (other !is Users) {
            return false
        }
        return Objects.equals(id, other.id)
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("id", id)
            .append("name", name)
            .append("createdOn", audit.createdOn)
            .append("createdBy", audit.createdBy)
            .append("updatedOn", audit.updatedOn)
            .append("updatedBy", audit.updatedBy)
            .toString()
    }
}