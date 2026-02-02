import java.util.List;

public class Student {
    //Mandatory Fields

    int rollNo;
    int age;
    String name;
    String branch;

    //optional fields
    String fatherName;
    String motherName;
    List<String> subjects;
    String mobileNo;
    String emailId;

    public Student(StudentBuilder studentBuilder) {
        this.rollNo = studentBuilder.rollNo;
        this.age = studentBuilder.age;
        this.name = studentBuilder.name;
        this.branch = studentBuilder.branch;
        this.fatherName = studentBuilder.fatherName;
        this.motherName = studentBuilder.motherName;
        this.subjects = studentBuilder.subjects;
        this.mobileNo = studentBuilder.mobileNo;
        this.emailId = studentBuilder.emailId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", subjects=" + subjects +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
