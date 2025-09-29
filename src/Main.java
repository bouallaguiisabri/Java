import java.util.Scanner;

class Animal {
    private String name;
    private int age;
    private String family;
    private boolean isMammal;

    public Animal(String name, int age, String family, boolean isMammal) {
        this.name = name;
        this.age = age;
        this.family = family;
        this.isMammal = isMammal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", family='" + family + '\'' +
                ", isMammal=" + isMammal +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Animal)) return false;
        Animal other = (Animal) obj;
        return this.name.equals(other.name) &&
                this.age == other.age &&
                this.family.equals(other.family) &&
                this.isMammal == other.isMammal;
    }
}

class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int NBR_CAGES = 25;
    private int animalCount = 0;

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[NBR_CAGES];
    }

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
        animals[animalCount] = a;
        animalCount++;
        return true;
    }

    public void displayAnimals() {
        if (animalCount == 0) {
            System.out.println("Aucun animal dans le zoo.");
            return;
        }
        for (Animal a : animals) {
            if (a != null) {
                System.out.println(" - " + a);
            }
        }
    }

    public int searchAnimal(Animal a) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(a)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal a) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(a)) {
                for (int j = i; j < animalCount - 1; j++) {
                    animals[j] = animals[j + 1];
                }
                animals[animalCount - 1] = null;
                animalCount--;
                return true;
            }
        }
        return false;
    }

    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
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

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Zoo myZoo = new Zoo("Belvédère", "Tunis");

        int choice;
        do {
            System.out.println("\n===== MENU ZOO =====");
            System.out.println("1. Ajouter un animal");
            System.out.println("2. Afficher les animaux");
            System.out.println("3. Rechercher un animal");
            System.out.println("4. Supprimer un animal");
            System.out.println("5. Vérifier si le zoo est plein");
            System.out.println("6. Afficher les infos du zoo");
            System.out.println("7. Comparer avec un autre zoo");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Nom : ");
                    String name = sc.nextLine();
                    System.out.print("Âge : ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Famille : ");
                    String family = sc.nextLine();
                    System.out.print("Est-ce un mammifère ? (true/false) : ");
                    boolean isMammal = sc.nextBoolean();
                    sc.nextLine();
                    Animal a = new Animal(name, age, family, isMammal);
                    System.out.println(myZoo.addAnimal(a) ? "Animal ajouté." : "Échec d'ajout.");
                }
                case 2 -> myZoo.displayAnimals();
                case 3 -> {
                    System.out.print("Nom de l’animal à chercher : ");
                    String searchName = sc.nextLine();
                    Animal search = new Animal(searchName, 0, "", false);
                    int index = myZoo.searchAnimal(search);
                    System.out.println(index != -1 ? "Animal trouvé à l’indice " + index : "Animal introuvable.");
                }
                case 4 -> {
                    System.out.print("Nom de l’animal à supprimer : ");
                    String delName = sc.nextLine();
                    Animal del = new Animal(delName, 0, "", false);
                    System.out.println(myZoo.removeAnimal(del) ? "Animal supprimé." : "Animal introuvable.");
                }
                case 5 -> System.out.println(myZoo.isZooFull() ? "Le zoo est plein." : "Le zoo n’est pas plein.");
                case 6 -> System.out.println(myZoo);
                case 7 -> {
                    System.out.print("Nom du deuxième zoo : ");
                    String zooName = sc.nextLine();
                    System.out.print("Ville du deuxième zoo : ");
                    String city = sc.nextLine();
                    Zoo otherZoo = new Zoo(zooName, city);

                    System.out.print("Combien d'animaux ajouter dans le deuxième zoo ? ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nom : ");
                        String name = sc.nextLine();
                        System.out.print("Âge : ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Famille : ");
                        String family = sc.nextLine();
                        System.out.print("Est-ce un mammifère ? (true/false) : ");
                        boolean isMammal = sc.nextBoolean();
                        sc.nextLine();
                        otherZoo.addAnimal(new Animal(name, age, family, isMammal));
                    }

                    Zoo bigger = Zoo.comparerZoo(myZoo, otherZoo);
                    System.out.println("Le zoo le plus rempli est : " + bigger);
                }
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }
        } while (choice != 0);

        sc.close();
    }
}
