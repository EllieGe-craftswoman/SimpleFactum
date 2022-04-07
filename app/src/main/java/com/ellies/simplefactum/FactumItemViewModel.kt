package com.ellies.simplefactum

import androidx.annotation.LayoutRes

interface FactumItemViewModel {
    //@get:LayoutRes
    val layoutId: Int
    val category: Category
}

class HeaderViewModel(val title: String) : FactumItemViewModel{
    override val layoutId: Int
        get() = R.layout.item_header
    override val category: Category
        get() = Category.HEADER

}

class ToReadViewModel(val title: String, val description: String?) : FactumItemViewModel{
    override val layoutId: Int
        get() = R.layout.item_to_read
    override val category: Category
        get() = Category.TO_READ

}

class ToWatchViewModel(val title: String, val duration: Int?) : FactumItemViewModel{
    override val layoutId: Int
        get() = R.layout.item_to_watch
    override val category: Category
        get() = Category.TO_WATCH

}