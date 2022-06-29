package com.yulian.yulian_isyara

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.yulian.yulian_isyara.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<pemain>()
        listPemain.add(
            pemain(
                "Beckham",
                R.drawable.beckham,
                "penyerang",
                "2.00 M",
                "Bree (Belgia)",
                "11 Mei 1980"
            )
        )
        listPemain.add(
            pemain(
                "benjamin",
                R.drawable.benjamin,
                "Penyerang",
                "1,85 M",
                "Lyon (Perancis)",
                "19 Desember 1980"
            )
        )
        listPemain.add(
            pemain(
                "Ibrahimovic",
                R.drawable.ibrahimovic,
                "penyerang",
                "1.74 M",
                "Rio deJaneiro (Brazil)",
                "11 Mei 1980"
            )
        )
        listPemain.add(
            pemain(
                "Jeremi",
                R.drawable.jeremi,
                "penyerang",
                "1.84 M",
                "Camas (Sevilla)",
                "30 Maret 1980"
            )
        )
        listPemain.add(
            pemain(
                "Neymar",
                R.drawable.ney,
                "penyerang",
                "1.85 M",
                "Marseille (Pranciss)",
                "22 Juni 1980"
            )
        )

        binding.list.adapter =
            AdapterTeamBola(this, listPemain, object : AdapterTeamBola.OnClickListener {
                override fun detailData(item: pemain?) {
                    Dialog(this@MainActivity).apply {
                        requestWindowFeature(Window.FEATURE_NO_TITLE)
                        setCancelable(true)
                        setContentView(R.layout.detail_data_pemain)

                        val image = this.findViewById<ImageView>(R.id.image_pemain)
                        val nama = this.findViewById<TextView>(R.id.txt_namapemain)
                        val posisi = this.findViewById<TextView>(R.id.txtposisi)
                        val tinggibadan = this.findViewById<TextView>(R.id.txttinggibadan)
                        val tempatlahir = this.findViewById<TextView>(R.id.txt_tempatlahir)
                        val tgllahir = this.findViewById<TextView>(R.id.txt_tanggallahir)
                        val btn = this.findViewById<Button>(R.id.btnclose)

                        image.setImageResource(item?.foto ?: 0)
                        nama.text = "${item?.nama}"
                        posisi.text = "${item?.posisi}"
                        tinggibadan.text = "${item?.tinggi}"
                        tempatlahir.text = "${item?.tempatlahir}"
                        tgllahir.text = "${item?.tgllahir}"

                        btn.setOnClickListener {
                            this.dismiss()
                        }
                    }.show()
                }
            })
        }
    }

