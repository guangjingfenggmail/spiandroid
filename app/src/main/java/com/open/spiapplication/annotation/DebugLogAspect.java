package com.open.spiapplication.annotation;

import android.util.Log;

import com.open.aspectjx.DebugLog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

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
@Aspect
public class DebugLogAspect {

    @Pointcut("within(@com.open.aspectjx.DebugLog *)")
    public void withinAnnotatedClass() {
    }

    @Pointcut("execution(!synthetic * *(..)) && withinAnnotatedClass()")
    public void methodInsideAnnotatedType() {
    }

    @Pointcut("execution(!synthetic *.new(..)) && withinAnnotatedClass()")
    public void constructorInsideAnnotatedType() {
    }

    @Pointcut("execution(@com.open.aspectjx.DebugLog * *(..)) || methodInsideAnnotatedType()")
    public void method() {
    } //方法切入点

    @Pointcut("execution(@com.open.aspectjx.DebugLog *.new(..)) || constructorInsideAnnotatedType()")
    public void constructor() {
    } //构造器切入点

    @Around("(method() || constructor()) && @annotation(debugLog)")
    public void log(ProceedingJoinPoint joinPoint, DebugLog debugLog) {
        try {
            processJoinPoint(joinPoint, debugLog);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void processJoinPoint(ProceedingJoinPoint joinPoint, DebugLog debugLog) throws Throwable {

        try {
            Signature signature = joinPoint.getSignature();
            if (!(signature instanceof MethodSignature)) {
                Log.d("DebugLogAspect", "method is no MethodSignature, so proceed it");
                joinPoint.proceed();
                return;
            }

            if (debugLog == null)
                return;
            String tag = debugLog.tag();
            String msg = debugLog.msg();
            switch (debugLog.level()) {
                case Log.VERBOSE:
                    Log.v(tag, msg);
                    break;
                case Log.DEBUG:
                    Log.d(tag, msg);
                    break;
                case Log.INFO:
                    Log.i(tag, msg);
                    break;
                case Log.WARN:
                    Log.w(tag, msg);
                    break;
                case Log.ERROR:
                    Log.e(tag, msg);
                    break;
                case Log.ASSERT:
                    Log.wtf(tag, msg);
                    break;
                default:
                    Log.v(tag, msg);
                    break;
            }
            joinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
            joinPoint.proceed();
        }
    }
}
