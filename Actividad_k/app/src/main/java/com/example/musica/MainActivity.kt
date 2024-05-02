package com.example.musica

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musica.adapter.RecyclerViewAdapter
import com.example.musica.data.DataSource
import com.example.musica.databinding.ActivityMainBinding
import com.example.musica.model.Album

class MainActivity : AppCompatActivity() {
    var albumes: MutableList<Album> = mutableListOf()
    private lateinit var binding: ActivityMainBinding
   lateinit var miRecycler: RecyclerView
   val miAdapter:RecyclerViewAdapter=RecyclerViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarRecycler()
       /* albumes.add(Album("caver","2003","https://www.educaciontrespuntocero.com/wp-content/uploads/2020/04/mejores-bancos-de-imagenes-gratis.jpg"))
        albumes.add(Album("caver","2003","https://www.educaciontrespuntocero.com/wp-content/uploads/2020/04/mejores-bancos-de-imagenes-gratis.jpg"))
        albumes.add(Album("caver","2003","https://www.educaciontrespuntocero.com/wp-content/uploads/2020/04/mejores-bancos-de-imagenes-gratis.jpg"))
        albumes.add(Album("caver","2003","https://www.educaciontrespuntocero.com/wp-content/uploads/2020/04/mejores-bancos-de-imagenes-gratis.jpg"))
        albumes.add(Album("caver","2003","https://www.educaciontrespuntocero.com/wp-content/uploads/2020/04/mejores-bancos-de-imagenes-gratis.jpg"))
        albumes.add(Album("caver","2003","https://www.educaciontrespuntocero.com/wp-content/uploads/2020/04/mejores-bancos-de-imagenes-gratis.jpg"))*/

    }
   fun cargarRecycler(){
       miRecycler=binding.rcvalbumes
       miRecycler.setHasFixedSize(true)
       miRecycler.layoutManager=LinearLayoutManager(this)
       miAdapter.RecyclerViewAdapter(DataSource().getAlbmes(),this)
       miRecycler.adapter=miAdapter
       miAdapter.setOnItemClickListener(object: RecyclerViewAdapter.onItemClickListener{
           override fun onItemClickListener(position: Int) {
               val intent=Intent(this@MainActivity,DetalleActivity::class.java)
               intent.putExtra("imagen",DataSource().getAlbmes()[position].imagen)
               intent.putExtra("album",DataSource().getAlbmes()[position].nombre)
               intent.putExtra("fecha",DataSource().getAlbmes()[position].fecha)
               startActivity(intent)
               Log.d("info album", DataSource().getAlbmes()[position].toString())
           }
       })
   }
}