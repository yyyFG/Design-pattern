public class AdapterPattern {
    public static void main(String[] args) {
        USB usb = new Adapter();
        usb.Request();
    }
}

class USB {
    public void Request(){
        System.out.println("普通请求");
    }
}

class Adapter extends USB {
    private TyperC typerC = new TyperC();

    @Override
    public void Request(){
        typerC.SpecificRequest();
    }
}

class TyperC {
    public void SpecificRequest(){
        System.out.println("TyperC");
    }
}
