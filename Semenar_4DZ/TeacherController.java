public class TeacherController implements UserController<Teacher> {
    private final TeacherService teacherService = new TeacherService();
    private final TeacherView teacherView = new TeacherView();

    @Override
    public void create(String firstName, String secondName, String lastName) {
        teacherService.create(firstName, secondName, lastName);
    }

    @Override
    public void sendOnConsole() {
        teacherView.sendOnConsole(teacherService.getTeacherList());
    }

    public void update(int teacherId, String firstName, String secondName, String lastName) {
        teacherService.update(teacherId, firstName, secondName, lastName);
    }
}
