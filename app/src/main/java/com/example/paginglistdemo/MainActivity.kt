package com.example.paginglistdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paginglistdemo.base.IItemClickListener
import com.example.paginglistdemo.headList.HeadListActivity
import com.example.paginglistdemo.mainActivitylist.MainListAdapter
import com.example.paginglistdemo.mainActivitylist.MainListData
import com.example.paginglistdemo.paging2.Paging2Activity
import com.example.paginglistdemo.pullload.PullLoadMoreActivity
import com.example.paginglistdemo.pullrefreash.PullRefreshActivity
import com.example.paginglistdemo.room.DataBaseActivity
import com.example.paginglistdemo.util.Logger

class MainActivity : AppCompatActivity() {
    private lateinit var listMain: RecyclerView
    private val HEAD_LIST = 0
    private val PULL_REFRESH = 1
    private val PULL_LOAD = 2
    private val DATA_BASE = 3
    private val PAGING2 = 4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listMain = findViewById(R.id.list_main)
        initData()
        setSimpleAdapter(initData())
    }
    private fun initData(): ArrayList<MainListData> {
        var listData = ArrayList<MainListData>()
        listData.add(MainListData("带头尾item Recyclerview", "可以添加头尾item"))
        listData.add(MainListData("下拉刷新控件", "下拉刷新控件，最简单的demo"))
        listData.add(MainListData("上拉加载", "上拉加载简单demo"))
        listData.add(MainListData("数据库操作", "数据库添加和清空列表操作"))
        listData.add(MainListData("Paging2", "Paging2实现分页加载"))
        return listData
    }

    private fun setSimpleAdapter(listData: ArrayList<MainListData>) {
        var testAdapter = MainListAdapter(listData)
        testAdapter.setItemClickListener(object : IItemClickListener {
            override fun onItemClick(position: Int) {
                when(position){
                    HEAD_LIST -> {
                        val intent = Intent()
                        intent.setClass(this@MainActivity,HeadListActivity::class.java)
                        startActivity(intent)
                    }
                    PULL_REFRESH ->{
                        val intent = Intent()
                        intent.setClass(this@MainActivity,PullRefreshActivity::class.java)
                        startActivity(intent)
                    }
                    PULL_LOAD ->{
                        val intent = Intent()
                        intent.setClass(this@MainActivity,PullLoadMoreActivity::class.java)
                        startActivity(intent)
                    }
                    DATA_BASE ->{
                        val intent = Intent()
                        intent.setClass(this@MainActivity,DataBaseActivity::class.java)
                        startActivity(intent)
                    }
                    PAGING2 ->{
                        val intent = Intent()
                        intent.setClass(this@MainActivity,Paging2Activity::class.java)
                        startActivity(intent)
                    }
                    else ->{
                        Logger.instance.toast("点击了其他项",this@MainActivity)
                    }
                }
            }
        })
        listMain.adapter = testAdapter
        listMain.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        listMain.layoutManager = LinearLayoutManager(this)
    }
}