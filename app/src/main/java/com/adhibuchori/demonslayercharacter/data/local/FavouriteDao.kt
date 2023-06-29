package com.adhibuchori.demonslayercharacter.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adhibuchori.demonslayercharacter.model.DemonSlayerCharacter
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {

    @Query("SELECT * FROM FavouriteCharacter")
    fun getAllFavouriteChar(): Flow<List<DemonSlayerCharacter>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavouriteChar(char: DemonSlayerCharacter): Long

    @Query("DELETE FROM FavouriteCharacter WHERE id = :id")
    suspend fun deleteFavouriteChar(id: Long): Int

    @Query("SELECT * FROM FavouriteCharacter WHERE id = :id")
    fun getFavoriteCharById(id: Long): Flow<DemonSlayerCharacter>
}