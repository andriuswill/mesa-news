package com.andriuswill.mesa_news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class RecyclerBindingAdapter<T> : RecyclerView.Adapter<RecyclerBindingAdapter.BindingHolder> {

    private var itemLayout: Int = 0
    private var itemVarId: Int = 0

    private var items: ArrayList<T> = ArrayList()
    private var onItemClickListener: OnItemClickListener<T>? = null

    interface OnItemClickListener<T> {
        fun onItemClick(position: Int, view: View, item: T)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<T>) {
        this.onItemClickListener = onItemClickListener
    }

    fun setList(items: ArrayList<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun getItems(): ArrayList<T> {
        return this.items
    }

    fun addItem(item: T) {
        this.items.add(item)
        notifyItemInserted(itemCount - 1)
    }

    fun addAll(items: ArrayList<T>) {
        for (item in items) {
            addItem(item)
        }
    }

   /* constructor(itemLayout: Int, itemVarId: Int, items: ArrayList<T>) {
        this.itemLayout = itemLayout
        this.itemVarId = itemVarId
        this.items = items
    }*/

    constructor(itemLayout: Int, itemVarId: Int) {
        this.itemLayout = itemLayout
        this.itemVarId = itemVarId
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return BindingHolder(view)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {

        val item = items[position]

        holder.binding?.root?.setOnClickListener { view ->
            onItemClickListener?.onItemClick(holder.adapterPosition, view, item)
        }

        holder.binding?.setVariable(itemVarId, item)
        holder.binding?.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return itemLayout
    }

    class BindingHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ViewDataBinding? = DataBindingUtil.bind(view)
    }
}