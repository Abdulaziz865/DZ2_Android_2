package com.example.dz2_android_2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dz2_android_2.data.db.daos.NoteDao
import com.example.dz2_android_2.model.RecyclerModel

@Database(entities = [RecyclerModel::class], version = 5)
abstract class AppDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}