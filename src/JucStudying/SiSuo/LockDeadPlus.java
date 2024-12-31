package JucStudying.SiSuo;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: shiyong
 * @CreateTime: 2024-12-31
 * @Description:
 * @Version: 1.0
 */


public class LockDeadPlus {
	public static Object resources1 = new Object();
	public static Object resources2 = new Object();

	public static void main(String[] args) {

		// 创建并启动线程1
		Thread thread1 = new Thread(() -> {
			// 线程1占用resources1，并尝试获取resources2
			synchronized (resources1) {
				System.out.println(Thread.currentThread().getName() + " 获取到资源1");
				try {
					Thread.sleep(2000); // 模拟占用资源1的工作
					synchronized (resources2) {
						System.out.println(Thread.currentThread().getName() + " 获取到资源2");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread1.setName("线程-1");
		thread1.start();

		// 创建并启动线程2
		Thread thread2 = new Thread(() -> {
			// 线程2占用resources2，并尝试获取resources1
			synchronized (resources2) {
				System.out.println(Thread.currentThread().getName() + " 获取到资源2");
				try {
					Thread.sleep(2000); // 模拟占用资源2的工作
					synchronized (resources1) {
						System.out.println(Thread.currentThread().getName() + " 获取到资源1");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread2.setName("线程-2");
		thread2.start();

		// 另起线程进行超时监测
		new Thread(() -> {
			try {
				Thread.sleep(5000); // 等待5秒钟，检查线程是否仍在运行
				if (thread1.isAlive() && thread2.isAlive()) {
					System.out.println("超时提醒：两个线程仍在运行，可能发生了死锁");
					checkNetworkConnection(); // 检查网络连接
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	// 检查网络连接
	private static void checkNetworkConnection() {
		String url = "http://www.google.com"; // 使用Google进行网络连接检查
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.setConnectTimeout(2000); // 设置连接超时为2秒
			int responseCode = connection.getResponseCode();
			if (responseCode == 200) {
				System.out.println("网络连接正常");
			} else {
				System.out.println("网络不可达，响应码：" + responseCode);
			}
		} catch (Exception e) {
			System.out.println("网络错误：无法连接到 " + url);
		}
	}
}
