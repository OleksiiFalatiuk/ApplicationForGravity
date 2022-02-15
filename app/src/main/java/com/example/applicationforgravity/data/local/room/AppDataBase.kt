package com.example.applicationforgravity.data.local.room

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import com.example.applicationforgravity.data.local.room.dao.LinkAndHomeDao
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [LinkAndHomeDbEntity::class],
    version = 3,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2,spec = AppDataBase.FirstMigration::class), AutoMigration(from = 2, to = 3)

    ]
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getLinkAndHomeDao(): LinkAndHomeDao

    @InternalCoroutinesApi
    companion object {
        private var instance: AppDataBase? = null
        private const val DATABASE_NAME = "Films.db"


        fun getInstance(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(AppDataBase::class.java) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            AppDataBase::class.java,
                            DATABASE_NAME
                        )
                            .build()
                    }
                }
            }
            return instance!!
        }
    }


        @DeleteColumn.Entries(
        DeleteColumn(
            tableName = "LinkAndHome",
            columnName = "id"
        )
    )
    class FirstMigration: AutoMigrationSpec


}