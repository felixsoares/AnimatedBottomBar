package com.felixsoares.animatedbottomtab

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.felixsoares.animatedbottomtab.activity.ColorfulActivity
import com.felixsoares.animatedbottomtab.activity.DefaultActivity
import com.felixsoares.animatedbottomtab.activity.GreenActivity
import com.felixsoares.animatedbottomtab.activity.MultipleIconsActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnColorful.setOnClickListener {
            startActivity(Intent(this, ColorfulActivity::class.java))
        }

        btnDefault.setOnClickListener {
            startActivity(Intent(this, DefaultActivity::class.java))
        }

        btnGreen.setOnClickListener {
            startActivity(Intent(this, GreenActivity::class.java))
        }

        btnMultIcons.setOnClickListener {
            startActivity(Intent(this, MultipleIconsActivity::class.java))
        }
    }
}
