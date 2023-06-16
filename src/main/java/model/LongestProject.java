package model;

public class LongestProject {
    private final String name;
    private final int monthCount;

    public LongestProject(String name, int projectCount) {
        this.name = name;
        this.monthCount = projectCount;
    }

    @Override
    public String toString() {
        return "LongestProject {" +
                "name='" + name + '\'' +
                ", monthCount=" + monthCount +
                '}';
    }
}