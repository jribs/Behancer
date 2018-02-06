package com.inviscidlabs.behancer.model


data class FieldResponse(
        val httpCode: Int? = null,
        val fields: List<AllFields>? = null,
        val popular: List<PopularFields>? = null)

data class AllFields(
        val name: String? = null,
        val id: Int? = null)

data class PopularFields(
        val name: String? = null,
        val id: Int? = null)
