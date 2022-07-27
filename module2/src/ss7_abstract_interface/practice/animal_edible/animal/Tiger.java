package ss7_abstract_interface.practice.animal_edible.animal;

import ss7_abstract_interface.practice.animal_edible.edible.Edible;

public class Tiger extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }

    @Override
    public String howToEat() {
        return null;
    }
}
