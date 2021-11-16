package me.liheng.builderAndStaticInnerClass;

public class Car {
    private String name;
    private int number;
    private String brand;
    private int age;

    private Car(String name, int number, String brand, int age) {  //Note: private constructor
        this.name = name;
        this.number = number;
        this.brand = brand;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", brand='" + brand + '\'' +
                ", age=" + age +
                '}';
    }

    public static class CarBuilder {  //Note: static inner class
        private String name;
        private int number;
        private String brand;
        private int age;

        public CarBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CarBuilder setNumber(int number) {
            this.number = number;
            return this;
        }

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Car build() {
            return new Car(name, number, brand, age);
        }
    }
}
