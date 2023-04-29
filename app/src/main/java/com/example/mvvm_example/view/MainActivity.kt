package com.example.mvvm_example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_example.R
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.hide();

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            supportFragmentManager.commit(true){
                setReorderingAllowed(true)
                add<MainFragment>(R.id.fragment_container_view);
            }
        }
    }
}