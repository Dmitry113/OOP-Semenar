public class Student extends User implements Comparable<Student> {

    private int studentId;
    // private String firstName;
    // private String secondName;
    // private String lastName;

    public Student(int studentId, String firstName, String secondName, String lastName) {
        super(firstName, secondName, lastName);
        this.studentId = studentId;
        // this.firstName = firstName;
        // this.secondName = secondName;
        // this.lastName = lastName;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // public String getFirstName() {
    // return this.firstName;
    // }

    // public void setFirstName(String firstName) {
    // this.firstName = firstName;
    // }

    // public String getSecondName() {
    // return this.secondName;
    // }

    // public void setSecondName(String secondName) {
    // this.secondName = secondName;
    // }

    // public String getLastName() {
    // return this.lastName;
    // }

    // public void setLastName(String lastName) {
    // this.lastName = lastName;
    // }

    @Override
    public String toString() {
        return "Student{" +
                " studentId=" + studentId +
                ", firstName='" + super.getFirstName() + '\'' +
                ", secondName='" + super.getSecondName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                "}";
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        if (studentId > o.getStudentId())
            return 1;
        if (studentId < o.getStudentId())
            return -1;
        return 0;
    }

}
