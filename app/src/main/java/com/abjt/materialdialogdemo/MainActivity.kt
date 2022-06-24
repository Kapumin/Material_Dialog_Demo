package com.abjt.materialdialogdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.abjt.materialdialogdemo.fragment.DialogHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.fragment_opener).setOnClickListener {
            supportFragmentManager.beginTransaction().add(
                R.id.fragment_container,
                DialogHostFragment(),
                DIALOG_HOST_FRAGMENT_TAG
            ).commit()
        }
    }
}