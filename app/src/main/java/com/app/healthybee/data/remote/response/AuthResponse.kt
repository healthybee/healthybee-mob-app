package com.app.healthybee.data.remote.response

/**
 * Created by Amit Bhati on 02/03/2019.
 */

data class AuthResponse(val token: String, val user: User) {

    data class User(
        val id: Int,
        val name: String,
        val picture: String,
        val email: String,
        val mobile: String,
        val createdAt: String
    )
}