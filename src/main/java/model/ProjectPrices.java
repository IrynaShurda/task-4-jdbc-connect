package model;

public class ProjectPrices {
    private final String name;
    private final int prise;

    public ProjectPrices(String name, int prise) {
        this.name = name;
        this.prise = prise;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "name='" + name + '\'' +
                ", prise=" + prise +
                '}';
    }
}
