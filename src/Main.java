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

    // Redéfinition de toString()
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", family='" + family + '\'' +
                ", isMammal=" + isMammal +
                '}';
    }
}

class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private int nbrCages;
    private int animalCount = 0;


    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[25];
    }


    public void addAnimal(Animal a) {
        if (animalCount < animals.length) {
            animals[animalCount] = a;
            animalCount++;
            System.out.println("Animal ajouté avec succès !");
        } else {
            System.out.println("Zoo plein, impossible d'ajouter plus d'animaux !");
        }
    }

    public void displayZoo() {
        System.out.println("Zoo name: " + this.name);
        System.out.println("City: " + this.city);
        System.out.println("Number of cages: " + this.nbrCages);
        System.out.println("Animaux dans le zoo:");
        for (int i = 0; i < animalCount; i++) {
            System.out.println("  - " + animals[i]);
        }
    }


    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", nbrCages=" + nbrCages +
                ", animaux=" + animalCount +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Entrez le nom du zoo: ");
        String zooName = sc.nextLine();

        System.out.print("Entrez la ville du zoo: ");
        String city = sc.nextLine();

        System.out.print("Entrez le nombre de cages: ");
        int cages = sc.nextInt();
        sc.nextLine();

        Zoo myZoo = new Zoo(zooName, city, cages);

        System.out.print("Combien d'animaux voulez-vous ajouter ? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\n=== Animal " + (i + 1) + " ===");
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
            myZoo.addAnimal(a);
        }


        System.out.println("\n=== Informations sur le Zoo ===");
        myZoo.displayZoo();

        System.out.println("\n=== Affichage avec toString() ===");
        System.out.println(myZoo);

        sc.close();
    }
}
