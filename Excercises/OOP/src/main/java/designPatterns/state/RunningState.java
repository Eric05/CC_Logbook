package designPatterns.state;

public class RunningState implements State {

    public void doAction(Context context) {
              context.setState(this);
    }

    public String toString(){
        return "Player is in second half";
    }
}
