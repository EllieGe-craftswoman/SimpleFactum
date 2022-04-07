package com.ellies.simplefactum

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingRVAdapter : RecyclerView.Adapter<BindingRVAdapter.BindingVH>() {

    var items: List<FactumItemViewModel> = emptyList()
    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingVH {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?: 0,
            parent,
            false
        )
        return BindingVH(binding)
    }

    override fun onBindViewHolder(holder: BindingVH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        if(!viewTypeToLayoutId.containsKey(item.category.ordinal)){
            viewTypeToLayoutId[item.category.ordinal] = item.layoutId
        }
        return item.category.ordinal
    }

    fun updateItems(items: List<FactumItemViewModel>?) {
        this.items = items ?: emptyList()
        notifyDataSetChanged()
    }


    class BindingVH (private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemViewModel: FactumItemViewModel){
            binding.setVariable(BR.itemViewModel, itemViewModel)
        }
    }


}