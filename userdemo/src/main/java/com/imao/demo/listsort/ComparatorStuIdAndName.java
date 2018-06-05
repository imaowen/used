package com.imao.demo.listsort;

import java.util.Comparator;
/*
 * 具体的比较类，实现Comparator接口
 * 按学生Id排序,相同的再以name排序
 */
public class ComparatorStuIdAndName  implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		Student stu0 = (Student) arg0;
		Student stu1 = (Student) arg1;
		int flag = stu0.getId() - stu1.getId();
		if(flag == 0){
			flag = stu0.getName().compareTo(stu1.getName());
		}
		
		return flag;
	}

}
