package controller;

import model.toy.Toy;
import model.toyRaffle.ToyRaffle;
import view.ToyRaffleView;

public class ToyRaffleController {
    private ToyRaffle model;
    private ToyRaffleView view;

    public ToyRaffleController(ToyRaffle model, ToyRaffleView view) {
        this.model = model;
        this.view = view;
    }

    public void startRaffle() {
        Toy toy = model.drawToy();
        if (toy != null) {
            model.saveToFile(toy);
            view.displayPrize(toy);
        } else {
            System.out.println("Призовые игрушки закончились.");
        }
    }
}
