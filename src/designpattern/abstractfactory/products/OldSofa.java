package designpattern.abstractfactory.products;

public class OldSofa extends Product implements ISofa{

    public OldSofa() {
        super("OldSofa",12);
    }
    @Override
    public void sitOnSofa() {
        System.out.println("Currently sitting on a old sofa...");
    }
}
