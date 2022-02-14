package com.example.applicationforgravity.data.remote.retrofit.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class LinkAndHomeResponse(
    @SerialName("link") val link: String,
    @SerialName("home") val home: String
)