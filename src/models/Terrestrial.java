package models;

public class Terrestrial extends Animal {
    protected int nbrLegs;

    public Terrestrial() {
        super();
        this.nbrLegs = 0;
    }

    public Terrestrial(String name, int age, String family, boolean isMammal, int nbrLegs) {
        super(name, age, family, isMammal);
        this.nbrLegs = nbrLegs;
    }

    @Override
    public String toString() {
        return super.toString() + ", Terrestrial{" +
                "nbrLegs=" + nbrLegs +
                '}';
    }
}
