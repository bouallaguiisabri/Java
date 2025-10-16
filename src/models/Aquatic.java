package models;

public class Aquatic extends Animal {
    protected String habitat;

    public Aquatic() {
        super();
        this.habitat = "Inconnu";
    }

    public Aquatic(String name, int age, String family, boolean isMammal, String habitat) {
        super(name, age, family, isMammal);
        this.habitat = habitat;
    }

    public void swim() {
        System.out.println("This aquatic animal is swimming.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Aquatic{" +
                "habitat='" + habitat + '\'' +
                '}';
    }
}
