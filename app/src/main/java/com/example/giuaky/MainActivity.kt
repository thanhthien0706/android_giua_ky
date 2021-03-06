package com.example.giuaky

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var rcvTinh: RecyclerView
    private lateinit var layoutMain: RelativeLayout
    private lateinit var tinhAdapter: TinhAdapter

    private var listData = mutableListOf<Tinh>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcvTinh = findViewById(R.id.rcv_tinh)
        layoutMain = findViewById(R.id.layout_main)

        setDataTinh()

        rcvTinh.layoutManager = LinearLayoutManager(this)

        tinhAdapter = TinhAdapter(this, listData)
        rcvTinh.adapter = tinhAdapter


        val itemTouchHelperCallback =
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    listData.removeAt(position)
                    tinhAdapter.notifyDataSetChanged()

                }

            }

        val itemTouchHelper: ItemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(rcvTinh)

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
                "???ng d???ng xem th??ng tin t???nh",
                Toast.LENGTH_LONG
            ).show()
        }
        return true
    }

    private fun setDataTinh() {
        listData.addAll(
            listOf(
                Tinh(R.drawable.khanh_hoa, "Kh??nh H??a", "1.246.358", "Tinh nay rat la dep"),
                Tinh(R.drawable.hue, "Hu???", "1.137.045", "Tinh nay rat la dep"),
                Tinh(R.drawable.ca_mau, "C?? Mau", "1.191.999", "Tinh nay rat la dep"),
                Tinh(R.drawable.cao_bang, "Cao B???ng", "1.246.358", "Tinh nay rat la dep"),
                Tinh(R.drawable.ha_noi, "H?? N???i", "1.246.358", "Tinh nay rat la dep"),
                Tinh(R.drawable.quang_tri, "Qu???ng Tr???", "1.246.358", "Tinh nay rat la dep"),
                Tinh(R.drawable.tp_hcm, "H??? Ch?? Minh", "1.246.358", "Tinh nay rat la dep"),
            )
        )
//        return listOf(
//            Tinh(R.drawable.khanh_hoa, "Kh??nh H??a", "1.246.358", "Tinh nay rat la dep"),
//            Tinh(R.drawable.hue, "Hu???", "1.137.045", "Tinh nay rat la dep"),
//            Tinh(R.drawable.ca_mau, "C?? Mau", "1.191.999", "Tinh nay rat la dep"),
//            Tinh(R.drawable.cao_bang, "Cao B???ng", "1.246.358", "Tinh nay rat la dep"),
//            Tinh(R.drawable.ha_noi, "H?? N???i", "1.246.358", "Tinh nay rat la dep"),
//            Tinh(R.drawable.quang_tri, "Qu???ng Tr???", "1.246.358", "Tinh nay rat la dep"),
//            Tinh(R.drawable.tp_hcm, "H??? Ch?? Minh", "1.246.358", "Tinh nay rat la dep"),
//        )
    }
}