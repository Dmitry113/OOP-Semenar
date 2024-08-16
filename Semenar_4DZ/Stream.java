import java.util.Iterator;
import java.util.List;

// Класс Поток

public class Stream implements Iterator<StudentGroup> {
    private List<StudentGroup> groupList;
    private int counter;

    public Stream(List<StudentGroup> groupList) {
        this.groupList = groupList;
        this.counter = 0;
    }

    public List<StudentGroup> getGroupList() {
        return groupList;
    }

    @Override
    public boolean hasNext() {
        return counter < groupList.size();
    }

    @Override
    public StudentGroup next() {
        if (hasNext()) {
            return groupList.get(counter++);
        }
        return null;
    }
}
