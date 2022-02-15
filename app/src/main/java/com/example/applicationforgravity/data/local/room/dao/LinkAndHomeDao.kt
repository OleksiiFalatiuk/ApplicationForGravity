package com.example.applicationforgravity.data.local.room.dao

import androidx.room.*
import com.example.applicationforgravity.data.local.room.LinkAndHomeDbEntity

@Dao
interface LinkAndHomeDao {

    @Transaction
    @Query("SELECT * FROM LinkAndHome")
    fun getMovies(): List<LinkAndHomeDbEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: LinkAndHomeDbEntity)

}