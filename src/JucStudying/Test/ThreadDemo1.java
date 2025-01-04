package JucStudying.Test;

import jdk.nashorn.internal.runtime.logging.Logger;

/**
 * @Author: shiyong
 * @CreateTime: 2024-12-31
 * @Description:
 * Runnable 创建线程方式：创建线程类，匿名内部类方式
 * Thread 类本身也是实现了 Runnable 接口，Thread 类中持有 Runnable 的属性，执行线程 run 方法底层是调用 Runnable#run：
 *
 *   Thread 的构造器：
 *
 * * `public Thread(Runnable target)`
 * * `public Thread(Runnable target, String name)`
 *
 * Runnable 方式的优缺点：
 *
 * * 缺点：代码复杂一点。
 *
 * * 优点：
 *
 *   1. 线程任务类只是实现了 Runnable 接口，可以继续继承其他类，避免了单继承的局限性
 *
 *   2. 同一个线程任务对象可以被包装成多个线程对象
 *
 *   3. 适合多个多个线程去共享同一个资源
 *
 *   4. 实现解耦操作，线程任务代码可以被多个线程共享，线程任务代码和线程独立
 *
 *   5. 线程池可以放入实现 Runnable 或 Callable 线程任务对象
 * @Version: 1.0
 */

@Logger
public class ThreadDemo1 {
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		Runnable target = new MyRunnable();
		Thread t1 = new Thread(target,"1号进程");
		t1.start();
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin));
		Thread t2 = new Thread(target,"2号进程");//Thread-0
		t2.start();


	}
}

class MyRunnable implements Runnable{
	@Override
	public void run() {
		for(int i = 0 ; i < Integer.MAX_VALUE >> 20 ; i++ ){
			System.out.println(Thread.currentThread().getName() + "->" + i);
			System.out.println(Thread.currentThread().getId() + "->" + i);
			System.out.println(Thread.currentThread().isAlive() + "->" + i);
			System.out.println(Thread.currentThread().getContextClassLoader() + "->" + i);
			System.out.println(Thread.currentThread().getThreadGroup() + "->" + i);
			System.out.println(Thread.currentThread().getThreadGroup() + "->" + i);
			System.out.println(Thread.currentThread().toString() + "->" + i);
		}
	}
}
