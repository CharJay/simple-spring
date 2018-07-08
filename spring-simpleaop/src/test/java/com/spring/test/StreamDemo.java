package com.spring.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import com.spring.aop.ApplicationContext;
import com.spring.aop.DefaultAopAdvior;

/**
 * 测试java8中流的性能与传统操作的对比
 *
 */
public class StreamDemo /*implements StreamDemoInf*/{
	
	private static final int DEMO_NUM = 10;
	
	private static Integer [] demoData3 = new Integer[DEMO_NUM];
	
	private static Random random = new Random();
	
	private static List<Integer> demoData = new ArrayList<>();
	
	private Integer[] demoData2 = new Integer[DEMO_NUM];
	
	static {
		for(int i = 0;i<DEMO_NUM;i++){
			demoData.add(random.nextInt(DEMO_NUM));
		}
		Arrays.fill(demoData3, 123);
	}
	
	
	public void demoForAddDataTime(){
		for (int i = 0;i<demoData2.length;i++) {
			demoData2[i] = random.nextInt(10);
		}
		System.out.println("for add time");
	}
	
	public void demoStreamAddDataTime(){
		Arrays.asList(demoData2).stream().forEach(item->item=random.nextInt());
		System.out.println("stream add time");
	}
	
	public void demoParallelStreamAddDataTime(){
		Arrays.asList(demoData2).parallelStream().forEach(item->item=random.nextInt());
		System.out.println("parallelstream add time");
	}
	
	public void demoForDataTime(){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0;i<demoData3.length;i++) {
			if (demoData3[i] == 123) {buffer.append(demoData3[i]);}
		}
		System.out.println("for data time");
	}
	
	public void demoStreamForDataTime(){
		StringBuffer buffer = new StringBuffer();
		Arrays.asList(demoData3).stream().forEach(item->{
			if (item == 123){buffer.append(item);}
		});
		System.out.println("stream for data time");
	}
	
	public void demoParallelStreamForDataTime(){
		StringBuffer buffer = new StringBuffer();
		Arrays.asList(demoData3).parallelStream().forEach(item->{
			if (item == 123){buffer.append(item);}
		});
		System.out.println("ParallelStream for data time");
	}
	
	public void demoForFilterDataTime(){
		List data = new ArrayList();
		for (int i = 0;i<demoData.size();i++) {
			if (demoData.get(i).equals(32)) {
				data.add(demoData.get(i));
			}
		}
		List data2 = new ArrayList();
		for(int i = 0;i<data.size();i++){
			for(int j = 0;j<data.size();j++){
				if (data.get(i).equals(data.get(j)) && !data2.contains(data.get(i))) {
					data2.add(data.get(i));
					break;
				}
			}
		}
		System.out.println("for filter time");
	}
	
	public void demoStreamFilterDataTime(){
		List data = demoData.stream().filter(item->item.equals(32)).collect(Collectors.toList());
		System.out.println("stream filter time");
	}
	
	public void demoParallelStreamFilterDataTime(){
		List data = demoData.parallelStream().filter(item->item.equals(32)).collect(Collectors.toList());
		System.out.println("parallelstream filter time");
	}
	
	/**
	 * 测试并行流和一般流的区别：
	 * 	1.在执行顺序操作时，并行流每次的结果都不同，因为并行流在执行时是随机的，因此不适合执行顺序性的操作
	 *  2.并行流是非线程安全的
	 */
	@Test
	public void demoParallelStreamAndStream(){
		StringBuffer buffer = new StringBuffer();
		demoData.stream().forEach(item->{buffer.append(item);});
		System.out.println("stream for data "+buffer.toString());
		StringBuffer buffer2 = new StringBuffer();
		demoData.parallelStream().forEach(item->{buffer2.append(item);});
		System.out.println("parallelStream for data "+buffer2.toString());
		
		
		Lock lock = new ReentrantLock();
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		IntStream.range(0, 10000).forEach(list1::add);
		IntStream.range(0, 10000).parallel().forEach(item->{
			try{
			lock.lock();
			list2.add(item);
			}finally{
				lock.unlock();
			}
		});
		System.out.println(list1.size());
		System.out.println(list2.size());
	}
	
}
