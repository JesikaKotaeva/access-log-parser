package ru.courses.main;

import ru.courses.geometry.*;
import ru.courses.math.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        //testGeometry();
        //testFractions();
        //testFractionTask6();
        //testPoint();
        //testLine();
        //testPolyLine();
        testAccessLogParser();
    }
    public static void testAccessLogParser() {
        String path = "C:\\Users\\DKotaeva\\Desktop\\access.log";
        Statistics stats = new Statistics();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            int lineNumber = 0;
            int skippedLines = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.length() > 1024) {
                    throw new RuntimeException("Строка " + lineNumber + " длиннее 1024 символов!");
                }

                try {
                    LogEntry entry = new LogEntry(line);
                    stats.addEntry(entry);
                } catch (IllegalArgumentException e) {
                    // Из-за одной строки в логе выдавало ошибку поэтому решила пропустить эту строку
                    System.out.println("Пропуск строки " + lineNumber + " из-за некорректного формата");
                    skippedLines++;
                }
            }

            System.out.println("Всего обработано строк: " + (lineNumber - skippedLines));
            System.out.println("Пропущено строк: " + skippedLines);

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return;
        }

        System.out.println("Всего записей: " + stats.getEntryCount());
        System.out.println("Общий трафик: " + stats.getTotalTraffic() + " байт");
        System.out.println("Средний трафик в час: " + stats.getTrafficRate() + " байт/час");
    }
    public static void testGeometry() {
        //geometry
        System.out.println("---> Тест geometry:");
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(3, 4);

        PolyLine polyLine = new PolyLine(p1, p2, p3);
        ClosedPolyLine closedPolyLine = new ClosedPolyLine(p1, p2, p3);

        System.out.println("Длина PolyLine: " + polyLine.getLength());
        System.out.println("Длина ClosedPolyLine: " + closedPolyLine.getLength());
    }

    public static void testFractions() {
        System.out.println("\n ---> Тест дробей:");
        //(дроби)
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);
        System.out.println("f1 + f2 = " + f1.add(f2));
    }

    public static void testFractionTask6() {
        System.out.println("\n---> Тест FractionTask6:");
        double result1 = sumAll(2, new FractionTask6(3, 5), 2.3);
        System.out.println("2 + 3/5 + 2.3 = " + result1);

        double result2 = sumAll(3.6, new FractionTask6(49, 12), 3, new FractionTask6(3, 2));
        System.out.println("3.6 + 49/12 + 3 + 3/2 = " + result2);

        double result3 = sumAll(new FractionTask6(1, 3), 1);
        System.out.println("1/3 + 1 = " + result3);
    }
    public static double sumAll(Number... numbers) {
        double sum = 0;
        for (Number n : numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }
    public static void testPoint() {
        System.out.println("\n---> Тест Point (equals и clone):");

        Point p1 = new Point(5, 10);
        Point p2 = new Point(5, 10);
        Point p3 = new Point(3, 7);

        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.equals(p3): " + p1.equals(p3));

        Point p4 = p1.clone();
        System.out.println("p1: " + p1);
        System.out.println("p4 (копия p1): " + p4);
        System.out.println("p1.equals(p4): " + p1.equals(p4)); // true
    }
    public static void testLine() {
        System.out.println("\n---> Тест Line (equals и clone):");

        Point p1 = new Point(0, 0);
        Point p2 = new Point(5, 10);
        Point p3 = new Point(0, 0);
        Point p4 = new Point(5, 10);

        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p3, p4);
        Line line3 = new Line(new Point(0, 0), new Point(3, 7));

        System.out.println("line1.equals(line2): " + line1.equals(line2));
        System.out.println("line1.equals(line3): " + line1.equals(line3));

        Line lineClone = line1.clone();
        System.out.println("line1: " + line1);
        System.out.println("lineClone: " + lineClone);
        System.out.println("line1.equals(lineClone): " + line1.equals(lineClone));
        System.out.println("line1 == lineClone: " + (line1 == lineClone));
    }
    public static void testPolyLine() {
        System.out.println("\n---> Тест PolyLine (equals и clone):");
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(0, 0);
        Point p4 = new Point(3, 4);

        PolyLine line1 = new PolyLine(p1, p2);
        PolyLine line2 = new PolyLine(p3, p4);
        PolyLine line3 = new PolyLine(new Point(0, 0), new Point(5, 5));

        System.out.println("line1.equals(line2): " + line1.equals(line2));
        System.out.println("line1.equals(line3): " + line1.equals(line3));
    }
}