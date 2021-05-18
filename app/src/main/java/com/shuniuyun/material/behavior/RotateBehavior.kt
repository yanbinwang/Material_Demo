package com.shuniuyun.material.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar.SnackbarLayout

/**
 *  Created by wangyanbin
 * 实现点击FloatingActionButton点击旋转90度，并适配Snackbar。
 */
class RotateBehavior : CoordinatorLayout.Behavior<FloatingActionButton> {

    constructor()

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun layoutDependsOn(parent: CoordinatorLayout, child: FloatingActionButton, dependency: View): Boolean {
        return dependency is SnackbarLayout
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: FloatingActionButton, dependency: View): Boolean {
        val translationY: Float = getFabTranslationYForSnackBar(parent, child)
        val percentComplete = -translationY / dependency.height
        child.rotation = -90 * percentComplete
        child.translationY = translationY
        return false
    }

    private fun getFabTranslationYForSnackBar(parent: CoordinatorLayout, fab: FloatingActionButton): Float {
        var minOffset = 0f
        val dependencies = parent.getDependencies(fab)
        var i = 0
        val z = dependencies.size
        while (i < z) {
            val view = dependencies[i]
            if (view is SnackbarLayout && parent.doViewsOverlap(fab, view)) minOffset = minOffset.coerceAtMost(view.getTranslationY() - view.getHeight())
            i++
        }
        return minOffset
    }

}