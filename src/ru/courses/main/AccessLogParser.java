package ru.courses.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LineTooLongException extends RuntimeException {
    public LineTooLongException(String message) {
        super(message);
    }
}
public class AccessLogParser {
    public static void main(String[] args) {
        String path = "C:\\Users\\DKotaeva\\IdeaProjects\\AccessLogParser\\access.log";
        int totalLines = 0;
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                int length = line.length();
                if (length > 1024) {
                    throw new LineTooLongException("Обнаружена строка длиннее 1024 символов! Длина: " + length);
                }
                totalLines++;
                if (length > maxLength) {
                    maxLength = length;
                }
                if (length < minLength) {
                    minLength = length;
                }
            }
            System.out.println("общее количество строк в файле: " + totalLines);
            System.out.println("длина самой длинной строки: " + maxLength);
            System.out.println("длина самой короткой строки: " + minLength);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            BufferedReader reader = null;
            FileReader fileReader = null;
            try {
                if (reader!=null) reader.close();
                if (fileReader!=null) fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
