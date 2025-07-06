import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");

        int subjectCount = input.nextInt();

        // Validation to ensure subject count is positive
        while (subjectCount <= 0) {
            System.out.println("Please enter a valid number of subjects.");
            System.out.print("Re-enter the number of subjects: ");
            subjectCount = input.nextInt();
        }

        int marks[] = new int[subjectCount]; // Array to store marks of each subject
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < subjectCount; i++) 
        {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");

            int mark = input.nextInt();

            // Validation to ensure marks are within range
            while (mark < 0 || mark > 100) {
                System.out.println("Please enter a valid mark between 0 and 100.");
                System.out.print("Re-enter marks for subject " + (i + 1) + ": ");

                mark = input.nextInt();
            }

            // Store the valid mark in the array and add to total
            marks[i] = mark;
            totalMarks += mark; // Add to total marks
        }

        // Calculate average percentage
        double average = (double) totalMarks / subjectCount;

        String grade;

        // Assign grade based on average percentage
        if (average >= 90) 
        {
            grade = "A+";
        } 
        else if (average >= 80) 
        {
            grade = "A";
        } 
        else if (average >= 70) 
        {
            grade = "B+";
        } 
        else if (average >= 60) 
        {
            grade = "B";
        } 
        else if (average >= 50) 
        {
            grade = "C";
        } 
        else if (average >= 40) 
        {
            grade = "D";
        } 
        else if (average >= 33) 
        {
            grade = "E";
        }
        else 
        {
            grade = "F";
        }

        // Display results
        System.out.println("\n    --- Report Card --- ");
        System.out.println("Total Marks: " + totalMarks + " out of " + (subjectCount * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        input.close();
    }
}