package com.example.paginglistdemo.base

/**
 * 监听item点击
 */
interface IItemClickListener {
    /**
     * item点击事件回调
     * @param:点击位置
     */
    fun onItemClick(position: Int)
}