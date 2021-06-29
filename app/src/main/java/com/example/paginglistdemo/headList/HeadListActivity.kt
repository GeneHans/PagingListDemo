package com.example.paginglistdemo.headList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paginglistdemo.R
import com.example.paginglistdemo.entity.TestData

class HeadListActivity : AppCompatActivity() {
    private var listView: TestHeaderRecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_test)
        listView = findViewById(R.id.list_test_recyclerView)
        var listData = initData()
        setSimpleAdapter(listData)
    }

    private fun initData(): ArrayList<TestData> {
        var listData = ArrayList<TestData>()
        listData.add(TestData("test1", "测试1"))
        listData.add(TestData("test2", "测试2"))
        listData.add(TestData("test3", "测试3"))
        listData.add(TestData("test4", "测试4"))
        return listData
    }

    private fun setSimpleAdapter(listData: ArrayList<TestData>) {
        var headView1 = TestHeaderView(this)
        var footView1 = TestHeaderView(this)
        var testAdapter = TestAdapter(listData)
        listView?.addHeaderView(headView1)
        listView?.addFooterView(footView1)
        listView?.setAdapter(testAdapter)
        listView?.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        listView?.layoutManager = LinearLayoutManager(this)
        testAdapter
    }
}