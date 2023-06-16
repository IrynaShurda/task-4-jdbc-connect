package model;

public class MaxSalaryWorker {
    private final String name;
    private final int salaryCount;

    public MaxSalaryWorker(String name, int projectCount) {
        this.name = name;
        this.salaryCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "name='" + name + '\'' +
                ", salaryCount=" + salaryCount +
                '}';
    }
}
