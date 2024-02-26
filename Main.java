import controller.ToyRaffleController;
import model.toy.Toy;
import model.toyRaffle.ToyRaffle;
import view.ToyRaffleView;

public class Main {
    public static void main(String[] args) {
        ToyRaffle model = new ToyRaffle();
        ToyRaffleView view = new ToyRaffleView();
        ToyRaffleController controller = new ToyRaffleController(model, view);

        model.addToy(new Toy(1, "Конструктор", 5, 30));
        model.addToy(new Toy(2, "Робот", 3, 20));
        model.addToy(new Toy(3, "Кукла", 2, 50));

        System.out.println("Количество игрушек до розыгрыша:");
        for (Toy toy : model.getToys()) {
            System.out.println(toy.getName() + ": " + toy.getQuantity());
        }

        // Разыграем игрушки 5 раз
        for (int i = 0; i < 5; i++) {
            System.out.println("Розыгрыш №" + (i + 1) + ":");
            controller.startRaffle();
            System.out.println();
        }

        System.out.println("Количество игрушек после розыгрыша:");
        for (Toy toy : model.getToys()) {
            System.out.println(toy.getName() + ": " + toy.getQuantity());
        }
    }
}
