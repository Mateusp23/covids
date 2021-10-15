package com.example.corona.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.corona.R
import com.example.corona.model.Covid

class CovidAdapter(private val info: List<Covid>): RecyclerView.Adapter<CovidAdapter.CovidViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.covid_item,parent,false)
        val viewHolder = CovidViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val intent = Intent(view.context, DetailsActivity::class.java)
            var arrayInfo = info[viewHolder.adapterPosition]
            intent.putExtra("Boletim", arrayInfo)
            view.context.startActivity(intent)
        }
        return viewHolder
    }

    override fun getItemCount(): Int = info.size

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        var boletim = info[position]
        holder.dateInfo.text = boletim.date
        holder.suspectInfo.text = boletim.suspects.toString()
    }

    class CovidViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var dateInfo: TextView = itemView.findViewById(R.id.data_covid_item)
        var suspectInfo: TextView = itemView.findViewById(R.id.suspect_covid_item)
    }
}