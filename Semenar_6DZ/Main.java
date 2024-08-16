import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Работа с учителями
        TeacherController teacherController = new TeacherController();
        teacherController.create("John", "Smith", "Doe");
        teacherController.create("Jane", "Doe", "Smith");
        teacherController.sendOnConsole();

        System.out.println("\nUpdating teacher with ID 1:");
        teacherController.update(1, "John", "Updated", "Doe");
        teacherController.sendOnConsole();

        System.out.println("\nUpdating teacher with ID 1:");

        StudentController controler = new StudentController();
        controler.create("aab", "aab", "aab");
        controler.create("aaa", "aaa", "aaa");
        controler.create("Aaa", "Aaa", "Aaa");
        controler.create("bbb", "bbb", "bbb");
        controler.sendOnConsole();

        // Создание студентов
        Student student1 = new Student(2, "aab", "aab", "aab");
        Student student2 = new Student(1, "aaa", "aaa", "aaa");
        Student student3 = new Student(3, "Aaa", "Aaa", "Aaa");
        Student student4 = new Student(4, "bbb", "bbb", "bbb");

        // Создание списка студентов и добавление студентов в группу
        List<Student> studentList1 = new ArrayList<>();
        StudentGroup studentGroup1 = new StudentGroup(studentList1);
        studentGroup1.addStudent(student1);
        studentGroup1.addStudent(student2);
        studentGroup1.addStudent(student3);
        studentGroup1.addStudent(student4);

        // Создание второй группы студентов
        List<Student> studentList2 = new ArrayList<>();
        StudentGroup studentGroup2 = new StudentGroup(studentList2);
        studentGroup2.addStudent(new Student(5, "ccc", "ccc", "ccc"));
        studentGroup2.addStudent(new Student(6, "ddd", "ddd", "ddd"));

        // Создание потока из групп студентов
        List<StudentGroup> groups = new ArrayList<>();
        groups.add(studentGroup1);
        groups.add(studentGroup2);
        Stream stream = new Stream(groups);

        // Выводит группу студентов, как есть
        StudentGroupService service = new StudentGroupService(studentGroup1);
        System.out.println("\nВыводит группу студентов как есть");
        for (Student student : studentGroup1) {
            System.out.println(student);
        }

        // Сортировка студентов в первой группе по ID
        System.out.println("\nSorted ByID:");
        for (Student student : service.getSortedStudentById()) {
            System.out.println(student);
        }

        // Сортировка студентов в первой группе по ФИО
        System.out.println("\nSorted ByFIO:");
        for (Student student : service.getSortedStudentGroupByFIO()) {
            System.out.println(student);
        }

        // Сортировка потоков по количеству групп
        List<Stream> streams = new ArrayList<>();
        streams.add(stream);
        StreamService streamService = new StreamService();
        streamService.sortStreams(streams);

        System.out.println("\nStreams sorted by number of groups:");
        for (Stream s : streams) {
            System.out.println("Stream with " + s.getGroupList().size() + " groups.");
        }

        // for (Student student : service.getSortedStudentGroup()) {
        // // System.out.println(student);
        // // }

        // // StudentGroupIteratot iterator = new StudentGroupIteratot(studentGroup);
        // // while (iteratot.hasNext()) {
        // // System.out.println(iteratot.next());

        // // for (Student student : studentGroup) {
        // // System.out.println(student);
    }
}
