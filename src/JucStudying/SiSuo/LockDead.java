package JucStudying.SiSuo;

/**
 * @Author: sy
 * @CreateTime: 2024-12-31
 * @Description:
 * @Version: 1.0
 */


public class LockDead {
	public static final Object resources1 = new Object();
	public static final Object resources2 = new Object();
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			// 线程1 占用资源1 请求资源2
			synchronized (resources1) {
				System.out.println(Thread.currentThread() + "获取到资源1");
				try {
					Thread.sleep(2000); //休息两秒 防止线程1运行完
					 synchronized (resources2) {
					System.out.println("线程1占用了资源2");
				}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.setName("线程1");
		t1.start();

		Thread t2 = new Thread(() -> {
			// 线程1 占用资源1 请求资源2
			synchronized (resources2) {
				System.out.println(Thread.currentThread() + "获取到资源2");
				try {
					Thread.sleep(2000); //休息两秒 防止线程1运行完
					synchronized (resources1) {
						System.out.println("线程2占用了资源1");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t2.setName("线程2");
		t2.start();
	}
}
