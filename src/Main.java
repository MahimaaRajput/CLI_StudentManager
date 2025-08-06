import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Student> students=new ArrayList<>();
   private static Scanner sc=new Scanner(System.in);
    public static void addStudent()
    {
        System.out.println("Enter Id");
        int id= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter marks out of 100");
        double marks=sc.nextDouble();
        if (marks<0 || marks>100)
        {
            System.out.println("please enter marks between 0 and 100");
        }else {
            Student student = new Student(id, name, marks);
            students.add(student);
            System.out.println("Student added successfully");
        }

    }
    public static void viewStudents()
    {
        if (students.isEmpty())
        {
            System.out.println("student list is empty");
        }
        else{
        for (Student st:students)
        {
            System.out.println(st);
        }
        }
    }
    public static void updateStudent(int id)
    {
        System.out.println("enter student id");
        id=sc.nextInt();
        sc.nextLine();
        boolean found=false;
        for (Student st:students)
        {
            if (st.getId()==id)
            {
                System.out.println("Enter  new name");
                String name=sc.nextLine();
                System.out.println("Enter new marks");
                double marks=sc.nextDouble();
                if (marks<0 || marks>100)
                {System.out.println("please enter marks between 0 and 100");}
                else{
                st.setName(name);
                st.setMarks(marks);
                System.out.println("Student updated successfully");
                found=true;
                break;}
            }
        }
        if (!found){
            System.out.println("student not found with id " +id);
        }

    }
    public static void deleteStudent(int id)
    {
        System.out.println("enter student id you want to delete");
        id=sc.nextInt();
        boolean found=false;
        for (int i=0;i<students.size();i++)
        {
            if (students.get(i).getId()==id)
            {
                students.remove(i);
                System.out.println("Student deleted successfully");
                found=true;
                break;
            }
        }
        if (!found)
        {
            System.out.println("student not found with id "+id);
        }
    }

    public static void main(String[] args) {
     int choice;
        do {
            System.out.println("----Student Record Management----");
            System.out.println("choose opearations");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
             choice=sc.nextInt();
            switch (choice)
            {

                case 1: addStudent();
                        break;
                case 2:viewStudents();
                        break;
                case 3: int id = 0;
                    updateStudent(id);
                    break;
                case 4: int sid=0;
                   deleteStudent(sid);
                   break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        while (choice!=5);

    }
}