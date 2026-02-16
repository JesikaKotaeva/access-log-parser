import java.io.File;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int validFileCount = 0;

        while (true) {
            System.out.print("Введите путь к файлу: ");
            String path = scanner.nextLine();

            File file = new File(path);
            boolean exists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (!exists) {
                System.out.println("Файл не существует.");
                continue;
            }

            if (isDirectory) {
                System.out.println("Указанный путь ведет к папке, а не к файлу.");
                continue;
            }

            validFileCount++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + validFileCount);
        }
    }
}