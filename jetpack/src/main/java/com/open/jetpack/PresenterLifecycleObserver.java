package com.open.jetpack;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-05.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class PresenterLifecycleObserver implements LifecycleObserver {

    /**
     * Notifies that {@code ON_CREATE} event occurred.
     * <p>
     * This method will be called after the {@link LifecycleOwner}'s {@code onCreate}
     * method returns.
     *
     * @param owner the component, whose state was changed
     */

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(@NonNull LifecycleOwner owner) {
    }

    /**
     * Notifies that {@code ON_START} event occurred.
     * <p>
     * This method will be called after the {@link LifecycleOwner}'s {@code onStart} method returns.
     *
     * @param owner the component, whose state was changed
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(@NonNull LifecycleOwner owner) {
    }

    /**
     * Notifies that {@code ON_RESUME} event occurred.
     * <p>
     * This method will be called after the {@link LifecycleOwner}'s {@code onResume}
     * method returns.
     *
     * @param owner the component, whose state was changed
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(@NonNull LifecycleOwner owner) {
    }

    /**
     * Notifies that {@code ON_PAUSE} event occurred.
     * <p>
     * This method will be called before the {@link LifecycleOwner}'s {@code onPause} method
     * is called.
     *
     * @param owner the component, whose state was changed
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(@NonNull LifecycleOwner owner) {
    }

    /**
     * Notifies that {@code ON_STOP} event occurred.
     * <p>
     * This method will be called before the {@link LifecycleOwner}'s {@code onStop} method
     * is called.
     *
     * @param owner the component, whose state was changed
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(@NonNull LifecycleOwner owner) {
    }

    /**
     * Notifies that {@code ON_DESTROY} event occurred.
     * <p>
     * This method will be called before the {@link LifecycleOwner}'s {@code onStop} method
     * is called.
     *
     * @param owner the component, whose state was changed
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(@NonNull LifecycleOwner owner) {
    }
}
