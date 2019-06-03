package jdk.pattern;

import java.util.Observable;
import java.util.Observer;

public class ObserverClass implements Observer {
    private String name;

    public ObserverClass(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + ":" + arg);
    }
}
