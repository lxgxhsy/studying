package JucStudying.Test;

/**
 * @Author: shiyong
 * @CreateTime: 2024-12-31
 * @Description:
 * 线程类已经继承了 Thread 类无法继承其他类了，功能不能通过继承拓展（单继承的局限性）
 * Thread 创建线程方式：创建线程类，匿名内部类方式
 *
 * * **start() 方法底层其实是给 CPU 注册当前线程，并且触发 run() 方法执行**
 * * 线程的启动必须调用 start() 方法，如果线程直接调用 run() 方法，相当于变成了普通类的执行，此时主线程将只有执行该线程
 * * 建议线程先创建子线程，主线程的任务放在之后，否则主线程（main）永远是先执行完
 *
 * Thread 构造器：
 *
 * * `public Thread()`
 * * `public Thread(String name)`
 * @Version: 1.0
 */


public class ThreadDemo {
	public static void main(String[] args) {
		Thread t = new MyThread();
		t.start();
		for(int i = 0 ; i < 100 ; i++ ){
			System.out.println("main线程" + i);
		}
		// main线程输出放在上面 就变成有先后顺序了，因为是 main 线程驱动的子线程运行
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++ ) {
			System.out.println("子线程输出："+i);
		}
	}
}
