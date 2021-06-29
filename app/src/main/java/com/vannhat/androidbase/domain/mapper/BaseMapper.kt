package com.vannhat.androidbase.domain.mapper

import com.vannhat.androidbase.data.model.BaseData
import com.vannhat.androidbase.domain.entities.BaseModel

abstract class BaseMapper<in T : BaseData, R : BaseModel> {

    abstract fun map(data: T): R

    open fun nullableMap(entity: T?): R? {
        return entity?.let { map(it) }
    }

    open fun map(dataCollection: Collection<T>): List<R> {
        return dataCollection.map { map(it) }
    }

    open fun nullableMap(dataCollection: Collection<T>?): List<R>? {
        return dataCollection?.map { map(it) }
    }
}
