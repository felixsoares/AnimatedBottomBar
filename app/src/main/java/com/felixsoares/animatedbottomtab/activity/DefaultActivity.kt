package com.felixsoares.animatedbottomtab.activity

import com.felixsoares.animatedbottombar.NavigationListner
import com.felixsoares.animatedbottombar.model.Item
import com.felixsoares.animatedbottomtab.R
import kotlinx.android.synthetic.main.activity_default.*

class DefaultActivity : BaseActivity(), NavigationListner {

    override fun getLayout() = R.layout.activity_default

    override fun setupViews() {
        pushFragment(0)

        bottom
            .setupListener(this)
            .addItem(Item("Home", R.drawable.ic_home))
            .addItem(Item("Search", R.drawable.ic_search))
            .addItem(Item("Profile", R.drawable.ic_person))
            .build()
    }

    override fun OnClick(position: Int) {
        pushFragment(position)
    }


}
