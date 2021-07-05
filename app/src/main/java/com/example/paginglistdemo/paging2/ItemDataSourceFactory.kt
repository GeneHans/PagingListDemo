package com.example.paginglistdemo.paging2

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.paginglistdemo.room.TestListPageEntity

class ItemDataSourceFactory :
    DataSource.Factory<Long, TestListPageEntity>() {
    private val sourceLiveData = MutableLiveData<ItemDataSource>()
    private lateinit var latestSource: ItemDataSource
    override fun create(): DataSource<Long, TestListPageEntity> {
        latestSource = ItemDataSource()
        sourceLiveData.postValue(latestSource)
        return latestSource
    }
}