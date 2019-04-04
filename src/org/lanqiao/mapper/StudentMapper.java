package org.lanqiao.mapper;

import java.util.List;

import org.lanqiao.entity.Student;

//操作Mybatis的接口
public interface StudentMapper {
    //接口里的抽象方法 默认都是public abstract 修饰的
	
	Student queryStudentByStuno(int stuno);

	void addStudent(Student student);

	void deleteStudentByStuno(int stuno);

	void updateStudentByStuno(Student student);

	List<Student> queryAllStudents();
	
	void addStudentWithConverter(Student student);
}
