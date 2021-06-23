package com.example.homework20.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework20.databinding.KontentLayoutBinding


class NewsRecyclerAdapter (val summeri : String,val provider : String) : RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(val binding : KontentLayoutBinding): RecyclerView.ViewHolder(binding.root){


        fun bind(){

            binding.description.text = summeri
            binding.timeline.text = provider

            Log.d("provider", provider)


        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(
          KontentLayoutBinding.inflate(
              LayoutInflater.from(parent.context),
              parent,
              false
          )
      )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind()
    }

    override fun getItemCount() = 1




    private lateinit var str: String


}