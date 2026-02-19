public class Student implements StudentPrototype {
    int id;
    String name;
    String branch;
    boolean inHighSchool;
    private int rollNo;

    Student(){

    }
    Student(int id,String name,String branch,int rollNo){
        this.id=id;
        this.name=name;
        this.branch=branch;
        this.rollNo=rollNo;
    }
    public void setInHighSchool(boolean inHighSchool){
        this.inHighSchool=inHighSchool;
    }
    @Override
    public StudentPrototype clone() {
        return new Student(id, name, branch, rollNo);
    }

    public void printDetails(){
        System.out.println("=== Student Details ===");
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Branch: " + branch);
        System.out.println("Student Roll No: " + rollNo);
        System.out.println("Student In High School: " + inHighSchool);
    }
}
