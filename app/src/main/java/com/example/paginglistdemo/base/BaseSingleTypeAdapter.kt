package com.example.paginglistdemo.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseSingleTypeAdapter :
    RecyclerView.Adapter<BaseSingleViewHolder>() {

    abstract val resource: Int
    abstract var arrayData: ArrayList<BaseListDataEntity>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseSingleViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return BaseSingleViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseSingleViewHolder, position: Int) {

    }



    override fun getItemCount(): Int {
        return arrayData.size
    }

}