package designpattern.abstractfactory.products;

public class OldChair extends Product implements IChair{

    public OldChair() {
        super("OldChair",5);
    }
    @Override
    public void sitOnChair() {
        System.out.println("Currently sitting on a old chair...");
    }

}
