package com.example.paginglistdemo.mainActivitylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paginglistdemo.base.BaseSingleTypeAdapter
import com.example.paginglistdemo.R
import com.example.paginglistdemo.base.BaseListDataEntity
import com.example.paginglistdemo.base.IItemClickListener

/**
 * MainActivity的List列表的Adapter
 */
class MainListAdapter(var listData: ArrayList<MainListData>) : RecyclerView.Adapter<MainListViewHolder>() {

    private var itemClickListener: IItemClickListener? = null
    fun setItemClickListener(itemClickListener: IItemClickListener){
        this.itemClickListener = itemClickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_page, parent, false)
        return MainListViewHolder(view,itemClickListener)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.setData(listData[position])
        holder.setItemClickListener(position)
    }

}