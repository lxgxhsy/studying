package JucStudying.Test;

/**
 * @Author: shiyong
 * @CreateTime: 2024-12-31
 * @Description:
 * @Version: 1.0
 */


public class ThreadDemo1 {
	public static void main(String[] args) {
		Runnable target = new MyRunnable();
		Thread t1 = new Thread(target,"1号线程");
		t1.start();
		Thread t2 = new Thread(target);//Thread-0
	}
}

class MyRunnable implements Runnable{
	@Override
	public void run() {
		for(int i = 0 ; i < 100000 ; i++ ){
			System.out.println(Thread.currentThread().getName() + "->" + i);
			System.out.println(Thread.currentThread().getId() + "->" + i);
			System.out.println(Thread.currentThread().isAlive() + "->" + i);
			System.out.println(Thread.currentThread().getContextClassLoader() + "->" + i);
			System.out.println(Thread.currentThread().getThreadGroup() + "->" + i);
			System.out.println(Thread.currentThread().getThreadGroup() + "->" + i);
			String a = Thread.currentThread().toString();
		}
	}
}
