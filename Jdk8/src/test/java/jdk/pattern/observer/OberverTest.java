package jdk.pattern.observer;

import jdk.pattern.ObservableClass;
import jdk.pattern.ObserverClass;
import org.junit.jupiter.api.Test;

public class OberverTest {
    @Test
    void test() {

        ObservableClass observableClass = new ObservableClass();
        ObserverClass observerClass1 = new ObserverClass("observerClass1");
        ObserverClass observerClass2 = new ObserverClass("observerClass2");
        ObserverClass observerClass3 = new ObserverClass("observerClass3");
        ObserverClass observerClass4 = new ObserverClass("observerClass4");

        observableClass.addObserver(observerClass1);
        observableClass.addObserver(observerClass2);
        observableClass.addObserver(observerClass3);
        observableClass.addObserver(observerClass4);

        observableClass.setMessage("收到通知，完成更新。");
    }
}
