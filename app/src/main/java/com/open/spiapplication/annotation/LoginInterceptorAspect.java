package com.open.spiapplication.annotation;

import android.util.Log;

import com.open.PluginResult;
import com.open.aspectjx.LoginInterceptor;
import com.open.interfaces.PluginResultCallback;
import com.open.spiapplication.PluginFactory;
import com.open.spiapplication.SpiApplication;
import com.open.usermodule.UserPlugin;

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
public class LoginInterceptorAspect {

    @Pointcut("within(@com.open.aspectjx.LoginInterceptor *)")
    public void withinAnnotatedClass() {
    }

    @Pointcut("execution(!synthetic * *(..)) && withinAnnotatedClass()")
    public void methodInsideAnnotatedType() {
    }

    @Pointcut("execution(!synthetic *.new(..)) && withinAnnotatedClass()")
    public void constructorInsideAnnotatedType() {
    }

    @Pointcut("execution(@com.open.aspectjx.LoginInterceptor * *(..)) || methodInsideAnnotatedType()")
    public void method() {
    } //方法切入点

    @Pointcut("execution(@com.open.aspectjx.LoginInterceptor *.new(..)) || constructorInsideAnnotatedType()")
    public void constructor() {
    } //构造器切入点

    @Around("(method() || constructor()) && @annotation(interceptor)")
    public void log(ProceedingJoinPoint joinPoint, LoginInterceptor interceptor) {
        try {
            processJoinPoint(joinPoint, interceptor);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void processJoinPoint(final ProceedingJoinPoint joinPoint, LoginInterceptor interceptor) throws Throwable {

        try {
            Signature signature = joinPoint.getSignature();
            if (!(signature instanceof MethodSignature)) {
                Log.d("LoginInterceptorAspect", "method is no MethodSignature, so proceed it");
                joinPoint.proceed();
                return;
            }

            if (interceptor == null)
                return;
            //todo
            UserPlugin plugin = PluginFactory.getSingleton().getPlugin(UserPlugin.class);
            if (plugin == null)
                return;
            plugin.toLogin(SpiApplication.getInstance(), null, new PluginResultCallback() {
                @Override
                public void onPluginResult(PluginResult result) {
                    try {
                        if (result != null && result.isSuccess()) {
                            joinPoint.proceed();
                        }
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            joinPoint.proceed();
        }
    }
}
