package designPatterns.observer_Progress;

public class ProgressObserver extends Observer {

    public <T> ProgressObserver(Subject subject){
        this.subject = subject;
        this.max = max;
        this.subject.setObserver(this);
       }

    @Override
    public void update() {
        var res = Math.round(  (Double.valueOf(subject.getState()) / (Double) 10.0) * 100) ;

        System.out.println( "Progress: " + res + " % ");
    }
}
