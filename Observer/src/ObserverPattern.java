import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    public static void main(String[] args) {
        Subject subjectA = new ConcreteSubject("目标A");

        Observer observerB = new ConcreteObserver("张三", subjectA);
        Observer observerC = new ConcreteObserver("李四", subjectA);
        Observer observerD = new ConcreteObserver("wangwu", subjectA);

//        System.out.println("change!!!!");
        subjectA.setState("更新了");

        System.out.println("+++++++++++++++++++++");
        subjectA.Detach(observerC);

        subjectA.setState("停更了");
    }
}


interface Subject {  // 目标
    public void Attach(Observer observer);
    public void Detach(Observer observer);
    public void Notify();

    public void setState(String state);
    public String getState();
}

class ConcreteSubject implements Subject {
    private String name;
    private String state;
    private List<Observer> observerList;

    public ConcreteSubject(String name) {
        state = "未更新";
        this.name = name;

        observerList = new ArrayList<Observer>();
    }

    @Override
    public void Attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void Detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer observer : observerList){
            observer.update();
        }
    }

    @Override
    public void setState(String state) {
        this.state = state;

        System.out.println(name + " 的状态发生变化，变化后的状态为: " + state);
        Notify();
    }

    @Override
    public String getState() {
        return state;
    }
}

interface Observer {  // 观察者接口
    public void update();   // 收到通知 更新观察者的状态
}

class ConcreteObserver implements Observer {
    private String state;

    private String name;

    private Subject subject;

    public ConcreteObserver(String name, Subject subject){
        this.name = name;
        this.subject = subject;

        subject.Attach(this);
        state = subject.getState();
    }

    @Override
    public void update() {
        System.out.println(name + "收到通知");
        state = subject.getState();

        System.out.println(name + " 改变后的状态为：" + state);
    }
}