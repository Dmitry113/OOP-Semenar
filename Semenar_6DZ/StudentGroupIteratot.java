import java.util.Iterator;
import java.util.List;

public class StudentGroupIteratot implements Iterator<Student> {
    private List<Student> studentList;
    private int counter;

    public StudentGroupIteratot(StudentGroup studentGroup) {
        this.studentList = studentGroup.getStudentList();
        counter = 0;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return counter < studentList.size();
    }

    @Override
    public Student next() {
        // TODO Auto-generated method stub
        if (hasNext()) {
            return studentList.get(counter++);
        }
        return null;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        if (hasNext()) {
            studentList.remove(counter);
        }

    }
}
