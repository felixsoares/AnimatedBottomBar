package com.felixsoares.animatedbottomtab.activity

import com.felixsoares.animatedbottombar.NavigationListner
import com.felixsoares.animatedbottombar.model.Item
import com.felixsoares.animatedbottomtab.R
import kotlinx.android.synthetic.main.activity_default.*

class GreenActivity : BaseActivity(), NavigationListner {

    override fun getLayout() = R.layout.activity_green

    override fun setupViews() {
        pushFragment(0)

        bottom
            .setupListener(this)
            .addItem(Item("Home", R.drawable.ic_home))
            .addItem(Item("Search", R.drawable.ic_search))
            .addItem(Item("Safe", R.drawable.shield))
            .addItem(Item("Music", R.drawable.ic_music))
            .build()
    }

    override fun OnClick(position: Int) {
        pushFragment(position)
    }

}
