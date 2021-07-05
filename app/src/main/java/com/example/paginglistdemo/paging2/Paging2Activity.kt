package com.example.paginglistdemo.paging2

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paginglistdemo.R

class Paging2Activity : AppCompatActivity() {
    private lateinit var list: RecyclerView
    private var adapter:Paging2Adapter = Paging2Adapter()
    //activity-ktx
    private val viewModel: Paging2ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging2)
        list = findViewById(R.id.list_paging2)
        initRecyclerView()
        //设置list数据变化监听
        viewModel.concertList?.observe(this, Observer { adapter.submitList(it) })
    }

    /**
     * 初始化list
     */
    private fun initRecyclerView() {
        list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
    }
}