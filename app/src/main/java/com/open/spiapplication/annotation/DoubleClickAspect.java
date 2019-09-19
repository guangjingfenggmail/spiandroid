package com.open.spiapplication.annotation;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.open.aspectjx.DoubleClick;
import com.open.spiapplication.R;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-04.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
@Aspect
public class DoubleClickAspect {
    private static final String TAG = "DoubleClickAspect";
    private static final int CHECK_FOR_DEFAULT_TIME = 1000;

    // View#setOnClickListener
    private static final String POINTCUT_ON_VIEW_CLICK =
            "execution(* android.view.View.OnClickListener.onClick(..))";

    @Around("execution(* android.view.View.OnClickListener.onClick(..)) || execution(* android.content.DialogInterface.OnClickListener.onClick(..))")
    public void onClick(ProceedingJoinPoint joinPoint) {
        try {
            processJoinPoint(joinPoint);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void processJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "-----method is click--- ");
        try {
            Signature signature = joinPoint.getSignature();
            if (!(signature instanceof MethodSignature)) {
                Log.e(TAG, "method is no MethodSignature, so proceed it");
                joinPoint.proceed();
                return;
            }

            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            boolean isHasLimitAnnotation = method.isAnnotationPresent(DoubleClick.class);
            String methodName = method.getName();
            int intervalTime = CHECK_FOR_DEFAULT_TIME;
            // 这里判断是否使用了 DoubleClick 注解
            // 如果用注解，并且修改了限制点击的时间
            // 如果时间 <= 0 ，代表着不做限制，直接执行
            // 如果是其他时间，则更新限制时间
            if (isHasLimitAnnotation) {
                DoubleClick clickLimit = method.getAnnotation(DoubleClick.class);
                int limitTime = clickLimit.value();
                // not limit click
                if (limitTime <= 0) {
                    Log.e(TAG, "method: " + methodName + " limitTime is zero, so proceed it");
                    joinPoint.proceed();
                    return;
                }
                intervalTime = limitTime;
                Log.e(TAG, "methodName " + methodName + " intervalTime is " + intervalTime);
            }

            // 传进来的参数不是 View, 则直接执行
            Object[] args = joinPoint.getArgs();
            View view = (View) args[0];
            if (view == null) {
                Log.e(TAG, "view is null, proceed");
                joinPoint.proceed();
                return;
            }

            // 通过 viewTag 存储上次点击的时间
            Object viewTimeTag = view.getTag(R.id.doubleClick);
            // first click viewTimeTag is null.
            if (viewTimeTag == null) {
                Log.e(TAG, "lastClickTime is zero , proceed");
                proceedAnSetTimeTag(joinPoint, view);
                return;
            }

            long lastClickTime = (long) viewTimeTag;
            if (lastClickTime <= 0) {
                Log.e(TAG, "lastClickTime is zero , proceed");
                proceedAnSetTimeTag(joinPoint, view);
                return;
            }

            // in limit time
            if (!canClick(lastClickTime, intervalTime)) {
                Log.e(TAG, "is in limit time , return");
                return;

            }
            proceedAnSetTimeTag(joinPoint, view);
            Log.e(TAG, "view proceed.");
        } catch (Throwable e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
            joinPoint.proceed();
        }
    }

    private boolean canClick(long lastClickTime, long intervalTime) {
        if (lastClickTime < intervalTime) {
            return false;
        }
        return true;
    }

    private void proceedAnSetTimeTag(ProceedingJoinPoint joinPoint, View view) throws Throwable {
        view.setTag(R.id.doubleClick, System.currentTimeMillis());
        joinPoint.proceed();
    }
}
