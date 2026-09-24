package com.liceo.account.domain.model

data class User(
    // TODO 2a: id as a String
    val id: String,
    // TODO 2b: fullName, email, birthdate each a String
    val fullName: String,
    val email: String,
    val birthdate: String
)
