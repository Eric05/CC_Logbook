package designPatterns.observer_Progress;

public abstract class Observer<T> {
    protected Subject subject;
    protected T max;
    public abstract void update();
}