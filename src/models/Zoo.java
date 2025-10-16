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
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Le nom du zoo ne peut pas être vide !");
        }
        this.name = name;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public boolean addAnimal(Animal a) {
        if (isZooFull()) {
            System.out.println("Zoo plein, impossible d'ajouter plus d'animaux !");
            return false;
        }
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(a)) {
                System.out.println("Cet animal existe déjà dans le zoo !");
                return false;
            }
        }
        animals[animalCount++] = a;
        return true;
    }

    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
    }

    public void displayAnimals() {
        if (animalCount == 0) {
            System.out.println("Aucun animal dans le zoo.");
            return;
        }
        for (Animal a : animals) {
            if (a != null) System.out.println(" - " + a);
        }
    }

    public int searchAnimal(Animal a) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(a)) return i;
        }
        return -1;
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

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return (z1.animalCount >= z2.animalCount) ? z1 : z2;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", nbrCages=" + NBR_CAGES +
                ", animaux=" + animalCount +
                '}';
    }
}
