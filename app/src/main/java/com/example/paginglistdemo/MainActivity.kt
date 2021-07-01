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
import com.example.paginglistdemo.pullrefreash.PullRefreshActivity
import com.example.paginglistdemo.util.Logger

class MainActivity : AppCompatActivity() {
    private lateinit var listMain: RecyclerView
    private val HEAD_LIST = 0
    private val PULL_REFRESH = 1
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
        listData.add(MainListData("下拉刷新控件", "下拉刷新控件，未添加adapter刷新逻辑"))
        listData.add(MainListData("test3", "测试3"))
        listData.add(MainListData("test4", "测试4"))
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