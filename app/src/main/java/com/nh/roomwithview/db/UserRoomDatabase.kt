package com.nh.roomwithview.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nh.roomwithview.dao.UserDao
import com.nh.roomwithview.entity.Department
import com.nh.roomwithview.entity.User
import com.nh.roomwithview.entity.UserDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [User::class, Department::class], views = [UserDetail::class], version = 1)
abstract class UserRoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): UserRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserRoomDatabase::class.java,
                    "user_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .addCallback(
                        DatabaseCallback(
                            scope
                        )
                    )
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

    }

    class DatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.userDao())
                }
            }
        }

        fun populateDatabase(mDao: UserDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mDao.deleteAll()

            var mUser = User(1, "John", 1)
            mDao.insert(mUser)

            mUser = User(2, "Steve", 2)
            mDao.insert(mUser)

            mUser = User(3, "Charles", 3)
            mDao.insert(mUser)

            mUser = User(4, "Dennis", 2)
            mDao.insert(mUser)

            mUser = User(5, "Jake", 1)
            mDao.insert(mUser)

            var department =
                Department(1, "Electronics")
            mDao.insert(department)
            department = Department(2, "Computer")
            mDao.insert(department)
            department = Department(3, "Mechanical")
            mDao.insert(department)

        }
    }


}
