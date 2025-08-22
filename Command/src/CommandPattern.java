public class CommandPattern {
    public static void main(String[] args) {
        Tv tv = new Tv();

        Command onCommand = new OnCommand(tv);
        Command offCommand = new OffCommand(tv);

        Invoker invoker = new Invoker();
        invoker.setCommand(onCommand);
        invoker.call();

        System.out.println("-------------------------");

        invoker.setCommand(offCommand);
        invoker.call();

    }
}

class Invoker {  // 请求者
    private Command command;  // 命令

    public void setCommand(Command command){   // 设置请求者 的 请求的命令
        this.command = command;
    }

    public void call(){
        command.Execute();
    }
}

interface Command {  // 命令接口
    public void Execute();  // 执行接口

}

class OnCommand implements Command {  // 开机命令
    private Tv tv;

    public OnCommand(Tv tv){
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OnAction();
    }
}

class OffCommand implements Command {   // 关机命令
    private Tv tv;

    public OffCommand(Tv tv){
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OffAction();
    }
}

class Tv {
    public void OnAction(){
        System.out.println("开机了");
    }

    public void OffAction(){
        System.out.println("关机了");
    }
}
