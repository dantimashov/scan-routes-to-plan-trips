package com.dtimashov.scantoplan.business.models

import kotlinx.serialization.Serializable

/**
 * @author daniil.timashov on 25.02.2023
 */
@Serializable
data class Place(val name: String, val locatedAt: Place?)
