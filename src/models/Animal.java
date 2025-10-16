package models;

public class Animal {
    private String name;
    private int age;
    private String family;
    private boolean isMammal;

    public Animal(String name, int age, String family, boolean isMammal) {
        setName(name);
        setAge(age);
        this.family = family;
        this.isMammal = isMammal;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Le nom de l'animal ne peut pas être vide !");
        }
        this.name = name;
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("L'âge de l'animal ne peut pas être négatif !");
        }
        this.age = age;
    }

    public String getFamily() { return family; }
    public void setFamily(String family) { this.family = family; }

    public boolean isMammal() { return isMammal; }
    public void setMammal(boolean mammal) { isMammal = mammal; }

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
