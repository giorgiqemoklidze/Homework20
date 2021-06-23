package com.example.homework20.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework20.databinding.ViewPagerBinding
import com.example.homework20.models.News

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {


    private lateinit var recycleradapter: NewsRecyclerAdapter


    private var listNews = mutableListOf<News>()

    inner class ViewHolder(val binding: ViewPagerBinding) : RecyclerView.ViewHolder(binding.root) {


        private lateinit var model: News
        private var provider: String = ""


        fun bind() {

            model = listNews[adapterPosition]

            binding.title.text = model.title.toString()
            binding.time.text = model.updatedAt.toString()

            Glide.with(binding.itemImg.context).load(model.imageUrl)
                .into(binding.itemImg)


            for (i in 0..(model.events?.size!!)) {
                if (model.events?.size == 0) {
                    provider = " Null"
                } else {
                    provider = provider + "," + model.events?.get(i)?.provider.toString()
                }
            }

            setUpRecycler(model.summary.toString(), provider)

        }

        private fun setUpRecycler(summary: String, provider: String) {
            recycleradapter = NewsRecyclerAdapter(summary, provider)
            binding.newsRecycler.layoutManager = LinearLayoutManager(binding.root.context)
            binding.newsRecycler.adapter = recycleradapter


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewPagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }


    fun getItems(listNews: List<News>) {
        this.listNews.clear()
        this.listNews.addAll(listNews)
        notifyDataSetChanged()


    }

    override fun getItemCount() = listNews.size

}

