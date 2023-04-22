package designpattern.factory;

import designpattern.factory.creator.IConsoleFactory;
import designpattern.factory.creator.SonyFactory;
import designpattern.factory.product.*;

public class Client {

    public static void main(String[] args) {
        IConsoleFactory factory = new SonyFactory();
        IConsole console = factory.createConsole();
        console.play();

    }
}
