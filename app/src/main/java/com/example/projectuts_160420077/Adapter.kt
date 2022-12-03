package com.example.projectuts_160420077

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RAdapter(var listItem: Array<String>):RecyclerView.Adapter<RAdapter.AdapterViewHolder>() {
     class AdapterViewHolder(view :View):RecyclerView.ViewHolder(view){
        var idtextView : TextView= view.findViewById(R.id.txtRecycle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val item=LayoutInflater.from(parent.context).inflate(R.layout.activity_view,parent,false);
        return AdapterViewHolder(item);
    }
    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val listItem=listItem[position];
        holder.idtextView.text=listItem;
        holder.idtextView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_three));
    }
    override fun getItemCount(): Int {
        return listItem.size

    }

}
