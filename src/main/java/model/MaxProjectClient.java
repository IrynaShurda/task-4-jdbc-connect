package model;

public class MaxProjectClient {
    private final String name;
    private final int projectCount;

    public MaxProjectClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient {" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}