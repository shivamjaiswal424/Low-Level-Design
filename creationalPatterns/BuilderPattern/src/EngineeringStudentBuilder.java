import java.util.ArrayList;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder {

    @Override
    public StudentBuilder setSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Operating System");
        subjects.add("COA");
        subjects.add("Data Structures");

        this.subjects = subjects;
        return this;
    }
}
