package model.toyRaffle;

import model.toy.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToyRaffle {
    private List<Toy> toys;

    public ToyRaffle() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public Toy drawToy() {
        double totalFrequency = toys.stream().mapToDouble(Toy::getFrequency).sum();
        double randomNumber = Math.random() * totalFrequency;

        double cumulativeFrequency = 0;
        Iterator<Toy> iterator = toys.iterator();
        while (iterator.hasNext()) {
            Toy toy = iterator.next();
            cumulativeFrequency += toy.getFrequency();
            if (randomNumber <= cumulativeFrequency) {
                toy.decreaseQuantity();
                if (toy.getQuantity() == 0) {
                    iterator.remove();
                }
                return toy;
            }
        }
        return null;
    }

    public void saveToFile(Toy toy) {
        try {
            FileWriter writer = new FileWriter("src/prize.txt", true);
            writer.write("Выиграна игрушка: " + toy.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Toy> getToys() {
        return toys;
    }
}
