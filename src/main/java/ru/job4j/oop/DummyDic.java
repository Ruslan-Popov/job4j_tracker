package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String word = "Неизвестное слово " + eng;
        return word;
    }

    public static void main(String[] args) {
        DummyDic translator = new DummyDic();
        String phrase = translator.engToRus("Hola");
        System.out.println(phrase);
    }
}
