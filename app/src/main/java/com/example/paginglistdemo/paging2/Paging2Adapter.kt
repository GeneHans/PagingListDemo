package com.example.paginglistdemo.paging2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.paginglistdemo.R
import com.example.paginglistdemo.room.TestListPageEntity

class Paging2Adapter :
    PagedListAdapter<TestListPageEntity, Paging2ViewHolder>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: Paging2ViewHolder, position: Int) {
        val concert: TestListPageEntity? = getItem(position)
        holder.bindTo(concert)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Paging2ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_page, parent, false)
        return Paging2ViewHolder(view)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TestListPageEntity>() {
            // The ID property identifies when items are the same.
            override fun areItemsTheSame(oldItem: TestListPageEntity, newItem: TestListPageEntity) =
                oldItem.id == newItem.id

            // If you use the "==" operator, make sure that the object implements
            // .equals(). Alternatively, write custom data comparison logic here.
            override fun areContentsTheSame(
                oldItem: TestListPageEntity, newItem: TestListPageEntity
            ) = oldItem == newItem
        }
    }
}

