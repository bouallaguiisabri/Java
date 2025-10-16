package models;

public class Penguin extends Aquatic {
    protected float swimmingDepth;

    public Penguin() {
        super();
        this.swimmingDepth = 0;
    }

    public Penguin(String name, int age, String family, boolean isMammal, String habitat, float swimmingDepth) {
        super(name, age, family, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    @Override
    public void swim() {
        System.out.println("This penguin is swimming.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Penguin{" +
                "swimmingDepth=" + swimmingDepth +
                '}';
    }
}
