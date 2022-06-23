package com.example.heroes

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.heroes.data.response.CHARACTER_ID_EXTRA
import com.example.heroes.data.response.CharacterResponse
import com.example.heroes.data.response.characterList
import com.example.heroes.databinding.ActivityDetailBinding
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class DetailActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val CharacterID = intent.getIntExtra(CHARACTER_ID_EXTRA, -1)
        val Character = CharacterFromID(CharacterID)
        if(Character != null)
        {
            val string = "${Character.thumbnail.path}.landscape_medium.${Character.thumbnail.extension}"
            val imgBtm = getBitmapFromURL(string)

            binding.cover.setImageBitmap(imgBtm)
            binding.title.text = Character.description
            binding.description.text = Character.description
            binding.characterName.text = Character.name
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
    private fun CharacterFromID(bookID: Int): CharacterResponse?
    {
        for(Character in characterList)
        {
            if(Character.id == bookID)
                return Character
        }
        return null
    }
}