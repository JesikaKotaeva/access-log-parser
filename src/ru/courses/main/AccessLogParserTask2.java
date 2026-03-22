package ru.courses.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccessLogParserTask2 {
    public static void main(String[] args) {
        String path = "C:\\Users\\DKotaeva\\Desktop\\access.log";
        int totalLines = 0;
        int yandexBotCount = 0;
        int googleBotCount = 0;

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.length() > 1024) {
                    throw new RuntimeException("Строка длиннее 1024 символов!");
                }
                totalLines++;
                String userAgent = extractUserAgent(line);

                if (userAgent != null) {
                    if (userAgent.equals("YandexBot")) {
                        yandexBotCount++;
                    } else if (userAgent.equals("Googlebot")) {
                        googleBotCount++;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return;
        }

        System.out.println("Всего запросов: " + totalLines);
        System.out.println("Запросов от YandexBot: " + yandexBotCount);
        System.out.println("Запросов от Googlebot: " + googleBotCount);

        if (totalLines > 0) {
            double yandexPercent = (double) yandexBotCount / totalLines * 100;
            double googlePercent = (double) googleBotCount / totalLines * 100;

            System.out.println("Доля YandexBot: " + String.format("%.2f", yandexPercent) + "%");
            System.out.println("Доля Googlebot: " + String.format("%.2f", googlePercent) + "%");
        }
    }

    private static String extractUserAgent(String line) {
        int startBracket = line.indexOf("(");
        int endBracket = line.indexOf(")");

        if (startBracket == -1 || endBracket == -1 || startBracket >= endBracket) {
            return null;
        }
        String firstBrackets = line.substring(startBracket + 1, endBracket);
        String[] parts = firstBrackets.split(";");
        if (parts.length >= 2) {
            String fragment = parts[1].trim();
            int slashIndex = fragment.indexOf("/");
            if (slashIndex != -1) {
                fragment = fragment.substring(0, slashIndex).trim();
            }
            return fragment;
        }
        return null;
    }
}