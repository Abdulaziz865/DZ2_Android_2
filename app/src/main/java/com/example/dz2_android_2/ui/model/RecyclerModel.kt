package com.example.dz2_android_2.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recyclerModel")
data class RecyclerModel(
    var textTitle: String,
    var textDescription: String,
    var textData: String
) : java.io.Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
