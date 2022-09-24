package com.abhi.grocerylist.ui.shoppinglist

import com.abhi.grocerylist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}