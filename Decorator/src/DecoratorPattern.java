public class DecoratorPattern {
    public static void main(String[] args) {
        Person zhangsan = new Student("张三");
//        zhangsan.Operation();
//        Decorator decoratorA = new DecoratorA(zhangsan);
        zhangsan = new DecoratorA(zhangsan);
        zhangsan = new DecoratorB(zhangsan);
        zhangsan.Operation();

        System.out.println("---------------------");

        // 对象链
        Person lisi = new DecoratorB(new DecoratorA(new Student("里斯")));
        lisi.Operation();
    }
}

abstract class Decorator extends Person {
    protected Person person;
}

class DecoratorA extends Decorator {
    public DecoratorA(Person person){
        this.person = person;
    }

    @Override
    public void Operation() { // 职责
        person.Operation();   // 原本的职责
        System.out.println("写作业");
    }
}

class DecoratorB extends Decorator {
    public DecoratorB(Person person){
        this.person = person;
    }

    @Override
    public void Operation() { // 职责
        person.Operation();   // 原本的职责
        System.out.println("背单词");
    }
}

abstract class Person {
    protected String name;

    public abstract void Operation();
}

class Student extends Person {
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void Operation() {
        System.out.println(name + "的职责: study");
    }
}