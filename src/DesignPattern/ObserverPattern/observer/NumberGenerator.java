package DesignPattern.ObserverPattern.observer;

import java.util.ArrayList;


public abstract class NumberGenerator {
    private ArrayList observers = new ArrayList();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Object observer : observers) {
            Observer o = (Observer) observer;
            o.update(this);
        }
    }

    public abstract int getNumber();

    public abstract void execute();
}
