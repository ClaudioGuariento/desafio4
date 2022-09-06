package com.guariento.desafio4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicaAdapter(
    private val list: List<Musica>,
    private val onItemCliked: (Musica) -> Unit
): RecyclerView.Adapter<MusicaAdapter.MusicaViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.musica, parent, false)
        return MusicaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicaViewHolder, position: Int) {
        val musica = list[position]
        holder.bind(musica)
        holder.itemView.setOnClickListener {
            onItemCliked(musica)
        }
    }

    override fun getItemCount(): Int = list.size

    class MusicaViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        fun bind(musica: Musica) {
            view.apply {
                findViewById<TextView>(R.id.nomeMusica).text = musica.musica
                findViewById<TextView>(R.id.tempo).text = musica.tempo
            }
        }
    }
}