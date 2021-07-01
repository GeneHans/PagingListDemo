package com.example.paginglistdemo.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.paginglistdemo.R
import kotlinx.coroutines.runBlocking

/**
 * 用来数据库添加数据和删除数据的测试Activity
 */
class DataBaseActivity : AppCompatActivity() {
    private lateinit var btnAdd: Button
    private lateinit var btnClear: Button
    private var count = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)
        btnAdd = findViewById(R.id.btn_add_data)
        btnClear = findViewById(R.id.btn_clear_data)
        btnAdd.setOnClickListener {
            runBlocking {
                DemoWorkDataBase.getInstance(this@DataBaseActivity).getTestPageDataDao()
                    .insertTestPageData(TestListPageEntity(count, "title$count", "content$count"))
                count++
            }
        }

        btnClear.setOnClickListener {
            runBlocking {
                DemoWorkDataBase.getInstance(this@DataBaseActivity).getTestPageDataDao()
                    .deleteAllData()
                count = 0
            }
        }
    }
}