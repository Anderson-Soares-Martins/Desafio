package com.example.heroes

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.heroes.CharacterClickListerner
import com.example.heroes.data.response.CharacterResponse
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class CardViewHolder(
    private val cardCellBinding: CardCellBinding,
    private val clickListener: CharacterClickListerner
) : RecyclerView.ViewHolder(cardCellBinding.root)
{
    fun bindBook(character: CharacterResponse)
    {
        cardCellBinding.cover.setImageResource(character.)
        cardCellBinding.title.text = character.name
        cardCellBinding.author.text = character.description

        cardCellBinding.cardView.setOnClickListener{
            clickListener.onClick(character)
        }
    }
    private fun getBitmapFromURL(url: String): Bitmap? {
        return try {
            val src = URL(url)
            val connection: HttpURLConnection = src.openConnection() as HttpURLConnection
            connection.setDoInput(true)
            connection.connect()
            val input: InputStream = connection.getInputStream()
            BitmapFactory.decodeStream(input)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}