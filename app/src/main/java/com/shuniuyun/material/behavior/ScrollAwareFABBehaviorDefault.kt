package com.shuniuyun.material.behavior

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 *  Created by wangyanbin
 */
class ScrollAwareFABBehaviorDefault : FloatingActionButton.Behavior {

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int, consumed: IntArray) {
        if (dyConsumed > 10 && child.visibility == View.VISIBLE) {
            //执行隐藏的动画
            hide(child)
        } else if (dyConsumed < -10 && child.visibility != View.VISIBLE) {
            //执行显示的动画
            show(child)
        }
    }

    //显示的动画
    private fun show(view: View) {
        view.apply {
            animate().cancel()
            alpha = 0f
            scaleY = 0f
            scaleX = 0f
            animate()
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(200)
                .setInterpolator(LinearOutSlowInInterpolator())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationStart(animation: Animator) {
                        visibility = View.VISIBLE
                    }
                    override fun onAnimationEnd(animation: Animator) {}
                })
        }
    }

    //隐藏的动画
    private fun hide(view: View) {
        view.apply {
            animate().cancel()
            animate()
                .scaleX(0f)
                .scaleY(0f)
                .alpha(0f)
                .setDuration(200)
                .setInterpolator(FastOutLinearInInterpolator())
                .setListener(object : AnimatorListenerAdapter() {
                    private var mCancelled = false
                    override fun onAnimationStart(animation: Animator) {
                        visibility = View.VISIBLE
                        mCancelled = false
                    }
                    override fun onAnimationCancel(animation: Animator) {
                        mCancelled = true
                    }
                    override fun onAnimationEnd(animation: Animator) {
                        if (!mCancelled) visibility = View.INVISIBLE
                    }
                })
        }
    }

}