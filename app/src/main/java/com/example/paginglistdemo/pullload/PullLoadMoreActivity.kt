package com.example.paginglistdemo.pullload

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paginglistdemo.R
import com.example.paginglistdemo.entity.TestData

class PullLoadMoreActivity : AppCompatActivity() {
    private lateinit var listPullLoad: RecyclerView
    private var listData: ArrayList<TestData> = arrayListOf()
    private lateinit var listAdapter: LoadMoreAdapter
    private var count = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_load_more)
        listPullLoad = findViewById(R.id.list_pull_load)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        listData.add(TestData("测试1", "测试数据1"))
        listData.add(TestData("测试2", "测试数据2"))
        listData.add(TestData("测试3", "测试数据3"))
        listData.add(TestData("测试4", "测试数据4"))
        listData.add(TestData("测试5", "测试数据5"))
        listData.add(TestData("测试6", "测试数据6"))
        listData.add(TestData("测试7", "测试数据7"))
        listData.add(TestData("测试8", "测试数据8"))
        listData.add(TestData("测试9", "测试数据9"))

        listAdapter = LoadMoreAdapter(listData)
        listPullLoad.adapter = listAdapter
        listPullLoad.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        listPullLoad.layoutManager = LinearLayoutManager(this)

        listPullLoad.addOnScrollListener(object : EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                listData.add(TestData("测试$count","测试数据$count"))
                count++
                listAdapter.notifyDataSetChanged()
                //加载数据完成，重置为可继续加载数据状态
                this.isLoadingData = false
            }
        })
    }
}