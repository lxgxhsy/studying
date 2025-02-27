package Jichu.Test;

/**
 * @Author: shiyong
 * @CreateTime: 2025-02-18
 * @Description:
 * @Version: 1.0
 */


import java.lang.annotation.Annotation;

import java.lang.reflect.Field;

// 自定义注解

public class AnnotationExample {
	public static void main(String[] args) throws Exception {
		// 获取目标类和目标对象
		Class<?> targetClass  = Class.forName("Jichu.Test.TargetObject");
		TargetObject targetObject = (TargetObject) targetClass.getDeclaredConstructor().newInstance();

		// 获取字段
		Field field = targetClass.getDeclaredField("value");
		// 为了对类中的参数进行修改我们取消安全检查
		field.setAccessible(true);
		// 设置字段的值
		field.set(targetObject, "HHHH");

		// 获取字段上的所有注解
		Annotation[] annotations = field.getAnnotations();

		// 遍历注解数组
		for (Annotation annotation : annotations) {
			// 获取注解的名称
			String annotationName = annotation.annotationType().getName();
			System.out.println("注解名称: " + annotationName);

			// 获取注解类的所有方法
			java.lang.reflect.Method[] methods = annotation.annotationType().getDeclaredMethods();
			for (java.lang.reflect.Method method : methods) {
				try {
					// 获取方法的默认值
					Object defaultValue = method.getDefaultValue();
					System.out.println("注解属性 " + method.getName() + " 的默认值: " + defaultValue);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
