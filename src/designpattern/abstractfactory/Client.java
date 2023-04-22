package designpattern.abstractfactory;

import designpattern.abstractfactory.factory.*;
import designpattern.abstractfactory.products.*;

public class Client {

    public static void main(String[] args) {
        IFactory factory = new ModernFactory();

        // Get me a chair
        IChair chair = factory.createChair();
        chair.sitOnChair();
        System.out.println(chair);

        // Get me a sofa

        ISofa sofa = factory.createSofa();
        sofa.sitOnSofa();
        System.out.println(sofa);

        factory = new OldFactory();

        // Get me a chair
        chair = factory.createChair();
        chair.sitOnChair();
        System.out.println(chair);

        // Get me a sofa

        sofa = factory.createSofa();
        sofa.sitOnSofa();
        System.out.println(sofa);



    }
}
