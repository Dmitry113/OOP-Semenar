package model;

// public class Student extends User {

//     private int studentId;

//     public Student(String firstName, String secondName, String lastName, int studentId) {
//         super(firstName, secondName, lastName);
//         this.studentId = studentId;
//     }

//     public int getStudentId() {
//         return studentId;
//     }

//     public void setStudentId(int studentId) {
//         this.studentId = studentId;
//     }

//     @Override
//     public String toString() {
//         return "Student{" +
//                 " studentId='" + getStudentId() + "'" +
//                 ", firstName='" + super.getFirstName() +
//                 ", secondName='" + super.getSecondName() +
//                 ", lastName='" + super.getLastName() +
//                 "}";
//     }

// }

public class Student {
    private String name;
    private int studentId;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}
