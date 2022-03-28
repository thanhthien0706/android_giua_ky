package com.example.giuaky

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class TinhAdapter(private val context: Context, private val mListTinh: MutableList<Tinh>) :
    RecyclerView.Adapter<TinhAdapter.TinhViewHolder>() {
    class TinhViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgTinh: ImageView = itemView.findViewById(R.id.img_tinh)
        val tvNameTinh: TextView = itemView.findViewById(R.id.tv_name_tinh)
        val layoutItemTinh: CardView = itemView.findViewById(R.id.layout_item_tinh)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TinhViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tinh, parent, false)
        return TinhViewHolder(view)
    }

    override fun onBindViewHolder(holder: TinhViewHolder, position: Int) {
        val tinh: Tinh = mListTinh[position]

        if (tinh == null) {
            return
        }

        holder.imgTinh.setImageResource(tinh.resouerceId)
        holder.tvNameTinh.setText(tinh.name)

        holder.layoutItemTinh.setOnClickListener {
            onShowTinh(tinh)
        }

    }

    private fun onShowTinh(tinh: Tinh) {
        val intent: Intent = Intent(context, DetailActivity::class.java)
        val bundle: Bundle = Bundle()
        bundle.putSerializable("object_tinh", tinh)

        intent.putExtras(bundle)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int {
        if (mListTinh != null) {
            return mListTinh.size
        }
        return 0
    }
}