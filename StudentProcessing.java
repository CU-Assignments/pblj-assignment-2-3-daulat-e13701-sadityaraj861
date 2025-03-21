import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StudentProcessing {
    public static void main(String[] args) {
        // Create a list of students
        List<Student> students = Arrays.asList(
                new Student("Aditya", 80.5),
                new Student("Bobby", 72.0),
                new Student("Chetan", 85.0),
                new Student("sangam", 90.0),
                new Student("Elvish", 76.0)
        );

        // Process the list using streams
        students.stream()
                .filter(student -> student.getPercentage() > 75) // Filter students with percentage > 75
                .sorted(Comparator.comparingDouble(Student::getPercentage).reversed()) // Sort by marks descending
                .map(Student::getName) // Extract student names
                .forEach(System.out::println); // Display each name
    }
}

class Student {
    private String name;
    private double percentage;

    public Student(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }
}
