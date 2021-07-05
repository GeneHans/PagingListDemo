package com.example.paginglistdemo.paging2

import androidx.paging.ItemKeyedDataSource
import com.example.paginglistdemo.PagingListApplication
import com.example.paginglistdemo.room.DemoWorkDataBase
import com.example.paginglistdemo.room.TestListPageEntity

class ItemDataSource :
    ItemKeyedDataSource<Long, TestListPageEntity>() {
    override fun getKey(item: TestListPageEntity) = item.id

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<TestListPageEntity>
    ) {
        val beginPosition = params.requestedInitialKey ?: 0
        DemoWorkDataBase.getInstance(PagingListApplication.mContext)
            .getTestPageDataDao()
            .queryBetweenIds(beginPosition, beginPosition + params.requestedLoadSize)
            .subscribe {
                if (it != null) {
                    callback.onResult(it)
                }
            }
    }

    override fun loadAfter(
        params: LoadParams<Long>,
        callback: LoadCallback<TestListPageEntity>
    ) {
        val beginPosition = params.key
        DemoWorkDataBase.getInstance(PagingListApplication.mContext)
            .getTestPageDataDao()
            .queryBetweenIds(beginPosition, beginPosition + params.requestedLoadSize)
            .subscribe {
                if (it != null) {
                    callback.onResult(it)
                }
            }
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<TestListPageEntity>) {

    }
}