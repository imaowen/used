package com.imao.demo.listsort;

import java.util.Comparator;
/*
 * 具体的比较类，实现Comparator接口
 * 按学生age排序
 */
public class ComparatorStuAge  implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		Student stu0 = (Student) arg0;
		Student stu1 = (Student) arg1;
		int flag = stu1.getAge() - stu0.getAge();
		
		return flag;
	}

}
