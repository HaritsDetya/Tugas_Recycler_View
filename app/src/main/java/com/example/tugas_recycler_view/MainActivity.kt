package com.example.tugas_recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_recycler_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var diponegoro: String
    private lateinit var kartini: String
    private lateinit var dewantara: String
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        diponegoro = getString(R.string.deskripsi_diponegoro)
        kartini = getString(R.string.deskripsi_kartini)
        dewantara = getString(R.string.deskripsi_dewantara)

        fun generateDummy(): List<Pahlawan> {
            return listOf(
                Pahlawan(namaPahlawan = "Pangeran Diponegoro", gambarPahlawan = R.drawable.pangeran_diponegoro, deskripsiPahlawan = diponegoro),
                Pahlawan(namaPahlawan = "Raden Ajeng Kartini", gambarPahlawan = R.drawable.kartini, deskripsiPahlawan = kartini),
                Pahlawan(namaPahlawan = "Ki Hajar Dewantara", gambarPahlawan = R.drawable.ki_hajar_dewantara, deskripsiPahlawan = dewantara),
            )
        }

        val adapterPahlawan = MyAdapter(generateDummy()){
                pahlawan ->  Toast.makeText(this, "${pahlawan.namaPahlawan}",
            Toast.LENGTH_SHORT).show()
        }
        with(binding){
            recycle.apply {
                adapter = adapterPahlawan
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}