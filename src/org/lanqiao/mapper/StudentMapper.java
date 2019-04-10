package org.lanqiao.mapper;

import java.util.List;

import org.lanqiao.entity.Grade;
import org.lanqiao.entity.Student;
import org.lanqiao.entity.StudentClass;

//操作Mybatis的接口
public interface StudentMapper {
    //接口里的抽象方法 默认都是public abstract 修饰的
	
	Student queryStudentByStuno(int stuno);

	void addStudent(Student student);

	void deleteStudentByStuno(int stuno);

	void updateStudentByStuno(Student student);

	List<Student> queryAllStudents();
	
	void addStudentWithConverter(Student student);
	//属性
    List<Student> queryStudentsWithNosInGrade(Grade grade);
    //数组
   List<Student> queryStudentsWithArray(int[] stuNo);
   //集合
    List<Student> queryStudentsWithList(List<Integer> stuNo);
    //对象数组
    List<Student>  queryStudentsWithObjectArray(Object[] students);
    //1对1 resultMap
    Student queryStudentByNoWithOO(int stuNo);
    
    //1对多 resultMap
    StudentClass queryClassAndStudents(int classId);
    
    
}
