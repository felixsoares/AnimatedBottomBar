package com.felixsoares.animatedbottombar.ui

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.*
import com.felixsoares.animatedbottombar.model.Item
import com.felixsoares.animatedbottombar.util.Util
import com.transitionseverywhere.Slide
import com.transitionseverywhere.TransitionManager

class NavItem(context: Context) : RelativeLayout(context) {

    var statusOpened = false

    fun init(
        context: Context,
        item: Item,
        textColor: Int,
        textSize: Float,
        bgCollor: Int,
        bgIconCollor: Int,
        tintIconColor: Int
    ): NavItem {
        setBackgroundColor(bgCollor)

        this.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
            1f
        )

        this.gravity = Gravity.CENTER

        if (item.iconBg != 0) {
            val iconsParam = RelativeLayout.LayoutParams(Util.dpToPx(30), Util.dpToPx(30))
            iconsParam.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
            iconsParam.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)

            val imageView = ImageView(context)
            imageView.layoutParams = iconsParam
            imageView.setImageDrawable(ContextCompat.getDrawable(context, item.iconBg))
            addView(imageView)
        } else {
            val textParam = RelativeLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            textParam.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
            textParam.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)

            val text = TextView(context)
            text.layoutParams = textParam
            text.text = item.message
            text.setTextColor(textColor)
            text.textSize = textSize

            addView(text)
        }

        val layoutHover = RelativeLayout(context)
        layoutHover.layoutParams = layoutParams
        layoutHover.visibility = View.GONE
        layoutHover.gravity = Gravity.CENTER
        layoutHover.setBackgroundColor(bgIconCollor)

        val iconsParam = RelativeLayout.LayoutParams(Util.dpToPx(30), Util.dpToPx(30))
        iconsParam.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
        iconsParam.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)

        val imgIcon = ImageView(context)
        imgIcon.setImageDrawable(ContextCompat.getDrawable(context, item.icon))
        imgIcon.layoutParams = iconsParam
        imgIcon.setColorFilter(tintIconColor, android.graphics.PorterDuff.Mode.SRC_IN)
        layoutHover.addView(imgIcon)

        addView(layoutHover)

        return this
    }

    fun close() {
        statusOpened = false

        val slide = Slide(Gravity.BOTTOM)
        TransitionManager.beginDelayedTransition(this, slide)
        getChildAt(1).visibility = View.GONE
    }


    fun show() {
        statusOpened = true

        val slide = Slide(Gravity.BOTTOM)
        TransitionManager.beginDelayedTransition(this, slide)
        getChildAt(1).visibility = View.VISIBLE
    }
}
