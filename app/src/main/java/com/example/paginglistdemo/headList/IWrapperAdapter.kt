package com.example.paginglistdemo.headList



interface IWrapperAdapter {
    /**
     * 获取头部item数量
     * @return
     */
    fun getHeaderCount(): Int

    /**
     * 获取尾部item数量
     * @return
     */
    fun getFooterCount(): Int
}

