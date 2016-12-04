package beans.pojo;

import com.google.common.collect.ComparisonChain;

/**
 * Created by chaoshuai.li on 2016/12/4.
 */
public class Student implements Comparable{

    private int number;
    private String name;

    //当提供了有参数的构造函数的时候也需要提供无参的构造函数
    public Student(){

    }

    public Student(int number , String name){
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int hashCode(){
        return 100;
    }

    //对象比较的时候需要重写equals方法 比如equals（） ， ==的时候
    @Override
    public boolean equals(Object var1) {
        return this.compareTo(var1) == 0 ? true : false;
    }

    public int compareTo(Object o) {

        Student student = (Student) o;
        return ComparisonChain.start()
                .compare(this.getName() , student.getName())
                .compare(this.getNumber() , student.getNumber())
                .result();
    }
}
