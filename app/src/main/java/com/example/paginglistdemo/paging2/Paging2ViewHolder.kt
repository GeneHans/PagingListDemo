package com.example.paginglistdemo.paging2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.paginglistdemo.R
import com.example.paginglistdemo.room.TestListPageEntity

class Paging2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var textTitle: TextView = itemView.findViewById(R.id.item_title)
    private var textContent: TextView = itemView.findViewById(R.id.item_content)

    fun bindTo(data: TestListPageEntity?) {
        textTitle.text = data?.title
        textContent.text = data?.content
    }

}