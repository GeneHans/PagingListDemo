package com.example.paginglistdemo.paging2

import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.example.paginglistdemo.PagingListApplication
import com.example.paginglistdemo.room.DemoWorkDataBase
import com.example.paginglistdemo.room.TestListPageEntity

class Paging2ViewModel : ViewModel() {
    private var dataDao =
        DemoWorkDataBase.getInstance(PagingListApplication.mContext).getTestPageDataDao()
    //自定义Config
    private val myPagingConfig = PagedList.Config.Builder()
            //每页数据项数量
        .setPageSize(50)
            //预取距离，给定应用界面中的最后一个可见项，Paging 库应尝试提前获取的超出此最后一项的项数。此值应是页面大小的数倍大。
        .setPrefetchDistance(150)
            //占位符存在，确定界面是否对尚未完成加载的列表显示占位符
        .setEnablePlaceholders(true)
        .build()


    // The Int type argument corresponds to a PositionalDataSource object.
    private val myConcertDataSource: DataSource.Factory<Int, TestListPageEntity>? =
        dataDao.queryAll()

    val concertList = myConcertDataSource?.toLiveData(myPagingConfig)

}