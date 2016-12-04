package utility;

import beans.pojo.Student;
import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by chaoshuai.li on 2016/12/4.
 */
public class ObjectUse {

    /*guava中的objects类中的方法主要是hash，equals*/
    public static void main(String[] args) {
        Student student = new Student(10 , "lili");
        Student student_tmp = new Student(10 , "lilei");
        Student student1 = new Student(10 , "lilei");

        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(student);
        studentSet.add(student_tmp);
        studentSet.add(student1);

        System.out.println(studentSet.size());

        System.out.println(JSON.toJSONString(studentSet));

//        System.out.println(student.equals(student_tmp));
    }
}
