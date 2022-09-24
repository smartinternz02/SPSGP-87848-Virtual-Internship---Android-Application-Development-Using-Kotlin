package com.abhi.grocerylist

import android.app.Application
import com.abhi.grocerylist.data.db.ShoppingDatabase
import com.abhi.grocerylist.data.repositories.ShoppingRepository
import com.abhi.grocerylist.ui.shoppinglist.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShoppingApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind() from this.singleton<Any?, ShoppingDatabase> { ShoppingDatabase(this.instance()) }
        bind() from this.singleton {
            ShoppingRepository(
                this.instance()
            )
        }
        bind() from this.provider {
            ShoppingViewModelFactory(
                this.instance()
            )
        }
    }
}