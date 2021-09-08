package com.abdul.telstraapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(val wordsData: Array<String>) : RecyclerView.Adapter<WordsAdapter.WordsViewHolder>() {

    class WordsViewHolder(rowView: View) :RecyclerView.ViewHolder(rowView){
        val rowTextView: TextView = rowView.findViewById(R.id.tvRow)
    }

    /**
     * mayur -- he has buy/create new planks for rows --
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        var createdRow = LayoutInflater.from(parent.context).inflate(R.layout.row_rv,parent,false)
        return WordsViewHolder(createdRow)
    }

    /**
     * mohit -- handwriting is good, he'll write on the plank
     */
    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        holder.rowTextView.text = wordsData[position]
    }

    /**
     * batula: keep the count of data items
     */
    override fun getItemCount(): Int {
        return wordsData.size
    }
}