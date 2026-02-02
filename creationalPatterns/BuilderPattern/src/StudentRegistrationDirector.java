public class StudentRegistrationDirector {
    StudentBuilder studentBuilder;
    public StudentRegistrationDirector(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if(studentBuilder instanceof  EngineeringStudentBuilder){
            return createEngineeringStudent();
        }
        else if(studentBuilder instanceof MBAStudentBuilder){
            return createMBAStudent();
        }
        return null;
    }
    private Student createEngineeringStudent(){
        return studentBuilder.setRollNo(1).setAge(26).setName("Shivam").setFatherName("Rakesh").setMotherName("Neelam")
                .setBranch("CSE").setSubjects().build();

    }
    private Student createMBAStudent(){
        return studentBuilder.setRollNo(1).setAge(26).setName("Shivam").setFatherName("Rakesh").setMotherName("Neelam")
                .setBranch("Business Administration").setSubjects().build();
    }
}
