package com.example.paginglistdemo.pullload

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * 加载更多滑动监听，用来监听列表是否滑动到了load more的item
 */
abstract class EndlessRecyclerOnScrollListener : RecyclerView.OnScrollListener() {
    //用来标记滑动方向是否向上
    private var isSlidingUpward = false
    //是否正在拉取数据，如果正在拉取数据就停止加载
    var isLoadingData = false

    /**
     * 滑动状态变化回调
     */
    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        var manager = recyclerView.layoutManager as LinearLayoutManager
        // 当不滑动时
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            //获取最后一个完全显示的itemPosition
            var lastItemPosition = manager.findLastCompletelyVisibleItemPosition()
            var itemCount = manager.itemCount
            // 判断是否滑动到了最后一个item，并且是向上滑动
            if (lastItemPosition == (itemCount - 1) && isSlidingUpward) {
                //如果当前没有在加载数据，则加载数据
                if(!isLoadingData) {
                    isLoadingData = true
                    //加载更多
                    onLoadMore()
                }
            }
        }
    }

    //加载更多方法
    abstract fun onLoadMore()


    /**
     * 列表滑动完成时回调
     */
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        // 大于0表示正在向上滑动，小于等于0表示停止或向下滑动
        isSlidingUpward = dy > 0;
    }

}