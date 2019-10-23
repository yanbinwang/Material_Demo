package com.shuniuyun.material.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * 实现点击FloatingActionButton点击旋转90度，并适配Snackbar。
 *
 * @author wyb
 */
public class RotateBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
    private static final String TAG = RotateBehavior.class.getSimpleName();

    public RotateBehavior() {
    }

    public RotateBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull FloatingActionButton child, @NonNull View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull FloatingActionButton child, View dependency) {
        float translationY = getFabTranslationYForSnackBar(parent, child);
        float percentComplete = -translationY / dependency.getHeight();
        child.setRotation(-90 * percentComplete);
        child.setTranslationY(translationY);
        return false;
    }

    private float getFabTranslationYForSnackBar(CoordinatorLayout parent, FloatingActionButton fab) {
        float minOffset = 0;
        final List<View> dependencies = parent.getDependencies(fab);
        for (int i = 0, z = dependencies.size(); i < z; i++) {
            final View view = dependencies.get(i);
            if (view instanceof Snackbar.SnackbarLayout && parent.doViewsOverlap(fab, view)) {
                minOffset = Math.min(minOffset, ViewCompat.getTranslationY(view) - view.getHeight());
            }
        }
        return minOffset;
    }

}
