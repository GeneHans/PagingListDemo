package com.example.paginglistdemo.headList

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.example.paginglistdemo.R

/**
 * 测试使用的HeaderView
 */
class TestHeaderView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.layaout_header_view_item,this)
    }
}