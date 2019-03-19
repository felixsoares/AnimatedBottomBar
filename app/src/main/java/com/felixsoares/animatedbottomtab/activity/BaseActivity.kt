package com.felixsoares.animatedbottomtab.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.felixsoares.animatedbottomtab.R
import com.felixsoares.animatedbottomtab.fragment.BlankFragment

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        setupViews()

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }

    fun pushFragment(position: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, BlankFragment.newInstance(position))
            .commit()
    }

    abstract fun getLayout(): Int
    abstract fun setupViews()


}