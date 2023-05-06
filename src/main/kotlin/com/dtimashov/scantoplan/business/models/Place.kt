package com.dtimashov.scantoplan.business.models

import kotlinx.serialization.Serializable

/**
 * @author daniil.timashov on 25.02.2023
 */
@Serializable
data class Place(val id: String, val name: String?, val locatedAt: Place?) {

    constructor(id: String) : this(id, null, null)

    override fun equals(other: Any?): Boolean {
        return (other is Place) && other.id == id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
