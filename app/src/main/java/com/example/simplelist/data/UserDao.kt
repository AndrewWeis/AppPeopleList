package com.example.simplelist.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.simplelist.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // if there are new exactly the same user then we ignore that
    suspend fun addUser(user: User) // suspend because we're going to use coroutines later

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}