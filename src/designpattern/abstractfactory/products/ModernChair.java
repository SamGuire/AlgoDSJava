package designpattern.abstractfactory.products;

public class ModernChair extends Product implements IChair {

    public ModernChair(){
        super("ModernChair",10);
    }
    @Override
    public void sitOnChair() {
        System.out.println("Currently sitting on a modern chair...");
    }

}
