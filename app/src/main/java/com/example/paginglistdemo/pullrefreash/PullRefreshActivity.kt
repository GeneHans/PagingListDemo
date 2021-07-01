package com.example.paginglistdemo.pullrefreash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.paginglistdemo.R
import com.example.paginglistdemo.entity.TestData
import com.example.paginglistdemo.headList.TestAdapter

class PullRefreshActivity : AppCompatActivity() {
    private lateinit var listView: RecyclerView
    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var btnAddData:Button
    private var count = 4
    var listData: ArrayList<TestData> = arrayListOf()
    private lateinit var listAdapter :TestAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_refresh)
        listView = findViewById(R.id.page_list)
        refreshLayout = findViewById(R.id.refresh_layout)
        btnAddData = findViewById(R.id.btn_add_data)
        initRecyclerView()
        btnAddData.setOnClickListener {
            Handler(Looper.getMainLooper()).post {
                var testData = TestData("测试$count", "测试数据$count")
                listData.add(testData)
                Toast.makeText(this,"添加数据成功$count",Toast.LENGTH_SHORT).show()
                count++
            }
        }
    }

    private fun initRecyclerView() {
        listData.add(TestData("测试1", "测试数据1"))
        listData.add(TestData("测试2", "测试数据2"))
        listData.add(TestData("测试3", "测试数据3"))

        listAdapter = TestAdapter(listData)
        listView.adapter = listAdapter
        listView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        listView.layoutManager = LinearLayoutManager(this)
        //设置进度条颜色
        refreshLayout.setColorSchemeColors(resources.getColor(R.color.black))
        //设置进度条背景颜色
        refreshLayout.setProgressBackgroundColorSchemeColor(resources.getColor(R.color.teal_200))
        //设置下拉动作监听
        refreshLayout.setOnRefreshListener {
            //刷新数据
            listAdapter.notifyDataSetChanged()
            Handler(Looper.getMainLooper()).postDelayed({
                //更新刷新状态
                refreshLayout.isRefreshing = false
            }, 2000)
        }
    }
}