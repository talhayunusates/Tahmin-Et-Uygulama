package com.example.tahminetuygulama

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tahminetuygulama.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {

    private var randomsayi = 0
    private var sayac = 5



    private lateinit var binding: ActivityTahminBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTahminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.apply {
            randomsayi = Random.nextInt(100)
            Log.e("Random : ", randomsayi.toString())
            buttontahmin.setOnClickListener {
                sayac = sayac - 1
                val tahmin = editTextText.text.toString().toInt()
                if (tahmin == randomsayi) {
                    val intent = Intent(this@TahminActivity, SonucActivity2::class.java)
                    intent.putExtra("sonuc",true)
                    startActivity(intent)

                }
                if (tahmin > randomsayi) {
                    arttir.text = "Azalt"
                    kalanHak.text="Kalan Hak : $sayac"

                }
                if (tahmin < randomsayi) {
                    arttir.text = "Arttir"
                    kalanHak.text="Kalan Hak : $sayac"

                }
                if (sayac == 0) {
                    val intent = Intent(this@TahminActivity, SonucActivity2::class.java)
                    intent.putExtra("sonuc",false)
                    startActivity(intent)

                }
                editTextText.setText("")
            }
        }
    }
}