package com.example.applicationforgravity.provider

import com.example.applicationforgravity.data.LinkRepository

interface LinkAndHomeProvider {
    fun provideLinkAndHome(): LinkRepository
}