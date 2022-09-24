package com.abhi.grocerylist.data.repositories

import com.abhi.grocerylist.data.db.entities.ShoppingItem
import com.abhi.grocerylist.data.db.ShoppingDatabase

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}