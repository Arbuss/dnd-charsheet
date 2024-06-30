package com.arbuss.data.repository

import com.arbuss.data.model.DataModel

interface CRUD<T: DataModel> {
    fun getAll(): List<T>

    fun add(item: T)

    fun get(id: Int): T?

    fun update(item: T)

    fun delete(item: T)

    fun delete(id: Int)
}