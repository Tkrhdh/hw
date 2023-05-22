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
    }

    public Kotik(int satiety, String name, Integer weight) {
        this.satiety = satiety;
        this.name = name;
        this.weight = weight;
        kotikCount++;
        System.out.println("Создан котик с именем "+name);
        System.out.println("Текущее число котиков " + kotikCount);
    }

    public static int getkotikCount() {
        return kotikCount;
    }

    public void setKotik(int prettiness, String name, int weight, String meow){
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;

    }

    public void setMeow (String meow) {
        this.meow = meow;
    }



    public boolean sleep() {
        if (enoughFood()) {
            System.out.println("sleep");
            satiety--;
        }
        return false;


    }

    public boolean play() {
        if (enoughFood()) {
            System.out.println("play");
            satiety--;
        }
        return false;

    }

    public boolean chaseMouse() {
        if (enoughFood()) {
            System.out.println("chaseMouse");
            satiety--;
        }
        return false;

    }

    public boolean jump() {
        if (enoughFood()) {
            System.out.println("jump");
            satiety--;
        }
        return false;

    }

    public void eat(int a) {
        satiety += a;
    }

    public void eat(int a, String foodName) {
        satiety += a;
    }

    public void eat() {
        System.out.println("Вызван метод eat");
        eat(1, "Purina");
    }

    public void liveAnotherDay() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method[] methods = {
                Kotik.class.getMethod("sleep"),
                Kotik.class.getMethod("play"),
                Kotik.class.getMethod("chaseMouse"),
                Kotik.class.getMethod("jump"),
        };
        for (int i = 0; i < 24; i++) {
            int m = new Random().nextInt(methods.length);
            Boolean needToEat = (Boolean) methods[m].invoke(this);
            if (needToEat){
                this.eat();
            }
        }

    }

    private boolean enoughFood() {
        if (satiety <= 0) {
            this.eat();
            return false;
        }
        return true;
    }


    public static Integer getKotikCount() {
        return kotikCount;
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
}
