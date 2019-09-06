package com.open.spiapplication.annotation;

import android.Manifest;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.open.aspectjx.Permission;
import com.open.jetpack.Presenter;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import io.reactivex.functions.Consumer;

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
public class PermissonAspect {

    @Pointcut("within(@com.open.aspectjx.Permission *)")
    public void withinAnnotatedClass() {
    }

    @Pointcut("execution(!synthetic * *(..)) && withinAnnotatedClass()")
    public void methodInsideAnnotatedType() {
    }

    @Pointcut("execution(!synthetic *.new(..)) && withinAnnotatedClass()")
    public void constructorInsideAnnotatedType() {
    }

    @Pointcut("execution(@com.open.aspectjx.Permission * *(..)) || methodInsideAnnotatedType()")
    public void method() {
    } //方法切入点

    @Pointcut("execution(@com.open.aspectjx.Permission *.new(..)) || constructorInsideAnnotatedType()")
    public void constructor() {
    } //构造器切入点

    @Around("(method() || constructor()) && @annotation(permission)")
    public void log(ProceedingJoinPoint joinPoint, Permission permission) {
        try {
            processJoinPoint(joinPoint, permission);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void processJoinPoint(final ProceedingJoinPoint joinPoint, Permission p) throws Throwable {

        try {
            Signature signature = joinPoint.getSignature();
            if (!(signature instanceof MethodSignature)) {
                Log.d("LoginInterceptorAspect", "method is no MethodSignature, so proceed it");
                joinPoint.proceed();
                return;
            }

            if (p == null)
                return;

            //todo
            Log.e("PermissonAspect", "todo permission");

            RxPermissions rxPermissions = null;// where this is an Activity or Fragment instance
            if (joinPoint.getTarget() instanceof Fragment) {
                rxPermissions = new RxPermissions((Fragment) joinPoint.getTarget());
            } else if (joinPoint.getTarget() instanceof FragmentActivity) {
                rxPermissions = new RxPermissions((FragmentActivity) joinPoint.getTarget());
            }
            if (joinPoint.getTarget() instanceof Presenter) {
                Presenter presenter = (Presenter) joinPoint.getTarget();
                if (presenter == null)
                    return;

                if (presenter.getContext() instanceof FragmentActivity) {
                    rxPermissions = new RxPermissions((FragmentActivity) presenter.getContext());
                }

            }
            if (rxPermissions == null)
                return;
            rxPermissions
                    .requestEach(Manifest.permission.CAMERA,
                            Manifest.permission.READ_PHONE_STATE)
                    .subscribe(new Consumer<com.tbruyelle.rxpermissions2.Permission>() {
                        @Override
                        public void accept(com.tbruyelle.rxpermissions2.Permission permission) throws Exception {
                            if (permission.granted) {
                                try {
                                    joinPoint.proceed();
                                } catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                // `permission.name` is granted !
                            } else if (permission.shouldShowRequestPermissionRationale) {
                                // Denied permission without ask never again
                            } else {
                                // Denied permission with ask never again
                                // Need to go to the settings
                            }
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
            joinPoint.proceed();
        }
    }
}
