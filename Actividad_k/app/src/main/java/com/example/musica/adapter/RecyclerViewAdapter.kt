package com.example.musica.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musica.R
import com.example.musica.model.Album

class RecyclerViewAdapter:
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
        var albumes:MutableList<Album> =ArrayList()
    lateinit var context: Context
    lateinit var milistener: onItemClickListener
    fun RecyclerViewAdapter(albumes: MutableList<Album>,context: Context){
        this.albumes = albumes
        this.context = context
    }
        class ViewHolder(view: View, listener: onItemClickListener): RecyclerView.ViewHolder(view) {
            val  albumNombre= view.findViewById<TextView>(R.id.txtnombre)
            val  albumFecha= view.findViewById<TextView>(R.id.txtfecha)
            val  albumFoto= view.findViewById<ImageView>(R.id.imvfoto)
            fun bind(album:Album,context: Context){
                albumNombre.text=album.nombre
                albumFecha.text=album.fecha
                albumFoto.loadImage((album.imagen))

            }
            fun ImageView.loadImage(url:String){
                Glide.with(context).load(url).into(this)
            }
            init {
                view.setOnClickListener {
                    listener.onItemClickListener(bindingAdapterPosition)
                }
            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_album,parent,false),
            milistener
        )
    }

    override fun getItemCount(): Int {
        return  albumes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item =albumes.get(position)
        holder.bind(item,context)
    }

    interface onItemClickListener{
        fun  onItemClickListener(position: Int)
    }
    fun  setOnItemClickListener(listener: onItemClickListener){
        milistener=listener
    }

}