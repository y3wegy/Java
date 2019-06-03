package jdk.pattern;

import java.util.Observable;

public class ObservableClass extends Observable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        //被观察者数据发生变化时，通过以下两行代码通知所有的观察者
        this.setChanged();
        this.notifyObservers(message);
    }
}
