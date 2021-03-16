package dataBases.controller;

import dataBases.models.Food;
import dataBases.view.MainView;

public class MainRoutine {
    private MainView view;
    private Food food;

    public MainRoutine(MainView view, Food food) {
        this.view = view;
        this.food = food;
    }

    public void routine(){
        view.printScreen();
        var inp = view.getInput();
    }
}
