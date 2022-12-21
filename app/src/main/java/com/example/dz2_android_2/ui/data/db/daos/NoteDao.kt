package com.example.dz2_android_2.ui.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.dz2_android_2.ui.model.RecyclerModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM recyclerModel")
    fun getAll(): LiveData<List<RecyclerModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(recyclerModel: RecyclerModel)

    @Update
    fun upDateUser(model: RecyclerModel)

}