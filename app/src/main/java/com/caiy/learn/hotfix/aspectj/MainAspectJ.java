package com.caiy.learn.hotfix.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;

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

    @Around("executionMain()")
    public void aroundExecutionMain(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.i(TAG,String.format("joinPoint.toString()=%s",joinPoint.toString()));
        Log.i(TAG,String.format("joinPoint.toShortString()=%s",joinPoint.toShortString()));
        Log.i(TAG,String.format("joinPoint.toLongString()=%s",joinPoint.toLongString()));
        Log.i(TAG,String.format("joinPoint.getThis()=%s",joinPoint.getThis().toString()));
        Log.i(TAG,String.format("joinPoint.getTarget()=%s",joinPoint.getTarget().toString()));
        Log.i(TAG,String.format("joinPoint.getArgs()=%s",convertArgsToString(joinPoint.getArgs())));
        Log.i(TAG,String.format("joinPoint.getSignature().toString()=%s",joinPoint.getSignature().toString()));
        Log.i(TAG,String.format("joinPoint.getSignature().getParameterTypes()=%s",
                convertClassArrayToString(((CodeSignature) joinPoint.getSignature()).getParameterTypes())));
        Log.i(TAG,String.format("joinPoint.getSignature().getDeclaringType()=%s",joinPoint.getSignature().getDeclaringType().toString()));
        Log.i(TAG,String.format("joinPoint.getSourceLocation()=%s",joinPoint.getSourceLocation().toString()));
        Log.i(TAG,String.format("joinPoint.getKind()=%s",joinPoint.getKind()));

        joinPoint.proceed();
    }

    private String convertClassArrayToString(Class[] parameterTypes) {
        StringBuilder builder = new StringBuilder();
        if(parameterTypes != null){
            int length = parameterTypes.length;
            for(int i=0;i<length;i++){
                Class parameterType = parameterTypes[i];
                builder.append(parameterType.getCanonicalName());
                if(i < length-1) {
                    builder.append(",");
                }
            }
        }
        return builder.toString();
    }

    private String convertArgsToString(Object[] args){
        StringBuilder builder = new StringBuilder();
        if(args != null){
            int length = args.length;
            for(int i=0;i<length;i++){
                Object arg = args[i];
                if(arg == null){
                    builder.append(arg);
                }else {
                    builder.append(arg);
                }
                if(i < length-1) {
                    builder.append(",");
                }
            }
        }
        return builder.toString();
    }
}
