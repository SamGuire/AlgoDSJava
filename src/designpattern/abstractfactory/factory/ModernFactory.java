package designpattern.abstractfactory.factory;

import designpattern.abstractfactory.products.*;
public class ModernFactory implements IFactory {

    public ModernFactory(){}
    @Override
    public IChair createChair() {
        System.out.println("I am creating a modern chair");
        return new ModernChair();
    }

    @Override
    public ISofa createSofa() {
        System.out.println("I am creating a modern sofa");
        return new ModernSofa();
    }
}
