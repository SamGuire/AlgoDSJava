package designpattern.abstractfactory.factory;
import designpattern.abstractfactory.products.*;
public interface IFactory {
    IChair createChair();
    ISofa createSofa();
}
