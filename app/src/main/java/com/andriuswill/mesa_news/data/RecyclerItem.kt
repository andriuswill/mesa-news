package com.andriuswill.mesa_news.data

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

class RecyclerItem (
    val data: Any,
    @LayoutRes val layoutId: Int,
    private val variableId: Int
) {
    fun bind(binding: ViewDataBinding) {
        binding.setVariable(variableId, data)
    }
}