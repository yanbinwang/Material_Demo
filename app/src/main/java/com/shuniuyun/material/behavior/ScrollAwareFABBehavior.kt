package com.shuniuyun.material.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 *  Created by wangyanbin
 */
class ScrollAwareFABBehavior : FloatingActionButton.Behavior {
    private val INTERPOLATOR by lazy { FastOutSlowInInterpolator() }
    private var mIsAnimatingOut = false

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int, consumed: IntArray) {
        if (dyConsumed > 0 && !mIsAnimatingOut && child.visibility == View.VISIBLE) {
            animateOut(child)
        } else if (dyConsumed < 0 && child.visibility != View.VISIBLE) {
            animateIn(child)
        }
    }

    private fun animateOut(button: FloatingActionButton) {
        ViewCompat.animate(button).translationY((button.height + getMarginBottom(button)).toFloat())
            .setInterpolator(INTERPOLATOR).withLayer()
            .setListener(object : ViewPropertyAnimatorListener {
                override fun onAnimationStart(view: View) {
                    mIsAnimatingOut = true
                }
                override fun onAnimationCancel(view: View) {
                    mIsAnimatingOut = false
                }
                override fun onAnimationEnd(view: View) {
                    mIsAnimatingOut = false
                    view.visibility = View.INVISIBLE
                }
            }).start()
    }

    private fun animateIn(button: FloatingActionButton) {
        button.visibility = View.VISIBLE
        ViewCompat.animate(button).translationY(0f)
            .setInterpolator(INTERPOLATOR).withLayer()
            .setListener(null)
            .start()
    }

    private fun getMarginBottom(v: View): Int {
        var marginBottom = 0
        val layoutParams = v.layoutParams
        if (layoutParams is MarginLayoutParams) marginBottom = layoutParams.bottomMargin
        return marginBottom
    }

}