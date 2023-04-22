package designpattern.abstractfactory.products;

public class ModernSofa extends Product implements ISofa{

    public ModernSofa() {
        super("ModernSofa",15);
    }
    @Override
    public void sitOnSofa() {
        System.out.println("Sitting on a modern sofa...");
    }

}
