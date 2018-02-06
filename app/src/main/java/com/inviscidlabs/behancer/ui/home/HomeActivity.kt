package com.inviscidlabs.behancer.ui.home

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.inviscidlabs.behancer.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setUpRecyclerView()
    }


    private fun setUpRecyclerView() {
        with(recyclerView_CreativeFields_Home) {
            layoutManager = GridLayoutManager(this@HomeActivity, 2)
            //layoutManager.heightMode =
            adapter = CreativeFieldRecyclerAdapter(viewModel = viewModel, lifecycleOwner = this@HomeActivity)
            Log.e(javaClass.simpleName, adapter.itemCount.toString())
        }
    }
}
