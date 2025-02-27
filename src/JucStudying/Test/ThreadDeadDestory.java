package JucStudying.Test;

/**
 * @Author: sy
 * @CreateTime: 2025-01-02
 * @Description: 消除死锁、
 * 顺序推进合理 就不会死锁 唯一的一个资源 谁拿到了就让谁继续 优先原则
 * @Version: 1.0
 */


public class ThreadDeadDestory {
		private static final Object resource1 = new Object();
		private static final Object resource2 = new Object();

		public static void main(String[] args) {
			new Thread(() -> {
				synchronized (resource1) {
					System.out.println(Thread.currentThread() + "get resource1");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread() + "waiting get resource2");
					synchronized (resource2) {
						System.out.println(Thread.currentThread() + "get resource2");
					}
				}
			}, "线程 1").start();

			new Thread(() -> {
				synchronized (resource1) {
					System.out.println(Thread.currentThread() + "get resource1");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread() + "waiting get resource2");
					synchronized (resource2) {
						System.out.println(Thread.currentThread() + "get resource2");
					}
				}
			}, "线程 2").start();
		}
}
