package com.ellies.simplefactum

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("items")
        fun bindItemViewModels(recyclerView: RecyclerView, items: List<FactumItemViewModel>?) {
            val adapter = getOrCreateAdapter(recyclerView)
            adapter.updateItems(items)
        }

        private fun getOrCreateAdapter(recyclerView: RecyclerView): BindingRVAdapter {
            return if (recyclerView.adapter != null && recyclerView.adapter is BindingRVAdapter) {
                recyclerView.adapter as BindingRVAdapter
            } else {
                val bindingRVAdapter = BindingRVAdapter()
                recyclerView.adapter = bindingRVAdapter
                bindingRVAdapter
            }
        }
    }


}