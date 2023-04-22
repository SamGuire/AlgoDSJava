package designpattern.factory.creator;

import designpattern.factory.product.IConsole;
import designpattern.factory.product.Playstation;

public class SonyFactory implements IConsoleFactory{
    public IConsole createConsole(){
        System.out.println("Creating a playstation from sony factory...");
        return new Playstation();
    }
}
