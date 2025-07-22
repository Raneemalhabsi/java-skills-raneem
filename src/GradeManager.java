import java.util.ArrayList;

public class GradeManager {
    // Method to reverse student names in an array
    public static String[] reverseStudentNames(String[] names) {
        String[] reversedNames = new String[names.length];
        for (int i=0; i<names.length; i++ ){
            String original = names[i];
            String reversed = "";
            for (int j = original.length() - 1; j >= 0; j--) {
                reversed += original.charAt(j);
            }
            reversedNames[i] = reversed;
        }
        return reversedNames;
    }

    // Method to calculate letter grades
    public static char getLetterGrade(int score) {

        if(score >=90 && score <=100){
            return'A';
        }
        else if(score >=80 && score <=89){
            return'B';
        }
        else if(score >=70 && score <=79){
            return'C';
        }
        else if(score >=60 && score <=69){
            return'D';
        }
        else if(score <60 && score >=0){
            return'F';
        }
        else{
            return 'X';
        }

    }
    


    // Method to find students who need to retake exam
    public static String[] findFailingStudents(String[] names, int[] scores)
    {
        ArrayList<String> failList = new ArrayList<>();
        for (int i=0; i < scores.length; i++){
            if(scores[i] < 60){
                failList.add(names[i]);
            }
        }
        return failList.toArray(new String[0]);
    }


    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        String[] failingStudents = findFailingStudents(students, scores);

        System.out.println("Students who need to retake the exam:");
        for (String name : failingStudents) {
            System.out.println(name);
        }
    }
}
