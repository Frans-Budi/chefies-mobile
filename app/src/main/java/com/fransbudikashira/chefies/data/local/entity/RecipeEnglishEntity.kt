package com.fransbudikashira.chefies.data.local.entity

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "recipe_english")
data class RecipeEnglishEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long? = null,

    @ColumnInfo(name = "name")
    val title: String,

    @ColumnInfo(name = "ingredients")
    val ingredients: List<String>,

    @ColumnInfo(name = "steps")
    val steps: List<String>,

    @ColumnInfo(name = "history_id")
    val historyId: Long? = null,

    @ColumnInfo(name = "facts")
    val facts: List<String>
): Parcelable