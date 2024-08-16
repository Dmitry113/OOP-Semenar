package View;

import model.Student;
import model.StudyGroup;

public class ConsoleView {
    public void displayStudyGroup(StudyGroup studyGroup) {
        System.out.println("Study Group:");
        System.out.println("Teacher: " + studyGroup.getTeacher());
        System.out.println("Students: ");
        for (Student student : studyGroup.getStudents()) {
            System.out.println(student);
        }
    }
}
