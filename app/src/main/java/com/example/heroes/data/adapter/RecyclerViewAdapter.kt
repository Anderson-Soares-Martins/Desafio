package com.example.heroes.data.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.heroes.R
import com.example.heroes.data.response.CharacterResponse
import com.example.heroes.data.response.characterList


class RecyclerViewAdapter(list: List<CharacterResponse>) : Adapter<RecyclerViewAdapter.ViewHolder>() {
    var characters = list

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun getTextView(): TextView? {
            return itemView.findViewById<TextView>(R.id.textView)
        }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters.get(position)
        holder.getTextView()?.text ?: character.name
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}