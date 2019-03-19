package com.felixsoares.animatedbottomtab.activity

import com.felixsoares.animatedbottombar.NavigationListner
import com.felixsoares.animatedbottombar.model.Item
import com.felixsoares.animatedbottomtab.R
import kotlinx.android.synthetic.main.activity_default.*

class MultipleIconsActivity : BaseActivity(), NavigationListner {

    override fun getLayout() = R.layout.activity_miltiple_icons

    override fun setupViews() {
        pushFragment(0)

        bottom
            .setupListner(this)
            .addItem(Item(R.drawable.ic_home, R.drawable.ic_home))
            .addItem(Item(R.drawable.ic_search, R.drawable.ic_search))
            .addItem(Item(R.drawable.ic_notifications_gray, R.drawable.ic_notifications))
            .addItem(Item(R.drawable.ic_person, R.drawable.ic_person))
            .build()
    }

    override fun OnClick(position: Int) {
        pushFragment(position)
    }

}
