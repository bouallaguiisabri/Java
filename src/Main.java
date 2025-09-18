import java.util.Scanner;

class ZooManagement {
    int nbrCages;
    String zooName;
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ZooManagement z1 = new ZooManagement();


        String nom;
        do {
            System.out.print("Veuillez saisir le nom du zoo : ");
            nom = sc.nextLine().trim();
            if (nom.isEmpty()) {
                System.out.println("Le nom du zoo ne doit pas être vide.");
            }
        } while (nom.isEmpty());
        z1.zooName = nom;


        int cages;
        do {
            System.out.print("Veuillez saisir le nombre de cages : ");
            while (!sc.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                sc.next();
            }
            cages = sc.nextInt();
            if (cages <= 0) {
                System.out.println("Le nombre de cages doit être positif.");
            }
        } while (cages <= 0);
        z1.nbrCages = cages;


        System.out.println(z1.zooName + " comporte " + z1.nbrCages + " cages.");
    }
}