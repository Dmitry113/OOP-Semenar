import java.util.ArrayList;
import java.util.List;

public class StudentService implements UserService<Student> {
    private final List<Student> studentList = new ArrayList<>();

    @Override
    public void create(String firstName, String secondName, String lastName) {
        // TODO Auto-generated method stub
        int maxId = 0;
        for (Student student : studentList)
            if (maxId < student.getStudentId())
                maxId = student.getStudentId();
        studentList.add(new Student(++maxId, firstName, secondName, lastName));
    }

    public List<Student> getStudentList() {
        return studentList;
    }

}
