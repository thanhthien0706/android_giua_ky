package com.example.giuaky

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() {

    private lateinit var imgDTinh: ImageView
    private lateinit var tvNameDTinh: TextView
    private lateinit var tvPopulationDTinh: TextView
    private lateinit var tvDescriptionDTinh: TextView
    private lateinit var btnChangeImgTinh: ImageButton
    val REQUEST_CODE: Int = 100

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

        btnChangeImgTinh.setOnClickListener {
            xuLyDoiAnh()
        }


        imgDTinh.setImageResource(tinhData.resouerceId)
        tvNameDTinh.setText(tinhData.name)
        tvPopulationDTinh.setText(tinhData.population)
        tvDescriptionDTinh.setText(tinhData.description)


    }

    private fun xuLyDoiAnh() {
        openGalleryForImage()
    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            imgDTinh.setImageURI(data?.data)
        }
    }


}