import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationProcessor {
    void validateInput(Student student){

        try{
            Field nameField = Student.class.getDeclaredField("studentName");
            for(Annotation annotation : nameField.getAnnotations()){
                if(annotation.annotationType() == NotBlank.class){
                    //check for null or containing only whitespace
                    if(student.studentName == null){
                        throw new BlankException();
                    }
                    Pattern pattern = Pattern.compile("\\s*");
                    Matcher matcher = pattern.matcher(student.studentName);
                    if(matcher.matches()){
                        throw new BlankException();
                    }
                }
                else{
                    //check for numeric fields (int, double, etc.) and ensure that the field's value is greater than zero.
                    if(student.marks <= 0){
                        throw new PositiveException();
                    }
                }
            }
            Field marksField = Student.class.getDeclaredField("marks");
            for(Annotation annotation : marksField.getAnnotations()){
               if(annotation.annotationType() == Positive.class){
                    //check for numeric fields (int, double, etc.) and ensure that the field's value is greater than zero.
                    if(student.marks <= 0){
                        throw new PositiveException();
                    }
                }
            }
        }catch(NoSuchFieldException | BlankException | PositiveException err){
            err.printStackTrace();
        }

    }
}
