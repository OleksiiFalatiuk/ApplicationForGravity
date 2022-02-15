package com.example.applicationforgravity.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LinkAndHome")
data class LinkAndHomeDbEntity(
    @PrimaryKey
    val link: String,
    val home: String
)