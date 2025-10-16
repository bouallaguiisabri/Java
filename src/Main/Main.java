package main;

import models.Animal;
import models.Zoo;

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
                    try {
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
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erreur : " + e.getMessage());
                    }
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
                        try {
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
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erreur : " + e.getMessage());
                        }
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
