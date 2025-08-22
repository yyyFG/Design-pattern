public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Product product1 = new Product(2022, 5.28);
        System.out.println(product1.getId() + " " + product1.getPrice());

//        Product product2 = new Product(2022, 5.28);
        Product product2 = (Product) product1.clone();
        System.out.println(product2.getId() + " " + product2.getPrice());
    }
}


interface Prototype {
    public Object Clone();
}

class Product implements Cloneable {
    private int id;
    private double price;

    public Product (){}

    public Product (int id, double price){
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}