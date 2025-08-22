public class StrategyPattern {
    public static void main(String[] args) {
        Strategy add = new AddStrategy();
        Strategy sub = new SubStrategy();
        Strategy mul = new MulStrategy();

        OperationContext context = new OperationContext(add);
        context.Operation(2022, 258);
    }
}


class OperationContext {
    private Strategy strategy;

    public OperationContext(Strategy strategy){
        this.strategy = strategy;
    }

    public void Operation(int a, int b){
        strategy.TwoNumberOperation(a,b);
    }
}

interface Strategy {
    public void TwoNumberOperation(int a, int b);
}

class AddStrategy implements Strategy {

    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a + b);
    }
}

class SubStrategy implements Strategy{

    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a - b);
    }
}

class MulStrategy implements Strategy{


    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a * b);
    }
}