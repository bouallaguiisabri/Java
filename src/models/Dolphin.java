package models;

public class Dolphin extends Aquatic {
    protected float swimmingSpeed;

    public Dolphin() {
        super();
        this.swimmingSpeed = 0;
    }

    public Dolphin(String name, int age, String family, boolean isMammal, String habitat, float swimmingSpeed) {
        super(name, age, family, isMammal, habitat);
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public void swim() {
        System.out.println("This dolphin is swimming.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Dolphin{" +
                "swimmingSpeed=" + swimmingSpeed +
                '}';
    }
}
