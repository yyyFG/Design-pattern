public class BridgePattern {
    public static void main(String[] args) {
        Product productA = new ProductA();
        Color red = new Red();
        productA.setName("A");
        productA.setColor(red);
        productA.Operation();
    }
}

abstract class Product {
    private String name;
    protected Color color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void Operation();
}

class ProductA extends Product{

    @Override
    public void Operation() {
        color.OperationImp(this.getName());
    }
}

interface Color {
    public void OperationImp(String name);
}

class Red implements Color{

    @Override
    public void OperationImp(String name) {
        System.out.println(name + " red");
    }
}

class Blue implements Color{

    @Override
    public void OperationImp(String name) {
        System.out.println(name + " blue");
    }
}