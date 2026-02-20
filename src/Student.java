import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> grades;

    public Student(String name, int... grades) {
        this.name = name;
        this.grades = new ArrayList<>();

        for (int grade : grades) {
            if (grade>=2 && grade<=5) {
                this.grades.add(grade);
            }
        }
    }
    public String getName() {
        return name;
    }
    public ArrayList<Integer> getGrades() {
        return grades;
    }
    public String toString() {
        return name + ": " + grades;
    }
    public void addGrade(int grade) {
        if (grade>=2 && grade<=5) {
            grades.add(grade);
        }
    }
    public static void main(String[] args) {
        Student student1 = new Student("Алексей", 4, 5, 3);
        System.out.println(student1);
        Student student2 = new Student("Ира", 4, 9, 3);
        System.out.println(student2);
        Student student = new Student("Иван", 4, 5);
        student.addGrade(3);
        System.out.println(student);
    }
}