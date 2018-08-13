package com.caiy.learn.hotfix.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by caiyong on 2018/8/13.
 */

@Aspect
public class MainAspectJ {

    private static final String TAG = "MainAspectJ";
    private static final String POINTCUT_EXPRESS = "execution(* com.caiy.learn.hotfix..*.*(..))" +
                                            " && !execution(* com.caiy.learn.hotfix.bean..*.*(..))" +
                                            " && !execution(* com.caiy.learn.hotfix.aspectj..*.*(..))"
                                            ;

    @Pointcut(value = POINTCUT_EXPRESS)
    public void executionMain(){

    }

    @Before("executionMain()")
    public void aroundExecutionMain(JoinPoint joinPoint){
        Log.i(TAG,String.format("target=%s,signature.name=%s",joinPoint.getTarget().toString(),joinPoint.getSignature().getName()));
    }

}
