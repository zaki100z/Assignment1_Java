import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        School school = new School();
        try {

            File studentFile = new File("src/students.txt");
            Scanner studentScanner = new Scanner(studentFile);
            while (studentScanner.hasNextLine()) {

                String line = studentScanner.nextLine().trim();
                if (!line.isEmpty()) {

                    String[] studentData = line.split(" ");
                    if (studentData.length >= 4) {

                        String name = studentData[0];
                        String surname = studentData[1];
                        int age = Integer.parseInt(studentData[2]);
                        boolean gender = studentData[3].equalsIgnoreCase("Male");
                        Student student = new Student(name, surname, age, gender);
                        for (int i = 4; i < studentData.length; i++) {
                            student.addGrade(Integer.parseInt(studentData[i]));
                        }
                        school.addMember(student);
                    } else {
                        System.out.println("Skipping malformed line: " + line);
                    }
                }
            }
            studentScanner.close();


            File teacherFile = new File("src/teachers.txt");
            Scanner teacherScanner = new Scanner(teacherFile);
            while (teacherScanner.hasNextLine()) {
                String line = teacherScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] teacherData = line.split(" ");

                    if (teacherData.length == 7) {
                        String name = teacherData[0];
                        String surname = teacherData[1];
                        int age = Integer.parseInt(teacherData[2]);
                        boolean gender = teacherData[3].equalsIgnoreCase("Male");
                        String subject = teacherData[4];
                        int yearsOfExperience = Integer.parseInt(teacherData[5]);
                        int salary = Integer.parseInt(teacherData[6]);
                        Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                        if (yearsOfExperience > 10) {

                            teacher.giveRaise(10);
                        }
                        school.addMember(teacher);
                    } else {

                        System.out.println("Skipping malformed line: " + line);
                    }
                }
            }
            teacherScanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("Error: File not found - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(school);
    }
}
