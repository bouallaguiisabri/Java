package models;

public class Animal {
    protected String name;
    protected int age;
    protected String family;
    protected boolean isMammal;

    // Constructeur par défaut
    public Animal() {
        this.name = "Inconnu";
        this.age = 0;
        this.family = "Inconnue";
        this.isMammal = false;
    }

    // Constructeur paramétré
    public Animal(String name, int age, String family, boolean isMammal) {
        this.name = name;
        this.age = age;
        this.family = family;
        this.isMammal = isMammal;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getFamily() { return family; }
    public boolean isMammal() { return isMammal; }

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
