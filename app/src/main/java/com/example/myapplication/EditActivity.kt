package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.plant1
    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() {
        binding.apply {
            bNext.setOnClickListener {
                indexImage++
                if (indexImage > imageIdList.size - 1) indexImage = 0
                imageId = imageIdList[indexImage]
                imageView.setImageResource(imageId)


            }
            bDone.setOnClickListener {
                val plant = Plant(imageId, edTitile.text.toString(), edDesk.text.toString())
                val editIntent = Intent().apply {
                    putExtra("plant", plant)
                }
                setResult(RESULT_OK, editIntent)
                finish()
            }
        }
    }
}