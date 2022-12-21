package com.example.dz2_android_2.ui.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dz2_android_2.ui.data.db.daos.NoteDao
import com.example.dz2_android_2.ui.model.RecyclerModel

@Database(entities = [RecyclerModel::class], version = 7)
abstract class AppDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}