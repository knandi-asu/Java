import java.util.*;

class Student{
    int age;
    String name;
    Student(){
    }
    Student(Student s){
        this.name=s.name;
        this.age=s.age;
    }
    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);;
    }
}
public class Cons {
    public static void main(String[] args){
        Student s1=new Student();
        s1.name="Kowshik";
        s1.age=23;
        Student s2 = new Student(s1);
        s2.printInfo();

    }
}
