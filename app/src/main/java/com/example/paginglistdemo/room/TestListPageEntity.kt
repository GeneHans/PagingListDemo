package com.example.paginglistdemo.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 测试数据表，表名称：test_page_list
 */
@Entity(tableName = TestListPageEntity.tableName)
class TestListPageEntity(
    @PrimaryKey var id: Long,
    @ColumnInfo var title: String,
    @ColumnInfo var content: String
) {

    override fun toString(): String {
        return "id=$id   title=$title   content=$content"
    }

    override fun equals(other: Any?): Boolean {
        return other is TestListPageEntity && other.id == this.id
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + content.hashCode()
        return result
    }

    companion object {
        const val tableName = "test_page_list"
    }
}