package com.example.giuaky

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity() {

    private lateinit var imgDTinh: ImageView
    private lateinit var tvNameDTinh: TextView
    private lateinit var tvPopulationDTinh: TextView
    private lateinit var tvDescriptionDTinh: TextView
    private lateinit var btnChangeImgTinh: ImageButton

    private lateinit var tinhData: Tinh

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle: Bundle = intent.extras!!
        if (bundle == null) {
            return
        }

        tinhData = bundle.get("object_tinh") as Tinh

        imgDTinh = findViewById(R.id.img_d_tinh)
        tvNameDTinh = findViewById(R.id.tv_name_d_tinh)
        tvPopulationDTinh = findViewById(R.id.tv_population_d_tinh)
        tvDescriptionDTinh = findViewById(R.id.tb_description_d_tinh)
        btnChangeImgTinh = findViewById(R.id.btn_change_img_tinh)

        btnChangeImgTinh.setOnClickListener{
            xuLyDoiAnh()
        }


        imgDTinh.setImageResource(tinhData.resouerceId)
        tvNameDTinh.setText(tinhData.name)
        tvPopulationDTinh.setText(tinhData.population)
        tvDescriptionDTinh.setText(tinhData.description)
    }

    private fun xuLyDoiAnh() {
//        val listImage
    }
}