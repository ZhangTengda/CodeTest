package com.roger.test.util.room

import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.roger.test.BaseApplication

class AppDataBaseManager {

    companion object {
        // 通过 by lazy 实现懒加载单例，只有首次访问时才会创建 AppDatabase 实例
        val instance by lazy {
            // 这里可以根据实际情况传入合适的 Context，比如 Application 上下文更好
            Room.databaseBuilder(
                BaseApplication.appContext,
                AppDatabase::class.java,
                "database-person"
            )
//                .addMigrations(MIGRATION_1_2)
                .build()
        }

        // 定义迁移策略：从版本 1 升级到版本 2
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // 创建新表 Book
                db.execSQL(
                    """
            CREATE TABLE IF NOT EXISTS `books` (
                `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
                `title` TEXT, 
                `author` TEXT
            )
        """.trimIndent()
                )
            }
        }
    }


}