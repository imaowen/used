package com.imao.demo.listsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * 测试list排序
 */
public class ListSortTest {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(2, "aa", 28));
		list.add(new Student(1, "ff", 22));
		list.add(new Student(5, "ac", 26));
		list.add(new Student(1, "cd", 21));
		list.add(new Student(3, "ba", 22));
		
		//按学生id排序
		Collections.sort(list, new ComparatorStuId());
		System.out.println("按学生id排序");
		for (Student stu : list) {
			System.out.println(stu.getId() +"\t" + stu.getName() +"\t"+ stu.getAge());
		}
		
		//按学生name排序
		Collections.sort(list, new ComparatorStuName());
		System.out.println("\n按学生name排序");
		for (Student stu : list) {
			System.out.println(stu.getId() +"\t" + stu.getName() +"\t"+ stu.getAge());
		}
		
		//按学生age排序
		Collections.sort(list, new ComparatorStuAge());
		System.out.println("\n按学生age排序");
		for (Student stu : list) {
			System.out.println(stu.getId() +"\t" + stu.getName() +"\t"+ stu.getAge());
		}
		
		//按学生Id排序,相同的再以name排序
		Collections.sort(list, new ComparatorStuIdAndName());
		System.out.println("\n按学生Id排序,相同的再以name排序");
		for (Student stu : list) {
			System.out.println(stu.getId() +"\t" + stu.getName() +"\t"+ stu.getAge());
		}
		
	}

}
