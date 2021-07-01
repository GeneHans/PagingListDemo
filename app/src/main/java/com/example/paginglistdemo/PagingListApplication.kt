package com.example.paginglistdemo

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.paginglistdemo.room.DemoWorkDataBase

class PagingListApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        mContext = this
        Room.databaseBuilder(this, DemoWorkDataBase::class.java,
            DemoWorkDataBase.RoomDataBaseName
        )
    }

    companion object {
        lateinit var mContext: Context
    }
}