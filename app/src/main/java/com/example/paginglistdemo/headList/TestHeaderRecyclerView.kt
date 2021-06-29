package com.example.paginglistdemo.headList

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class TestHeaderRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {
    private var headerViews: ArrayList<View> = ArrayList()
    private var footerViews: ArrayList<View> = ArrayList()

    init {

    }

    fun addHeaderView(headerView: View) {
        headerViews.clear()
        headerViews.add(headerView)
    }

    fun addFooterView(footerView: View) {
        footerViews.clear()
        footerViews.add(footerView)
    }

    fun setAdapter(testAdapter: TestAdapter) {
        var adapter = TestHeaderAdapter(headerViews, footerViews, testAdapter)
        this.adapter = adapter
    }

    companion object {

    }
}