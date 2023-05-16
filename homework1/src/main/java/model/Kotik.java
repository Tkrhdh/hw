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



    public void sleep() {
        if (enoughFood()) {
            System.out.println("sleep");
            satiety--;
        }


    }

    public void play() {
        if (enoughFood()) {
            System.out.println("play");
            satiety--;
        }

    }

    public void chaseMouse() {
        if (enoughFood()) {
            System.out.println("chaseMouse");
            satiety--;
        }

    }

    public void jump() {
        if (enoughFood()) {
            System.out.println("jump");
            satiety--;
        }

    }

    public void eat(int a) {
        satiety += a;
    }

    public void eat(int a, String foodName) {
        satiety += a;
    }

    public void eat() {
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
            methods[m].invoke(this);
        }

    }

    private boolean enoughFood() {
        if (satiety <= 0) {
            System.out.println("Покорми меня !!!");
            this.eat();
            System.out.println("Покормила - текущее число еды :" + satiety);
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
