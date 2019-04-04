package org.lanqiao.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lanqiao.entity.Student;
import org.lanqiao.mapper.StudentMapper;

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

	
	public static void main(String[] args) throws IOException {

	
	//delteStudentByStuno();
	queryAllStudents();
addStudentWithConverter();
	queryAllStudents();
	
	}
}
