
package com.example.homework20

import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.homework20.adapters.NewsRecyclerAdapter
import com.example.homework20.adapters.ViewPagerAdapter
import com.example.homework20.api.ResponseHandler
import com.example.homework20.databinding.ActivityMainBinding
import com.example.homework20.viewModels.NewsViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val viewModel: NewsViewModel by viewModels()

    private val adapter : ViewPagerAdapter = ViewPagerAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        init()
        setContentView(binding.root)
    }

    private fun init(){

        viewModel.init()
        observes()
        setUpViewPager()

        binding.countrySearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
//                    adapter.getSearch(newText)
                }
                return false
            }

        })


    }


    private fun setUpViewPager(){

        binding.newsViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL;
        binding.newsViewPager.adapter = adapter

    }



    private fun observes(){


        viewModel.newsDataLiveData.observe(this, {
            when (it) {

                is ResponseHandler.Success -> adapter.getItems(it.data!!)
                is ResponseHandler.Error -> Toast.makeText(
                    this,
                    "${it.errorMessage}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

    }
}