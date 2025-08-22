import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {

    public static void main(String[] args) {
        PersonStructure structure = new PersonStructure();

        Visitor1 visitor1 = new Visitor1();
        System.out.println();
        structure.Accept(visitor1);
    }
}


interface  Visitor{
    public void visitStudent(Student student);
    public void visitTeacher(Teacher teacher);
}

class Visitor1 implements Visitor{
    private int studentAgeSum = 0;
    private int teacherAgeSum = 0;

    @Override
    public void visitStudent(Student student) {
        System.out.println("访问者1访问学生： " + student.getName() + " 年龄：" + student.getAge());
        studentAgeSum += student.getAge();
    }

    @Override
    public void visitTeacher(Teacher teacher) {
        System.out.println("访问者1访问老师：" + teacher.getName() + " 年龄：" + teacher.getAge());
        teacherAgeSum += teacher.getAge();
    }
}

class Visitor2 implements Visitor{

    @Override
    public void visitStudent(Student student) {

    }

    @Override
    public void visitTeacher(Teacher teacher) {

    }
}

class PersonStructure{
    private List<Person> personList = new ArrayList<Person>();

    public PersonStructure(){
        personList.add(new Student("zhangsan", 20, 70));
        personList.add(new Student("lisi", 21, 80));
        personList.add(new Student("wangwu", 22, 90));

        personList.add(new Teacher("wanglaoshi", 26, 3));
        personList.add(new Teacher("lilaoshi", 28, 4));
        personList.add(new Teacher("zhanglaoshi", 29, 5));
    }

    public void Accept(Visitor visitor) {
        for(Person person: personList){
            person.Accept(visitor);
        }
    }
}


abstract class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void Accept(Visitor visitor);
}

class Student extends Person{
    private int score;

    public Student(String name, int age, int score){
        super(name, age);

        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.visitStudent(this);
    }
}

class Teacher extends Person{
    private int workYear;



    public Teacher(String name, int age, int workYear){
        super(name, age);
        this.workYear = workYear;
    }

    public int getWorkYear() {
        return workYear;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.visitTeacher(this);
    }
}