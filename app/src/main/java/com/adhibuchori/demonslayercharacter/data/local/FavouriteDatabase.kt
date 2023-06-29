package com.adhibuchori.demonslayercharacter.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adhibuchori.demonslayercharacter.model.DemonSlayerCharacter

@Database(entities = [DemonSlayerCharacter::class], version = 1, exportSchema = false)
abstract class FavouriteDatabase : RoomDatabase() {
    abstract fun favouriteDao(): FavouriteDao

    companion object {
        @Volatile
        private var instance: FavouriteDatabase? = null
        fun getInstance(context: Context): FavouriteDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    FavouriteDatabase::class.java, "Favourite.db"
                ).build()
            }
    }
}