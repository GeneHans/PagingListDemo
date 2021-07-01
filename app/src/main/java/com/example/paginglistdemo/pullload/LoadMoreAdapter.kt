package com.example.paginglistdemo.pullload

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.paginglistdemo.R
import com.example.paginglistdemo.base.IItemClickListener
import com.example.paginglistdemo.entity.TestData

/**
 * Load More列表的Adapter demo
 * 包含两个Item，一个是显示具体数据的item，另一个是加载更多Item
 */
class LoadMoreAdapter(arrayData: ArrayList<TestData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listData: ArrayList<TestData> = arrayData
    private var itemClickListener: IItemClickListener? = null

    fun setItemClickListener(itemClickListener: IItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            LOAD_MORE -> {
                var view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_load_more, parent, false)
                var viewHolder = LoadMoreViewHolder(view, itemClickListener)
                viewHolder
            }
            else -> {
                var view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_test_layout, parent, false)
                var viewHolder = DataViewHolder(view, itemClickListener)
                viewHolder
            }
        }
    }

    override fun getItemCount(): Int {
        return listData.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == itemCount - 1) {
            LOAD_MORE
        } else {
            DATA_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            LOAD_MORE -> {
                if (holder is LoadMoreViewHolder) {
                    holder.setItemClickListener(position)
                }
            }
            else -> {
                if (holder is DataViewHolder) {
                    holder.textView?.text = listData[position].textMessage
                    holder.btnTest?.text = listData[position].btnText
                    holder.setItemClickListener(position)
                }
            }
        }
    }

    class DataViewHolder(itemView: View, var itemClickListener: IItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null
        var btnTest: Button? = null
        fun setItemClickListener(position: Int) {
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(position)
            }
        }

        init {
            textView = itemView.findViewById(R.id.text_item_test)
            btnTest = itemView.findViewById(R.id.btn_item_test)
        }
    }

    class LoadMoreViewHolder(itemView: View, var itemClickListener: IItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {

        fun setItemClickListener(position: Int) {
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(position)
            }
        }
    }

    companion object {
        const val DATA_ITEM = 1
        const val LOAD_MORE = 2
    }
}