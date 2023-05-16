import model.Kotik;

import java.lang.reflect.InvocationTargetException;

public class Application {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Kotik barsik = new Kotik(0, "Barsik", 3);
        barsik.liveAnotherDay();
        System.out.println("barsik name : "+ barsik.getName() );
        System.out.println("barsik weight : "+ barsik.getWeight());
        barsik.setMeow("Мяу Мяу");

        Kotik kitty = new Kotik(0, "Ruby", 2);
        kitty.setMeow("Мяу");
        System.out.println("kitty name : "+ kitty.getName());
        System.out.println("kitty weight : "+ kitty.getWeight());
        System.out.println("Равенство meow котов "+barsik.getMeow().equals(kitty.getMeow()));


        System.out.println("Количество созданных котиков: "+ Kotik.getkotikCount());



    }
}