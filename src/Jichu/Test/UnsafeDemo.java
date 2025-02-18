package Jichu.Test;

import lombok.Data;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: shiyong
 * @CreateTime: 2025-02-19
 * @Description: 玩一下unsafe哈哈哈
 * @Version: 1.0
 */


public class UnsafeDemo {
	public static void main(String[] args) throws Exception {
			User user=new User();
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			Unsafe unsafe =  (Unsafe) field.get(null);
			// 也可以用下面的语句触发类初始化
			// 1.
			// unsafe.ensureClassInitialized(User.class);
			// 2.
			// System.out.println(User.name);
			System.out.println(unsafe.shouldBeInitialized(User.class));
			Field sexField = User.class.getDeclaredField("name");
			long fieldOffset = unsafe.staticFieldOffset(sexField);
			Object fieldBase = unsafe.staticFieldBase(sexField);
			Object object = unsafe.getObject(fieldBase, fieldOffset);
			System.out.println(object);
		}

}
