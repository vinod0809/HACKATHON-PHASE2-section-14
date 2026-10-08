public  {import java.util.Scanner;

class Student {
    private String studentName;
    private int rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public boolean checkEligibility() {
        return this.marks >= 50;
    }

    public double calculateFee() {
        return this.courseCredits * 1500.0;
    }

    public double calculateScholarship() {
        double fee = calculateFee();
        if (this.marks >= 85) {
            return 0.20 * fee; 
        } else if (this.marks >= 70) {
            return 0.10 * fee; 
        } else {
            return 0.0; 
        }
    }

    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }
    public void displayDetails() {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility Status: Eligible");
        System.out.println("Total Fee: Rs. " + calculateFee());
        System.out.println("Scholarship: Rs. " + calculateScholarship());
        System.out.println("Final Fee: Rs. " + calculateFinalFee());
    }
}

public void main() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Student Name: ");
    String studentName = sc.nextLine();

    System.out.print("Enter Roll Number: ");
    int rollNumber = sc.nextInt();

    System.out.print("Enter Marks: ");
    double marks = sc.nextDouble();
    sc.nextLine(); // consume newline

    System.out.print("Enter Course Name: ");
    String courseName = sc.nextLine();

    System.out.print("Enter Course Credits: ");
    int courseCredits = sc.nextInt();

    Student student = new Student(studentName, rollNumber, marks, courseName, courseCredits);

    if (student.checkEligibility()) {
        student.displayDetails();
    } else {
        System.out.println("\nStudent is not eligible for course registration (Marks must be 50 or above).");
    }

    sc.close();
}
    
}
