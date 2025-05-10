
package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColorManager implements Subject {
    private static ColorManager instance;
    private Color currentColor;
    private final List<Observer> observers;

    private ColorManager() {
        currentColor = Color.BLACK;
        observers = new ArrayList<>();
    }

    public static ColorManager getInstance() {
        if (instance == null) {
            instance = new ColorManager();
        }
        return instance;
    }

    public void setColor(Color newColor) {
        currentColor = newColor;
        notifyObservers();
    }

    public Color getColor() {
        return currentColor;
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(currentColor);
        }
    }
}
