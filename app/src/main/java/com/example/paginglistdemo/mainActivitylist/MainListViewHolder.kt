package com.example.paginglistdemo.mainActivitylist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.paginglistdemo.R
import com.example.paginglistdemo.base.BaseSingleViewHolder
import com.example.paginglistdemo.base.IItemClickListener

/**
 * MainActivity的ViewHolder
 */
class MainListViewHolder(itemView: View,var itemClickListener: IItemClickListener?) : RecyclerView.ViewHolder(itemView) {
    private var textTitle: TextView = itemView.findViewById(R.id.item_title)
    private var textContent: TextView = itemView.findViewById(R.id.item_content)
    fun setData(data: MainListData) {
        textTitle.text = data.textTitle
        textContent.text = data.textContent
    }
    fun setItemClickListener(position: Int){
        itemView.setOnClickListener {
            itemClickListener?.onItemClick(position)
        }
    }
}