package com.adhibuchori.demonslayercharacter.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavouriteCharacter")
data class DemonSlayerCharacter (

    @field:ColumnInfo(name = "Id")
    @field:PrimaryKey
    val id: Long,

    @field:ColumnInfo(name = "Name")
    val name: String,

    @field:ColumnInfo(name = "VoiceActor")
    val voiceActor: String,

    @field:ColumnInfo(name = "Gender")
    val gender: String,

    @field:ColumnInfo(name = "CharacterType")
    val characterType: String,

    @field:ColumnInfo(name = "ImageUrl")
    val imageUrl: String,

    @field:ColumnInfo(name = "Description")
    val description: String,
)
