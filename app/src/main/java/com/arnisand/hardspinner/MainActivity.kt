package com.arnisand.hardspinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newAdapter = NewAdapter(applicationContext).apply {
            this.mChildList = listOf(listOf("one, two"), listOf("one, two", "3", "four"), listOf("one, two", "three"))
            this.mGroupList = listOf("oneG", "twoG", "threeG")
        }

        list_view.setAdapter(newAdapter)
    }
}
