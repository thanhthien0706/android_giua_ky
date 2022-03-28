package com.example.giuaky

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var rcvTinh: RecyclerView
    private lateinit var layoutMain: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcvTinh = findViewById(R.id.rcv_tinh)
        layoutMain = findViewById(R.id.layout_main)

        rcvTinh.layoutManager = LinearLayoutManager(this)

        rcvTinh.adapter = TinhAdapter(this, setDataTinh())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_giua_ky, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_change_color -> {
                val rnd: Random = Random
                val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
                layoutMain.setBackgroundColor(color)
            }
            R.id.item_about -> Toast.makeText(
                this,
                "Ứng dụng xem thông tin tỉnh",
                Toast.LENGTH_LONG
            ).show()
        }
        return true
    }

    private fun setDataTinh(): List<Tinh> {
        return listOf(
            Tinh(R.drawable.khanh_hoa, "Khánh Hòa", "1.246.358", "Tinh nay rat la dep"),
            Tinh(R.drawable.hue, "Huế", "1.137.045", "Tinh nay rat la dep"),
            Tinh(R.drawable.ca_mau, "Cà Mau", "1.191.999", "Tinh nay rat la dep"),
            Tinh(R.drawable.cao_bang, "Cao Bằng", "1.246.358", "Tinh nay rat la dep"),
            Tinh(R.drawable.ha_noi, "Hà Nội", "1.246.358", "Tinh nay rat la dep"),
            Tinh(R.drawable.quang_tri, "Quảng Trị", "1.246.358", "Tinh nay rat la dep"),
            Tinh(R.drawable.tp_hcm, "Hồ Chí Minh", "1.246.358", "Tinh nay rat la dep"),
        )
    }
}