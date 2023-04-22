package designpattern.factory.creator;

import designpattern.factory.product.IConsole;
import designpattern.factory.product.Xbox;

public class MicrosoftFactory implements IConsoleFactory{
    public IConsole createConsole(){
        System.out.println("Creating a xbox from microsoft factory...");
        return new Xbox();
    }
}
