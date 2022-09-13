package cn.tedu.boot011.Entity;

public class User {
    private double height;
    private double weight;

    @Override
    public String toString() {
        return "User{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
