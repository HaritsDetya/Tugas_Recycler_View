package com.example.tugas_recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_recycler_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var hercules: String
    private lateinit var prometheus: String
    private lateinit var achilles: String
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hercules = getString(R.string.deskripsi_hercules)
        prometheus = getString(R.string.deskripsi_prometheus)
        achilles = getString(R.string.deskripsi_achilles)

        fun generateDummy(): List<Pahlawan> {
            return listOf(
                Pahlawan(namaPahlawan = "Hercules", gambarPahlawan = R.drawable.hercules, deskripsiPahlawan = hercules),
                Pahlawan(namaPahlawan = "Prometheus", gambarPahlawan = R.drawable.prometheus, deskripsiPahlawan = prometheus),
                Pahlawan(namaPahlawan = "Achilles", gambarPahlawan = R.drawable.achilles, deskripsiPahlawan = achilles),
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