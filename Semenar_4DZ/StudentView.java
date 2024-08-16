import java.util.List;

public class StudentView implements UserView<Student> {

    @Override
    public void sendOnConsole(List<Student> list) {
        // TODO Auto-generated method stub
        for (Student i : list) {
            System.out.println(i);
        }

    }

}
