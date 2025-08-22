import java.util.ArrayList;
import java.util.List;

public class Main {

}

abstract class Builder {
    public abstract void BuildPart();
    public abstract Product getResult();
}

class Product {
    List<String> parts = new ArrayList<>();

    public void Add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println("产品的组成：");
        for (String s : parts)
            System.out.println(s);

        System.out.println("\n");
    }
}