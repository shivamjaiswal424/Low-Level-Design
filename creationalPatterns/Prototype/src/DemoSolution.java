
public class DemoSolution {
    public static void main(String[] args) {
        Student student = new Student(1,"Shivam","CSE",224);
        student.printDetails();

        Student studentClone= (Student) student.clone();
        studentClone.setInHighSchool(true);
        studentClone.printDetails();
        System.out.println("Same object? " + (student == studentClone));

    }
}