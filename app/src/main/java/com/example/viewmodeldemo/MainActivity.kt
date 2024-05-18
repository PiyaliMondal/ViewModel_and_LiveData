package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private var clickCount = 0
    private lateinit var viewModel : ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val count = findViewById<TextView>(R.id.tvCount)
        val countButton = findViewById<Button>(R.id.btnCount)

        //count.text = clickCount.toString()
        //count.text = (viewModel as MainActivityViewModel).count.toString()
        (viewModel as MainActivityViewModel).count.observe(this, Observer {
            count.text = it.toString()
        })
        
        countButton.setOnClickListener {
            /*++clickCount
            count.text = clickCount.toString()*/
            (viewModel as MainActivityViewModel).updateCount()
            //count.text = (viewModel as MainActivityViewModel).count.toString()
        }
    }
}