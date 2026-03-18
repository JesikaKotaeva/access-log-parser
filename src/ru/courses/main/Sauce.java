package ru.courses.main;


public class Sauce {
    private String name;
    private Hotness hotness;

    public Sauce(String name, Hotness hotness) {
        this.name=name;
        this.hotness=hotness;
    }
    @Override
    public String toString() {
        return "Соус "+name+": "+hotness;
    }
    public static void main(String[] args) {
        Sauce sauce1 = new Sauce("Том ям", Hotness.VERY_HOT);
        Sauce sauce2 = new Sauce("Кетчуп", Hotness.NOT_HOT);
        Sauce sauce3 = new Sauce("Шрирача", Hotness.HOT);

        System.out.println(sauce1);
        System.out.println(sauce2);
        System.out.println(sauce3);
    }
}
enum Hotness {
    VERY_HOT("очень острый"),
    HOT("острый"),
    NOT_HOT("не острый");

    private final String description;

    Hotness(String description) {
        this.description = description;
    }
@Override
    public String toString() {
        return description;
    }
}