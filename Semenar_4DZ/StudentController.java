public class StudentController implements UserController<Student> {
    private final StudentService studentService = new StudentService();
    private final StudentView studentView = new StudentView();

    @Override
    public void create(String firstName, String secondName, String lastName) {
        // TODO Auto-generated method stub
        studentService.create(firstName, secondName, lastName);

    }

    @Override
    public void sendOnConsole() {
        // TODO Auto-generated method stub
        studentView.sendOnConsole(studentService.getStudentList());

    }

}
