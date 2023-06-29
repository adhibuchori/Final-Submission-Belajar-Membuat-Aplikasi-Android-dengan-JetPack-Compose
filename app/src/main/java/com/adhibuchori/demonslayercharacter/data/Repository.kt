package com.adhibuchori.demonslayercharacter.data

import com.adhibuchori.demonslayercharacter.model.FakeDataSource
import com.adhibuchori.demonslayercharacter.data.local.FavouriteDao
import com.adhibuchori.demonslayercharacter.model.DemonSlayerCharacter
import kotlinx.coroutines.flow.Flow

class Repository private constructor(private val favouriteDao: FavouriteDao) {

    fun getAllCharacters(): List<DemonSlayerCharacter> {
        return FakeDataSource.dummyDemonSlayerCharacters
    }

    fun getCharacterById(id: Long): DemonSlayerCharacter {
        return FakeDataSource.dummyDemonSlayerCharacters.first {
            it.id == id
        }
    }

    fun searchCharacters(query: String): List<DemonSlayerCharacter> {
        return FakeDataSource.dummyDemonSlayerCharacters.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun getFavouriteChar(): Flow<List<DemonSlayerCharacter>> {
        return favouriteDao.getAllFavouriteChar()
    }

    suspend fun addFavouriteChar(demonSlayerCharacter: DemonSlayerCharacter): Long {
        return favouriteDao.addFavouriteChar(demonSlayerCharacter)
    }

    suspend fun deleteFavouriteChar(id: Long): Int {
        return favouriteDao.deleteFavouriteChar(id)
    }

    fun getFavouriteCharById(id: Long): Flow<DemonSlayerCharacter> = favouriteDao.getFavoriteCharById(id)

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(
            favouriteDao: FavouriteDao,
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(favouriteDao)
            }.also { instance = it }
    }
}