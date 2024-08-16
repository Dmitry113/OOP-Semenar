package model;

// public class Teacher extends User {

//     private int teacherId;

//     public Teacher(String firstName, String secondName, String lastName, int teacherId) {
//         super(firstName, secondName, lastName);
//         this.teacherId = teacherId;
//     }

//     public int getTeacherId() {
//         return this.teacherId;
//     }

//     public void setTeacherId(int teacherId) {
//         this.teacherId = teacherId;
//     }

//     @Override
//     public String toString() {
//         return "Teacher{" +
//                 " teacherId='" + getTeacherId() + "'" +
//                 ", firstName='" + super.getFirstName() +
//                 ", secondName='" + super.getSecondName() +
//                 ", lastName='" + super.getLastName() +
//                 "}";
//     }
// }

public class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
