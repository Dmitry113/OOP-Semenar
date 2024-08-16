// import controller.Controller;

// public class Main {

//     public static void main(String[] args) {
//         Controller controller = new Controller();
//         controller.createStudent("qwe", "qwe", "qwe");
//         controller.createStudent("qwe1", "qwe1", "qwe1");
//         controller.createStudent("qwe2", "qwe2", "qwe2");
//         controller.getAllStudent();
//     }
// }

import java.util.Arrays;
import java.util.List;

import View.ConsoleView;
import controller.StudyGroupController;
import model.Student;
import model.Teacher;
import service.StudyGroupService;

public class MainGrup {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Татьяна Димьяновна", "Mathematics");
        Student student1 = new Student("Василий", 1);
        Student student2 = new Student("Владимир", 2);
        List<Student> students = Arrays.asList(student1, student2);

        StudyGroupService studyGroupService = new StudyGroupService();
        ConsoleView view = new ConsoleView();
        StudyGroupController controller = new StudyGroupController(studyGroupService, view);

        controller.formAndDisplayStudyGroup(teacher, students);
    }
}
