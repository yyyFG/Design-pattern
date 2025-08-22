/**
 * 简单工厂模式
 */
public class SimpleFactory {

    public static void main(String[] args) {
        Factory factory1 = new Factory1();
//        Product productA = Factory.createProduct("A");
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();
        productA1.info();
        productB1.info();

        Factory factory2 = new Factory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();
//        Product productB = Factory.createProduct("B");
        productA2.info();
        productB2.info();

    }
}


//class Factory {
//
//    public static Product createProduct(String type){
//        Product product = null;
//
//        switch (type){
//            case "A":
//                product = new ProductA();
//                break;
//            case "B":
//                product = new ProductB();
//                break;
//            default:
//                System.out.println("没有" + type + " 类型的产品！");
//                break;
//        }
//
//        return product;
//    }
//}


interface Factory {
    public ProductA createProductA();
    public ProductB createProductB();
}

class Factory1 implements Factory {

    @Override
    public ProductA createProductA(){
        return new ProductA1();
    }

    @Override
    public ProductB createProductB(){
        return new ProductB1();
    }
}

class Factory2 implements Factory {

    @Override
    public ProductA createProductA(){
        return new ProductA2();
    }

    @Override
    public ProductB createProductB(){
        return new ProductB2();
    }
}

//abstract class Product
interface ProductA {
//    public abstract void info();
    public void info();
}

interface ProductB {
    public void info();
}

//class ProductA extends Product
class ProductA1 implements ProductA{
    @Override
    public void info(){
        System.out.println("产品信息：A1");
    }
}

class ProductA2 implements ProductA{
    @Override
    public void info(){
        System.out.println("产品信息：A2");
    }
}



//class ProductB extends Product
class ProductB1 implements ProductB{

    @Override
    public void info(){
        System.out.println("产品信息：B1");
    }
}

class ProductB2 implements ProductB{

    @Override
    public void info(){
        System.out.println("产品信息：B2");
    }
}