package models;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int NBR_CAGES = 25;
    private int animalCount = 0;

    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
        this.animals = new Animal[NBR_CAGES];
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Nom du zoo vide !");
        this.name = name;
    }

    public Animal[] getAnimals() { return animals; }

    public boolean addAnimal(Animal a) {
        if (isZooFull()) {
            System.out.println("Zoo plein !");
            return false;
        }
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(a)) {
                System.out.println("Animal déjà présent !");
                return false;
            }
        }
        animals[animalCount++] = a;
        return true;
    }

    public boolean removeAnimal(Animal a) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(a)) {
                for (int j = i; j < animalCount - 1; j++) {
                    animals[j] = animals[j + 1];
                }
                animals[--animalCount] = null;
                return true;
            }
        }
        return false;
    }

    public boolean isZooFull() { return animalCount >= NBR_CAGES; }

    public void displayAnimals() {
        if (animalCount == 0) {
            System.out.println("Zoo vide.");
            return;
        }
        for (Animal a : animals) {
            if (a != null) System.out.println(a);
        }
    }
}
