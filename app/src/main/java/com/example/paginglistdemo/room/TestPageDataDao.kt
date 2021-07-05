package com.example.paginglistdemo.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import io.reactivex.rxjava3.core.Flowable

/**
 * room数据操作类
 */
@Dao
abstract class TestPageDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertTestPageData(data: TestListPageEntity)

    @Query("DELETE FROM " + TestListPageEntity.tableName)
    abstract suspend fun deleteAllData()

    @Query("SELECT * FROM " + TestListPageEntity.tableName + " ORDER BY id")
    abstract fun queryAll(): DataSource.Factory<Int,TestListPageEntity>?

    @Query("SELECT * FROM " + TestListPageEntity.tableName + " ORDER BY id")
    abstract fun queryAllByRxjava(): Flowable<List<TestListPageEntity>?>

    @Query("SELECT * FROM " + TestListPageEntity.tableName + " where id = (:id)")
    abstract fun queryById(id: Long): TestListPageEntity?

    @Query("SELECT * FROM " + TestListPageEntity.tableName + " where id >= (:id1) and id <=(:id2)")
    abstract fun queryBetweenIds(id1: Long,id2:Long): Flowable<List<TestListPageEntity>?>


    @Query("delete from " + TestListPageEntity.tableName + " where id =(:id)")
    abstract fun deleteById(id: Long)

    @Transaction
    open fun deleteDataById(userId: Long) {
        if (queryById(userId) != null) {
            deleteById(userId)
        }
    }
}