package JucStudying.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: shiyong
 * @CreateTime: 2025-01-02
 * @Description: 实现Callable接口
 * 1. 定义一个线程任务类实现 Callable 接口，申明线程执行的结果类型
 * 2. 重写线程任务类的 call 方法，这个方法可以直接返回执行的结果
 * 3. 创建一个 Callable 的线程任务对象
 * 4. 把 Callable 的线程任务对象**包装成一个未来任务对象**
 * 5. 把未来任务对象包装成线程对象
 * 6. 调用线程的 start() 方法启动线程
 *
 * `public FutureTask(Callable<V> callable)`：未来任务对象，在线程执行完后得到线程的执行结果
 *
 * * FutureTask 就是 Runnable 对象，因为 **Thread 类只能执行 Runnable 实例的任务对象**，所以把 Callable 包装成未来任务对象
 * * 线程池部分详解了 FutureTask 的源码
 *
 * `public V get()`：同步等待 task 执行完毕的结果，如果在线程中获取另一个线程执行结果，会阻塞等待，用于线程同步
 *
 * * get() 线程会阻塞等待任务执行完成
 * * run() 执行完后会把结果设置到 FutureTask  的一个成员变量，get() 线程可以获取到该变量的值
 *
 * 优缺点：
 *
 * * 优点：同 Runnable，并且能得到线程执行的结果
 * * 缺点：编码复杂
 * @Version: 1.0
 */


public class ThreadDemoByCallable implements Callable<String>{

	@Override
    public String call() throws Exception {
	return Thread.currentThread().getName() + "->" + "Hello World";
    }
	public static void main(String[] args) {
		ThreadDemoByCallable call = new ThreadDemoByCallable();
        FutureTask<String> task = new FutureTask<>(call);
        Thread t = new Thread(task);
        t.start();
		try {
			String s = task.get(); // 获取call方法返回的结果（正常/异常结果）
			System.out.println(s);
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
}