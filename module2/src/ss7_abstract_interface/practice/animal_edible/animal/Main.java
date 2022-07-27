package ss7_abstract_interface.practice.animal_edible.animal;

import ss7_abstract_interface.practice.animal_edible.edible.Apple;
import ss7_abstract_interface.practice.animal_edible.edible.Edible;
import ss7_abstract_interface.practice.animal_edible.edible.Fruit;
import ss7_abstract_interface.practice.animal_edible.edible.Orange;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
