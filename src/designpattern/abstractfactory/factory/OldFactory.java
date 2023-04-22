package designpattern.abstractfactory.factory;

import designpattern.abstractfactory.products.*;
public class OldFactory implements IFactory {
    public OldFactory(){}
    @Override
    public IChair createChair() {
        System.out.println("I am creating a old chair");
        return new OldChair();
    }

    @Override
    public ISofa createSofa() {
        System.out.println("I am creating a old sofa");
        return new OldSofa();
    }
}
