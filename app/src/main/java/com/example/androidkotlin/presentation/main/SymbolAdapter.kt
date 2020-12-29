package com.example.androidkotlin.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidkotlin.R
import com.example.androidkotlin.data.local.models.models.Symbol
import kotlinx.android.synthetic.main.a_symbol.view.*

class SymbolAdapter(
    private val symbolList: MutableList<Symbol>,
    var clickListener: OnSymbolItemClickListener
) :
    RecyclerView.Adapter<SymbolAdapter.SymbolViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymbolViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.a_symbol, parent, false)
        return SymbolViewHolder(view)
    }

    override fun onBindViewHolder(holder: SymbolViewHolder, position: Int) {
        val symbol = symbolList.elementAtOrNull(position)
        holder.symbolText.text = symbol?.symbol
        holder.nameText.text = symbol?.name

        holder.initialize(symbolList.get(position), clickListener)
    }

    override fun getItemCount(): Int {
        return symbolList.size
    }


    class SymbolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val symbolText: TextView = itemView.findViewById(R.id.symbol)
        val nameText: TextView = itemView.findViewById(R.id.name)

        fun initialize(symbol: Symbol, action: OnSymbolItemClickListener) {
            symbolText.text = symbol.symbol
            nameText.text = symbol.name

            itemView.setOnClickListener() {
                action.onItemClick(symbol, adapterPosition)
            }
        }
    }

    interface OnSymbolItemClickListener {
        fun onItemClick(symbol: Symbol, position: Int)
    }
}