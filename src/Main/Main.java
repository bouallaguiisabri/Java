package main;

import models.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Zoo myZoo = new Zoo("Belvédère", "Tunis");
        int choice;

        do {
            System.out.println("\n===== MENU ZOO =====");
            System.out.println("1. Ajouter un animal");
            System.out.println("2. Afficher les animaux");
            System.out.println("3. Supprimer un animal");
            System.out.println("4. Faire nager un animal aquatique");
            System.out.println("5. Vérifier si le zoo est plein");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Type d'animal : 1-Aquatic, 2-Terrestrial, 3-Dolphin, 4-Penguin");
                    int type = sc.nextInt();
                    sc.nextLine();

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

                    Animal a = null;

                    switch (type) {
                        case 1 -> {
                            System.out.print("Habitat : ");
                            String habitat = sc.nextLine();
                            a = new Aquatic(name, age, family, isMammal, habitat);
                        }
                        case 2 -> {
                            System.out.print("Nombre de pattes : ");
                            int nbrLegs = sc.nextInt();
                            sc.nextLine();
                            a = new Terrestrial(name, age, family, isMammal, nbrLegs);
                        }
                        case 3 -> {
                            System.out.print("Habitat : ");
                            String habitat = sc.nextLine();
                            System.out.print("Vitesse de nage : ");
                            float speed = sc.nextFloat();
                            sc.nextLine();
                            a = new Dolphin(name, age, family, isMammal, habitat, speed);
                        }
                        case 4 -> {
                            System.out.print("Habitat : ");
                            String habitat = sc.nextLine();
                            System.out.print("Profondeur de nage : ");
                            float depth = sc.nextFloat();
                            sc.nextLine();
                            a = new Penguin(name, age, family, isMammal, habitat, depth);
                        }
                        default -> System.out.println("Type invalide !");
                    }

                    if (a != null) {
                        System.out.println(myZoo.addAnimal(a) ? "Animal ajouté." : "Échec d'ajout.");
                    }
                }

                case 2 -> myZoo.displayAnimals();

                case 3 -> {
                    System.out.print("Nom de l’animal à supprimer : ");
                    String delName = sc.nextLine();
                    boolean removed = false;
                    for (Animal a : myZoo.getAnimals()) {
                        if (a != null && a.getName().equals(delName)) {
                            removed = myZoo.removeAnimal(a);
                            break;
                        }
                    }
                    System.out.println(removed ? "Animal supprimé." : "Animal introuvable.");
                }

                case 4 -> {
                    System.out.print("Nom de l'animal aquatique : ");
                    String aquaticName = sc.nextLine();
                    boolean found = false;
                    for (Animal a : myZoo.getAnimals()) {
                        if (a != null && a.getName().equals(aquaticName) && a instanceof Aquatic) {
                            ((Aquatic) a).swim();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Aucun animal aquatique trouvé avec ce nom.");
                }

                case 5 -> System.out.println(myZoo.isZooFull() ? "Le zoo est plein." : "Le zoo n’est pas plein.");

                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }
        } while (choice != 0);

        sc.close();
    }
}
