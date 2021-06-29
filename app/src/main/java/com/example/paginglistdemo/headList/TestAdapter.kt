package com.example.paginglistdemo.headList

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
 * 原始 RecyclerView  item封装adapter
 */
class TestAdapter(arrayData: ArrayList<TestData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listData: List<TestData> = arrayData
    private var itemClickListener:IItemClickListener? = null

    fun setItemClickListener(itemClickListener: IItemClickListener){
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_1 -> {
                var view: View =
                        LayoutInflater.from(parent.context).inflate(R.layout.item_test_layout, parent, false)
                var viewHolder = TestViewHolder1(view,itemClickListener)
                viewHolder
            }
            TYPE_2 -> {
                var view: View =
                        LayoutInflater.from(parent.context).inflate(R.layout.item2_test_layout, parent, false)
                var viewHolder = TestViewHolder2(view,itemClickListener)
                viewHolder
            }
            else -> {
                var view: View =
                        LayoutInflater.from(parent.context).inflate(R.layout.item_test_layout, parent, false)
                var viewHolder = TestViewHolder1(view,itemClickListener)
                viewHolder
            }
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position % 2) {
            0 -> {
                TYPE_1
            }
            1 -> {
                TYPE_2
            }
            else -> {
                TYPE_1
            }
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_1 -> {
                if (holder is TestViewHolder1) {
                    holder.textView?.text = listData[position].textMessage
                    holder.setItemClickListener(position)
                }
            }
            TYPE_2 -> {
                if (holder is TestViewHolder2) {
                    holder.textView?.text = listData[position].textMessage
                    holder.setItemClickListener(position)
                }
            }
            else -> {
                if (holder is TestViewHolder1) {
                    holder.textView?.text = listData[position].textMessage
                    holder.setItemClickListener(position)
                }
            }
        }
    }

    class TestViewHolder1(itemView: View,var itemClickListener: IItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null
        var btnTest: Button? = null
        fun setItemClickListener(position: Int){
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(position)
            }
        }

        init {
            textView = itemView.findViewById(R.id.text_item_test)
            btnTest = itemView.findViewById(R.id.btn_item_test)
        }
    }

    class TestViewHolder2(itemView: View,var itemClickListener: IItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null
        var btnTest: Button? = null
        fun setItemClickListener(position: Int){
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(position)
            }
        }
        init {
            textView = itemView.findViewById(R.id.text2_item_test)
            btnTest = itemView.findViewById(R.id.btn2_item_test)
        }
    }

    companion object {
        const val TYPE_1 = 1
        const val TYPE_2 = 2
    }
}