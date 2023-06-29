package com.adhibuchori.demonslayercharacter.di

import android.content.Context
import com.adhibuchori.demonslayercharacter.data.Repository
import com.adhibuchori.demonslayercharacter.data.local.FavouriteDatabase

object Injection {
    fun provideRepository(context: Context): Repository {
        val database = FavouriteDatabase.getInstance(context)
        val dao = database.favouriteDao()
        return Repository.getInstance(dao)
    }
}