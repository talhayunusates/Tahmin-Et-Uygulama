package com.example.tahminetuygulama

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tahminetuygulama.databinding.ActivitySonuc2Binding

class SonucActivity2 : AppCompatActivity() {



    private lateinit var binding: ActivitySonuc2Binding
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        binding = ActivitySonuc2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.apply {
            val sonuc = intent.getBooleanExtra("sonuc",false)

            if (sonuc){
                kaybettiniz.text = "Kazandınız"
                kayip.setImageResource(R.drawable.basari_resim)

            }else{
                kaybettiniz.text = "Kaybettiniz"
                kayip.setImageResource(R.drawable.kayip_resim)

            }

            buttonTekrar.setOnClickListener {
                val intent = Intent(this@SonucActivity2, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}