package com.example.cafe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_cart.view.*


class CartAdapter (
    var results: ArrayList<CartModel.Result>,
    val listener: OnAdapterListener):
    RecyclerView.Adapter<CartAdapter.MyViewHolder>(){


    override fun getItemCount() = results.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.list_cart, parent,false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val result = results[position]
        holder.view.tvNoMejaCart.text   = result.nomor_meja
        holder.view.tvMenuCart.text     = result.nama
        holder.view.tvHargaCart.text    = "Rp. ${result.harga.toString()}"
        holder.view.tvJmlOrderCart.text = result.jumlah_order.toString()
        holder.view.tvJmlHargaCart.text = "Rp. ${result.jumlah_harga.toString()}"

        holder.view.setOnClickListener{listener.onClick(result)}
    }

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view)

    interface OnAdapterListener{
        fun onClick(result: CartModel.Result)
    }

    fun setData(data: List<CartModel.Result>){
        this.results.clear()
        this.results.addAll(data)
        notifyDataSetChanged()
    }
}