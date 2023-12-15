public class Student {
    @NotBlank
    String studentName;

    @Positive
    int marks;

    Student(String studentName, int marks){
        this.studentName = studentName;
        this.marks = marks;
    }
}
