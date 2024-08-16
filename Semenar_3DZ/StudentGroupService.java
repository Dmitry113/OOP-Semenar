import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class StudentGroupService {
    private StudentGroup studentGroup;

    public StudentGroupService(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public List<Student> getSortedStudentById() {
        List<Student> studentList = new ArrayList<>(studentGroup.getStudentList());
        Collections.sort(studentList);
        return studentList;
    }

    public List<Student> getSortedStudentGroup() {
        // TODO Auto-generated method stub
        List<Student> studentList = new ArrayList<>(studentGroup.getStudentList());
        Collections.sort(studentList);
        return studentList;
    }

    public List<Student> getSortedStudentGroupByFIO() {
        // TODO Auto-generated method stub
        List<Student> studentList = new ArrayList<>(studentGroup.getStudentList());
        studentList.sort(new StudentComparator());
        return studentList;
    }

}
