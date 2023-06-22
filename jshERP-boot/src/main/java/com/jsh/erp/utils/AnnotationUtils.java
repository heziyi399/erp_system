package com.jsh.erp.utils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author jishenghua qq752718920  2018-10-7 15:26:27
 */
public class AnnotationUtils {
    public static <A extends Annotation> A getAnnotation(Class<?> cls, Class<A> annotationClass) {
        A res = cls.getAnnotation(annotationClass);
        //class类的getAnnotation方法：如果有指定类型的注释，则返回该元素的注释，否则为null。
        //
        //注意，此方法返回的任何注释都是声明注释。
        System.out.println("AnnotationUtils 的方法参数"+cls.getName());
        if (res == null) {
            for (Annotation annotation : cls.getAnnotations()) {
                if (annotation instanceof Documented ||annotation instanceof Retention
                        ||  annotation instanceof Target) {
                    break;
                }
                res = getAnnotation(annotation.annotationType(), annotationClass);
                //递归调用
                if (res != null)
                    break;
            }
        }

        return res;
    }

    public static <T, A extends Annotation> A getAnnotation(T obj, Class<A> annotationClass) {
        return getAnnotation(obj.getClass(), annotationClass);
    }
}
