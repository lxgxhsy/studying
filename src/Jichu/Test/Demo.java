package Jichu.Test;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: sy
 * @CreateTime: 2024-09-12
 * @Description: demo
 * @Version: 1.0
 */


public class Demo {
	public static void main(String[] args) throws Exception {
		/**
		 * 获取 TargetObject 类的 Class 对象并且创建 TargetObject 类实例
		 */
		Class<?> targetClass = Class.forName("Jichu.Test.TargetObject");
		TargetObject targetObject = (TargetObject) targetClass.getDeclaredConstructor().newInstance();

		/**
		 * 获取指定方法并调用
		 */
		Method[] methods = targetClass.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println("Method: " + m.getName());
		}

		/**
		 * 获取指定参数并对参数进行修改
		 */
		Field[] fields = targetClass.getDeclaredFields();
		for (Field m : fields) {
			System.out.println("Field: " + m.getName());
		}

		Field field = targetClass.getDeclaredField("value");
		// 为了对类中的参数进行修改我们取消安全检查
		field.setAccessible(true);
		field.set(targetObject, "HHHH");

		Annotation[] annotations = field.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("Annotation: " + annotation.annotationType().getName());
		}

		/**
		 * 调用 private 方法
		 */
		Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
		privateMethod.setAccessible(true);
		privateMethod.invoke(targetObject);
	}
}

