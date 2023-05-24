package model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Kotik {

    private static Integer kotikCount = 0;

    private int satiety;

    private String name;

    private Integer weight;

    private Integer prettiness;

    private String meow;

    public Kotik() {
        kotikCount++;
    }

    public Kotik(int satiety, String name, int weight) {
        this.satiety = satiety;
        this.name = name;
        this.weight = weight;
        kotikCount++;
        System.out.print("Создан котик с именем " + name);
        System.out.println(",текущее число котиков " + kotikCount);
    }

    public static int getkotikCount() {
        return kotikCount;
    }

    public static Integer getKotikCount() {
        return kotikCount;
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;

    }

    public boolean sleep() {
        if (satiety >= 0) {
            System.out.println("sleep");
            satiety--;
            return true;
        }
        return false;
    }

    public boolean play() {
        if (satiety >= 0) {
            System.out.println("play");
            satiety--;
            return true;
        }
        return false;

    }

    public boolean chaseMouse() {
        if (satiety >= 0) {
            System.out.println("chaseMouse");
            satiety--;
            return true;
        }
        return false;

    }

    public boolean jump() {
        if (satiety >= 0) {
            System.out.println("jump");
            satiety--;
            return true;
        }
        return false;

    }

    public void eat(int a) {
        eat(a, "Wiskas");
    }

    public void eat(int a, String foodName) {
        System.out.print("Вызван метод eat");
        System.out.println(" - получено " + a + " единиц еды : " + foodName);
        satiety += a;
    }

    public void eat() {
        eat(1, "Purina");
    }

    public void liveAnotherDay() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method[] methods = {Kotik.class.getMethod("sleep"), Kotik.class.getMethod("play"), Kotik.class.getMethod("chaseMouse"), Kotik.class.getMethod("jump"),};
        for (int i = 0; i < 24; i++) {
            int x = i+1;
            System.out.print(x+" ");
            int m = new Random().nextInt(methods.length);
            Boolean needToEat = (Boolean) methods[m].invoke(this);
            if (!needToEat) {
                this.eat((int) (Math.random() * 4 + 1));
            }
        }
    }

    public int getSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getPrettiness() {
        return prettiness;
    }

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }
}
