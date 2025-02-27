package Jichu.Test.Gather.Collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: shiyong
 * @CreateTime: 2025-02-27
 * @Description: ArrayList 看看
 * @Version: 1.0
 */

/**
 * 头部插入：由于需要将所有元素都依次向后移动一个位置，因此时间复杂度是 O(n)。
 * 尾部插入：当 ArrayList 的容量未达到极限时，往列表末尾插入元素的时间复杂度是 O(1)，
 * 因为它只需要在数组末尾添加一个元素即可；当容量已达到极限并且需要扩容时，
 * 则需要执行一次 O(n) 的操作将原数组复制到新的更大的数组中，然后再执行 O(1) 的操作添加元素。
 * 指定位置插入：需要将目标位置之后的所有元素都向后移动一个位置，然后再把新元素放入指定位置。
 * 这个过程需要移动平均 n/2 个元素，因此时间复杂度为 O(n)。
 * 对于删除：
 * 头部删除：由于需要将所有元素依次向前移动一个位置，因此时间复杂度是 O(n)。
 * 尾部删除：当删除的元素位于列表末尾时，时间复杂度为 O(1)。
 * 指定位置删除：需要将目标元素之后的所有元素向前移动一个位置以填补被删除的空白位置，因此需要移动平均 n/2 个元素，
 * 时间复杂度为 O(n)。
 * @author 诺诺

 */
public class ArrayListDemo {
	public static void main(String[] args) {
		// 插入 删除 O(n)  读取 查找O(1) 符合我对数组的一个意识
		ArrayList<String> testDemo = new ArrayList<>(Arrays.asList("Hello","lxg","!"));
		testDemo.add("ada");
		testDemo.removeIf(s -> s.equals("aaaa"));
		testDemo.add(1,"asasa");
	    testDemo.stream().filter(s -> {
		    return s.length() > 1;
	    }).sorted(Comparator.naturalOrder())
		.map(a -> a + " ") //处理对象的属性
	    .forEach(System.out::printf);
		System.out.println("     "+ "\n" + Arrays.asList(testDemo));




		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(-1);
		arrayList.add(3);
		arrayList.add(3);
		arrayList.add(-5);
		arrayList.add(7);
		arrayList.add(4);
		arrayList.add(-9);
		arrayList.add(-7);
		System.out.println("原始数组:");
		System.out.println(arrayList);
        // void reverse(List list)：反转
		Collections.reverse(arrayList);
		System.out.println("Collections.reverse(arrayList):");
		System.out.println(arrayList);

       // void sort(List list),按自然排序的升序排序
		Collections.sort(arrayList);
		System.out.println("Collections.sort(arrayList):");
		System.out.println(arrayList);
        // 定制排序的用法 匿名内部类
		Collections.sort(arrayList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return  o2 - o1;
			}
		});
		System.out.println("定制排序后：");
		System.out.println(arrayList);
	}
}
