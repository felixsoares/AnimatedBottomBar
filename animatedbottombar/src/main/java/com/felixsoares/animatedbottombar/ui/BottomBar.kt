package com.felixsoares.animatedbottombar.ui

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.LinearLayout
import com.felixsoares.animatedbottombar.NavigationListner
import com.felixsoares.animatedbottombar.R
import com.felixsoares.animatedbottombar.model.Item
import com.felixsoares.animatedbottombar.util.Util
import com.transitionseverywhere.TransitionManager

class BottomBar : LinearLayout {

    private var mListener: NavigationListner? = null
    private var mItens = mutableListOf<Item>()

    private var textColor = 0
    private var textSize = 0f
    private var bgColor = Color.WHITE
    private var bgIconColor = Color.WHITE
    private var bgIndicatorColor = Color.BLACK
    private var tintIconColor = Color.BLACK

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
        applyCustomLayout(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
        applyCustomLayout(context, attrs)
    }

    private fun applyCustomLayout(context: Context, attrs: AttributeSet) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.BottomBar, 0, 0
        )

        try {
            this.textColor = typedArray.getColor(
                R.styleable.BottomBar_text_color,
                ContextCompat.getColor(context, android.R.color.black)
            )
            this.textSize = typedArray.getDimension(R.styleable.BottomBar_text_size, 12f)
            this.bgColor = typedArray.getColor(
                R.styleable.BottomBar_bg_color,
                Color.WHITE
            )
            bgIconColor = typedArray.getColor(
                R.styleable.BottomBar_bg_icon_color,
                Color.WHITE
            )
            bgIndicatorColor = typedArray.getColor(
                R.styleable.BottomBar_indicator_color,
                Color.BLACK
            )
            tintIconColor = typedArray.getColor(
                R.styleable.BottomBar_tint_icon_color,
                Color.BLACK
            )
            setBackgroundColor(bgColor)
        } finally {
            typedArray.recycle()
        }

    }

    private fun init() {
        this.orientation = VERTICAL
    }

    fun setupListener(listener: NavigationListner): BottomBar {
        this.mListener = listener
        return this
    }

    fun setupItens(itens: MutableList<Item>): BottomBar {
        this.mItens = itens
        return this
    }

    fun addItem(item: Item): BottomBar {
        this.mItens.add(item)
        return this
    }

    fun build() {
        when {
            mItens.isEmpty() -> {
                throw Exception("Navigation items should not be empty.")
            }
            this.mItens.size < 3 -> {
                throw Exception("Don't use minus than three destinations. You should work with tabs.")
            }
            this.mItens.size > 5 -> {
                throw Exception("Don’t use more than five itens.")
            }
            else -> {
                createNavigationItems()
            }
        }
    }

    fun setTextColor(textColor: Int): BottomBar {
        this.textColor = textColor
        return this
    }

    fun setTextSize(textSize: Float): BottomBar {
        this.textSize = textSize
        return this
    }

    fun setBgColor(bgColor: Int): BottomBar {
        this.bgColor = bgColor
        return this
    }

    fun setBgIconColor(bgIconColor: Int): BottomBar {
        this.bgIconColor = bgIconColor
        return this
    }

    fun setIconColor(tintIconColor: Int): BottomBar {
        this.tintIconColor = tintIconColor
        return this
    }

    fun setIndicatorColor(bgIndicatorColor: Int): BottomBar {
        this.bgIndicatorColor = bgIndicatorColor
        return this
    }

    private fun createNavigationItems() {
        val indicatorParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, Util.dpToPx(2))
        val llIndicator = LinearLayout(context)
        llIndicator.orientation = HORIZONTAL
        llIndicator.layoutParams = indicatorParams

        val navParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        val llNav = LinearLayout(context)
        llNav.orientation = HORIZONTAL
        llNav.layoutParams = navParams

        createIndicator(mItens.size, llIndicator)

        for (i in 0..(mItens.size - 1)) {
            createItens(mItens[i], llNav, i)
        }

        addView(llIndicator)
        addView(llNav)
    }

    private fun createItens(item: Item, llNav: LinearLayout, position: Int) {
        val navi = NavItem(context).init(
            context,
            item,
            textColor,
            textSize,
            bgColor,
            bgIconColor,
            tintIconColor
        )
        navi.setOnClickListener {
            moveIndicator(position, mItens.size)
            closeAll()
            navi.show()
            mListener?.OnClick(position)
        }

        if (position == 0) {
            navi.show()
        }

        llNav.addView(navi)
    }

    private fun closeAll() {
        val nav = getChildAt(1) as LinearLayout
        for (i in 0..(nav.childCount - 1)) {
            val item = nav.getChildAt(i) as NavItem
            if (item.statusOpened) {
                item.close()
            }
        }
    }

    private fun createIndicator(size: Int, llIndicator: LinearLayout) {
        val lfParams = LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 0f)
        val leftFlank = LinearLayout(context)
        leftFlank.layoutParams = lfParams

        val indicatorParams = LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1f)
        val indicator = LinearLayout(context)
        indicator.layoutParams = indicatorParams
        indicator.setBackgroundColor(bgIndicatorColor)

        val lrParams = LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, (size - 1).toFloat())
        val rightFlank = LinearLayout(context)
        rightFlank.layoutParams = lrParams

        llIndicator.addView(leftFlank)
        llIndicator.addView(indicator)
        llIndicator.addView(rightFlank)
    }


    private fun moveIndicator(position: Int, size: Int) {
        val llIndicator = this.getChildAt(0) as LinearLayout
        val leftFlank = llIndicator.getChildAt(0) as LinearLayout
        val rightFlank = llIndicator.getChildAt(2) as LinearLayout

        val llparams = leftFlank.layoutParams as LinearLayout.LayoutParams
        val rlparams = rightFlank.layoutParams as LinearLayout.LayoutParams

        llparams.weight = position.toFloat()
        rlparams.weight = (size - position - 1).toFloat()

        TransitionManager.beginDelayedTransition(llIndicator)

        leftFlank.layoutParams = llparams
        rightFlank.layoutParams = rlparams
    }

}
