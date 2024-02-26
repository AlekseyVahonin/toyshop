package view;

import model.toy.Toy;

public class ToyRaffleView {
    public void displayPrize(Toy toy) {
        System.out.println("Выиграна игрушка: " + toy.getName());
    }
}

