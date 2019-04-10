package org.lanqiao.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lanqiao.entity.Grade;
import org.lanqiao.entity.Student;
import org.lanqiao.entity.StudentClass;
import org.lanqiao.mapper.StudentMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Test {


	//查询单个学生
	public static void queryStudentByStuno() throws IOException {
		//Connection -  SqlSession操作MyBatis
				//conf.xml - > reader
				Reader reader = Resources.getResourceAsReader("conf.xml") ;
				//reader  ->SqlSession
				
				//可以通过build的第二参数 指定数据库环境
				SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
				SqlSession session = sessionFacotry.openSession() ;
                StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			    Student student=studentMapper.queryStudentByStuno(1);
				System.out.println(student);
				session.close();
	}
	
	  //查询全部学生
 		public static void queryAllStudents() throws IOException {
			//Connection -  SqlSession操作MyBatis
					//conf.xml - > reader
					Reader reader = Resources.getResourceAsReader("conf.xml") ;
					//reader  ->SqlSession
					//可以通过build的第二参数 指定数据库环境
					SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
					SqlSession session = sessionFacotry.openSession() ;
					
					StudentMapper studentMapper = session.getMapper(StudentMapper.class);
					List<Student> students =studentMapper.queryAllStudents();
					System.out.println(students);
					session.close();
		}
		
 		
 		 //增加学生
 		public static void addStudent() throws IOException {
 			//Connection -  SqlSession操作MyBatis
					//conf.xml - > reader
					Reader reader = Resources.getResourceAsReader("conf.xml") ;
					//reader  ->SqlSession
					//可以通过build的第二参数 指定数据库环境
					SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
					SqlSession session = sessionFacotry.openSession() ;
				 StudentMapper studentMapper = session.getMapper(StudentMapper.class);
					Student student = new Student(3,"ww",25,"s1");
					studentMapper.addStudent(student);
					session.commit(); //提交事务
					
					session.close();
		}
 		
 		
 		 //删除学生
 		public static void delteStudentByStuno() throws IOException {
 			//Connection -  SqlSession操作MyBatis
					//conf.xml - > reader
					Reader reader = Resources.getResourceAsReader("conf.xml") ;
					//reader  ->SqlSession
					//可以通过build的第二参数 指定数据库环境
					SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
					SqlSession session = sessionFacotry.openSession() ;
					StudentMapper studentMapper = session.getMapper(StudentMapper.class);
					studentMapper.deleteStudentByStuno(1);
					session.commit(); //提交事务
					session.close();
		}
	
 		 //修改学生
 		public static void updateStudentByStuno() throws IOException {
 			//Connection -  SqlSession操作MyBatis
					//conf.xml - > reader
					Reader reader = Resources.getResourceAsReader("conf.xml") ;
					//reader  ->SqlSession
					//可以通过build的第二参数 指定数据库环境
					SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
					SqlSession session = sessionFacotry.openSession() ;
					
					//修改的参数
					Student student = new Student();
					//修改哪个人，where stuno =2 
					student.setStuNo(2);
					//修改成什么样子？
					student.setStuName("lxs");
					student.setStuAge(44);
					student.setGraName("s2");
					StudentMapper studentMapper = session.getMapper(StudentMapper.class);
					studentMapper.updateStudentByStuno(student);
					session.commit(); //提交事务
					session.close();
		}
	
 		
 	public static void addStudentWithConverter() throws IOException {
 		Reader reader = Resources.getResourceAsReader("conf.xml") ;
		//reader  ->SqlSession
		//可以通过build的第二参数 指定数据库环境
		SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
		//session相当于jdbc里的connection
		SqlSession session = sessionFacotry.openSession() ;
 		Student student=new Student();
 		student.setStuNo(8);
 		student.setStuName("ls");
 		student.setStuAge(23);
 		student.setGraName("r1");
 		student.setStuSex(true);
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        studentMapper.addStudentWithConverter(student);
        session.commit();
        session.close();
 		
 		
 	}
 	//<!-- 将多个元素值 放入对象的属性中 -->
public static void 	queryStudentsWithNosInGrade() throws IOException{
	Reader reader = Resources.getResourceAsReader("conf.xml") ;
	//reader  ->SqlSession
	//可以通过build的第二参数 指定数据库环境
	SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
	//session相当于jdbc里的connection
	SqlSession session = sessionFacotry.openSession() ;
 	StudentMapper studentMapper = session.getMapper(StudentMapper.class);
 	Grade grade=new Grade();
 	List<Integer> list=new ArrayList<Integer>();
 	list.add(1);
 	list.add(2);
 	list.add(3);
 	list.add(4);
 	list.add(8);
 	
 	grade.setStuNos(list);
 	
 	List<Student> students=studentMapper.queryStudentsWithNosInGrade(grade);
 	System.out.println(students);
 	session.commit();
 	session.close();
 	
 	
}
//数组
  public static void  queryStudentsWithArray() throws IOException {
	  Reader reader = Resources.getResourceAsReader("conf.xml") ;
		//reader  ->SqlSession
		//可以通过build的第二参数 指定数据库环境
		SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
		//session相当于jdbc里的connection
		SqlSession session = sessionFacotry.openSession() ;
	 	StudentMapper studentMapper = session.getMapper(StudentMapper.class);
	    int[] stuNo= {1,2,3,4,8};
	List<Student> students=	studentMapper.queryStudentsWithArray(stuNo);
	     System.out.println(students);
	     session.commit();
	     session.close();
	 
  }
	//集合	
 public static void queryStudentsWithList() throws IOException{
	 Reader reader = Resources.getResourceAsReader("conf.xml") ;
		//reader  ->SqlSession
		//可以通过build的第二参数 指定数据库环境
		SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
		//session相当于jdbc里的connection
		SqlSession session = sessionFacotry.openSession() ;
	 	StudentMapper studentMapper = session.getMapper(StudentMapper.class);
	    List<Integer> stuNo=new ArrayList<Integer>();
	    stuNo.add(1);
	    stuNo.add(2);
	    stuNo.add(3);
	    stuNo.add(4);
	    stuNo.add(8);
	    
List<Student> students=studentMapper.queryStudentsWithList(stuNo);
	  System.out.println(students);
	  session.commit();
	  session.close();
	  
	  
  }
 //对象数组 
public static void  queryStudentsWithObjectArray() throws IOException{
	 
	 Reader reader = Resources.getResourceAsReader("conf.xml") ;
		//reader  ->SqlSession
		//可以通过build的第二参数 指定数据库环境
		SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
		//session相当于jdbc里的connection
		SqlSession session = sessionFacotry.openSession() ;
	 	StudentMapper studentMapper = session.getMapper(StudentMapper.class);
	    Student[] students=new Student[3];
	    Student student1=new Student();
	    Student student2=new Student();
	    Student student3=new Student();
	    student1.setStuNo(1);
	    student2.setStuNo(2);
	    student3.setStuNo(3);
	    students[0]=student1;
	    students[1]=student2;
	    students[2]=student3;

	List<Student> students2 = studentMapper.queryStudentsWithObjectArray(students);
	    session.commit();
	    session.close();
	 
	 
 }

 public static void queryStudentByNoWithOO() throws IOException {
	 
	 
	 Reader reader = Resources.getResourceAsReader("conf.xml") ;
		//reader  ->SqlSession
		//可以通过build的第二参数 指定数据库环境
		SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
		//session相当于jdbc里的connection
		SqlSession session = sessionFacotry.openSession() ;
	 	StudentMapper studentMapper = session.getMapper(StudentMapper.class);
	    Student student=studentMapper.queryStudentByNoWithOO(1);
	    System.out.println(student);
	    session.commit();
	    session.close();
	 
 }
   
public static void queryClassAndStudents() throws IOException {
	
	 Reader reader = Resources.getResourceAsReader("conf.xml") ;
		//reader  ->SqlSession
		//可以通过build的第二参数 指定数据库环境
		SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
		//session相当于jdbc里的connection
		SqlSession session = sessionFacotry.openSession() ;
	 	StudentMapper studentMapper = session.getMapper(StudentMapper.class);
	
	    StudentClass studentClass=studentMapper.queryClassAndStudents(1);
		System.out.println(studentClass.getClassId()+","+studentClass.getClassName());
	   List<Student> students=studentClass.getStudents();
	    for(Student student: students) {
	    	
			System.out.println(student.getStuNo()+","+student.getStuName()+","+student.getStuAge());
	    
	    	
	    }
	    session.commit();
	    session.close();
	
	
	
	
	
}
 
 
 
	public static void main(String[] args) throws IOException {

	
	//delteStudentByStuno();
	//queryAllStudents();
   //addStudentWithConverter();
	//queryAllStudents();
//queryStudentsWithNosInGrade();
    //queryStudentsWithArray();
	//queryStudentsWithList();
		//queryStudentsWithObjectArray();
    //queryStudentByNoWithOO();
     queryClassAndStudents();
	}
}
