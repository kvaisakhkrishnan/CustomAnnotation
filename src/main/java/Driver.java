public class Driver {
    public static void main(String[] args) {
        ValidationProcessor validator = new ValidationProcessor();
        Student student = new Student("", 100);
        validator.validateInput(student);
        Student student2 = new Student("Student", -1);
        validator.validateInput(student2);
        Student student3 = new Student("Vaisakh", 100);
        validator.validateInput(student3);
    }
}
