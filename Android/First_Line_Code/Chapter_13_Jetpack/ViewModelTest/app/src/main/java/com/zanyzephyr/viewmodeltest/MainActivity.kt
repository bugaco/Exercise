package com.zanyzephyr.viewmodeltest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val COUNT_RESERVED = "count_reserved"
    }

    lateinit var viewModle: MainViewModel
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt(COUNT_RESERVED, 0)
        viewModle = ViewModelProviders.of(this,
            MainViewModelFactory(countReserved)).get(MainViewModel::class.java)
        plusOneBtn.setOnClickListener {
            viewModle.counter ++
            updateTextInfo()
        }
        clearBtn.setOnClickListener {
            viewModle.counter = 0
            updateTextInfo()
        }
        updateTextInfo()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt(COUNT_RESERVED, viewModle.counter)
        }
    }

    private fun updateTextInfo() {
        infoText.text = viewModle.counter.toString()
    }
}
