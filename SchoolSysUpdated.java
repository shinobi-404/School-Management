
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class SchoolSysUpdated {
/** 
    *@param userID 
    *@throws IdException
*/


    static boolean idFormat(String userID) throws IdException {

        String organizer = "^[A-z]{2}[0-9]{4}$";
        boolean check = Pattern.matches(organizer, userID);

        if (!check) {
            throw new IdException("\n\t\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit");
        } else {
            return true;
        }

    }

    static FileWriter fwriter;
    public static void main(String[] args)throws Exception{
        
        
        // scan and file writer variables 
        fwriter = new FileWriter("report.txt");
        Scanner myScan = new Scanner(System.in);
        // counter variables 
        int sum = 0;
        int tally = 0;
        // array list variables 
        Person[] list = new Person[100];
        Student[] slist = new Student[100];
        
        // welccome screen 
        System.out.println("\t\tWelcome to my Personnel Management Program");
        System.out.println("\nChoose one of the options:\n");
        
        
        while(true){
            // prompts user to select a choice 
            System.out.println("1- Enter the information of a faculty member");
            System.out.println("2- Enter the information of a student ");
            System.out.println("3- Print tuition invoice for a student");
            System.out.println("4- Print faculty information");
            System.out.println("5- Enter the information of a staff member");
            System.out.println("6- Print the information of a staff member");
            System.out.println("7- Exit Program");
            System.out.print("\n\tEnter your selection: ");
            String ans = myScan.next();

            if(ans.equals("1")){
                    
                String id = "";
                    // asks user to enter info 
                    System.out.println("\nEnter the faculty info:");
                    //prompts user to enter faculty name 
                    System.out.print("\n\t\tName of the faculty:  ");
                    myScan.nextLine();
                    
                    String name = myScan.nextLine();
                
                    do {
                        System.out.print("\n\t\tID: ");
                        id = myScan.nextLine();
                        try{
                            if (idFormat(id)){
                                break;
                            }

                        } catch (IdException e){
                            System.out.println("\t" + e.getMessage());
                        }
                    } while(true);


                    System.out.print("\n\t\tRank: ");
                    String rank = myScan.nextLine();

                    while (!((rank.toLowerCase().equals("professor") || rank.toLowerCase().equals("adjunct")))){

                        System.out.println("\t\t\"" + rank + "\" is invalid");
                        System.out.print("\n\t\tRank: ");
                        rank = myScan.nextLine();

                    }
                    System.out.print("\n\t\tDepartment: ");
                    String department = myScan.nextLine();

                    while (!((department.toLowerCase().equals("mathematics") || department.toLowerCase().equals("engineering") || department.toLowerCase().equals("sciences")))){
                        
                        System.out.println("\t\t\t\"" + department + "\" is invalid");
                        
                        System.out.print("\n\t\tDepartment: ");
                        department = myScan.nextLine();
                    }
                    
                    list[sum]= new Faculty(name, id, department, rank);
                    sum++;
                    
                    System.out.println("\nFaculty added!\n\n");
                    
            }          
            else if(ans.equals("2")){

                    System.out.println("\nEnter the student info: ");

                    System.out.print("\n\t\tName of the student:  ");
                    String sid = "";
                    myScan.nextLine();

                    String sName = myScan.nextLine();

                    

                    do {
                        System.out.print("\n\t\tID: ");
                        sid = myScan.nextLine();
                        try{
                            if (idFormat(sid)){
                                break;
                            }

                        } catch (IdException e){
                            System.out.println("\t" + e.getMessage());
                        }

                    }while(true);



                    System.out.print("\n\t\tGpa: ");
                    double sgpa = myScan.nextDouble();

                    System.out.print("\n\t\tCredit hours: ");
                    int scredits = myScan.nextInt();

                    slist[tally] = new Student(sName, sid, sgpa, scredits);
                    tally++;

                    System.out.println("\nStudent added!\n\n");
                    
            }
            else if(ans.equals("3")){

                String sid = "";

                do {

                    System.out.print("\n\tEnter the student's ID: ");
                    sid = myScan.next();

                    try {

                        if (idFormat(sid)) {

                            break;
                        }

                    } catch (IdException e) {

                        System.out.println("\t " + e.getMessage());

                    }
                } while (true);
    
                myScan.nextLine();
                boolean student = false;
                for (int i = 0; i<tally; i++){

                    if (slist[i].getid().equals(sid)){

                        slist[i].print();
                        student = true;
                    } 
                }
                if (!student){

                    System.out.println("\tNo student matched!");

                }
               

            }
            else if(ans.equals("4")){

                    String fid = "";

                    do {

                        System.out.print("\n\tEnter the Faculty's ID: ");
                        fid = myScan.next();

                        try {

                            if (idFormat(fid)) {
                                break;
                            }

                        } catch (IdException e) {

                            System.out.println("\t " + e.getMessage());

                        }

                    } while (true);

                    myScan.nextLine();
                    boolean faculty = false;

                    for (int i = 0; i<sum; i++){

                        if (list[i].getid().equals(fid)){

                            list[i].print();
                            faculty = true;
                        } 
                    }
                    if (!faculty){

                        System.out.println("\tNo Faculty matched!");

                    }
                    

            }
            else if(ans.equals("5")){

                    System.out.print("\n\tName of the staff member: ");
                    myScan.nextLine();
                    
                    String stid = "";
                    String stname = myScan.nextLine();

                    do {

                        System.out.print("\n\tEnter the ID: ");
                        stid = myScan.nextLine();

                        try {

                            if (idFormat(stid)) {

                                break;

                            }

                        } catch (IdException e) {

                            System.out.println("\t " + e.getMessage());

                        }

                    } while(true);

                    System.out.print("\n\tDepartment: ");
                    String stdepartment = myScan.nextLine();

                    while (!(stdepartment.toLowerCase().equals("mathematics") || stdepartment.toLowerCase().equals("engineering")|| stdepartment.toLowerCase().equals("sciences"))) {
                        System.out.println("\t\t\t\"" + stdepartment + "\" is invalid");
                        System.out.print("\n\t\tDepartment: ");
                        stdepartment = myScan.nextLine();
                    }

                    System.out.print("\n\t\tStatus, Enter P for Part Time, or Enter F for Full Time: ");
                    String sttype = myScan.nextLine();

                    while (!(sttype.toUpperCase().equals("P") || sttype.toUpperCase().equals("F"))) {
                        System.out.println("\"" + sttype + "\" is invalid");
                        System.out.print("Status, Enter P for Part Time, or Enter F for Full Time: ");
                        sttype = myScan.nextLine();
                    }
                    String type = "";
                    if(sttype.equals("P")){
                        type = "Part Time";
                    }
                    else{
                        type = "Full Time";
                    }
                    list[sum]= new Staff(stname, stid, stdepartment, type);
                    sum++;
                    System.out.println("\nStaff member added!\n\n");
                    
            }
            else if(ans.equals("6")){

                    String stid = "";

                    do {

                        System.out.print("\n\tEnter the Staff's ID: ");
                        stid = myScan.next();

                        try {

                            if (idFormat(stid)) {
                                break;
                            }

                        } catch (IdException e) {
                            System.out.println("\t " + e.getMessage());
                        }

                    } while (true);

                    myScan.nextLine();
                    boolean staff = false;

                    for (int i = 0; i < sum; i++) {

                        if (list[i].getid().equals(stid)) {

                            list[i].print();
                            staff = true;
                        }
                    }
                    if (!staff) {

                        System.out.println("\nNo Staff member matched!\n");
                    }
                    

            } 
            else if(ans.equals("7")){

                System.out.print("Would you like to create the report? (Y/N): ");
                
                String repfile = myScan.next();
                System.out.println("Would you like to sort your students by (1) gpa or (2) credit hours:");
                String sortinput = myScan.next();
                if (repfile.toLowerCase().equals("y")){
                    try{ 
                        FileWriter fwriter = new FileWriter("report.txt"); 
                   
                        fwriter.write("\t\tReport created on "+ java.time.LocalDate.now());
                        fwriter.write("\n\t\t**********************");
                        fwriter.write("\n\nFaculty Members");
                        fwriter.write("\n------------------\n");

                        for (int i = 0; i<sum; i++){
                            if (list[i] instanceof Faculty)
                                list[i].repfile(fwriter);
                        }

                        fwriter.write("\n");
                        fwriter.write("\n\nStaff Members");
                        fwriter.write("\n------------------\n");

                        for (int i = 0; i<sum; i++){
                            if (list[i] instanceof Staff)
                                list[i].repfile(fwriter);       
                        }
                        fwriter.write("\n");
                        fwriter.write("\nStudents");
                        fwriter.write("\n---------\n");
                        for (int i = 0; i<sum; i++){
                            if (list[i] instanceof Student)
                                list[i].repfile(fwriter);
                        }

                        ArrayList<Student> sArrayList = new ArrayList<Student>();

                        for(int i = 0; i < tally ; i++){
                            sArrayList.add((Student)slist[i]);
                        }

                        if(sortinput.equals("1")){
                            Collections.sort(sArrayList, new SortbyGPA());
                            for(int i = 0; i < tally; i++){
                                sArrayList.get(i).repfile(fwriter);
                            }
                            fwriter.close();
                        }
                        else if (sortinput.equals("2")){
                            Collections.sort(sArrayList, new SortbyCreditHours());
                            for(int i = 0; i < tally; i++){
                                sArrayList.get(i).repfile(fwriter);
                            }

                            fwriter.close();
                        }
                        else{
                            System.out.println("try again, pick 1 or 2");
                        }
                        
                    }catch (IOException e) {
                        System.out.println("An error occured.");
                        e.printStackTrace();
                    }
                    System.out.println("Report created and saved on your hard drive!");
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                else{
                    System.out.println("Goodbye!");
                    System.exit(0);
                }                
            }
            else{
                System.out.println("\nInvalid entry- please try again\n"); 
            }
                    
        }
 
    }
}


   

abstract class Person{
    private String fullName;
    private String id;


    public Person(String fullName, String id){
        this.fullName = fullName;
        this.id = id;
        
    }

    public Person(){
        this.fullName = "N/A";
        this.id = "N/A";
    }


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
    }
    public abstract void print();

    public abstract void repfile(FileWriter fwriter) throws IOException; 

}

class Student extends Person{
    private double gpa;
    private int creditHours; 

    public Student(String fullName, String id, double gpa, int creditHours){
        super(fullName , id);
        this.gpa = gpa;
        this.creditHours = creditHours;
        
    }
    public Student(){
        super();
    }

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

    public void print(){
        double discount = 0;
        double total = 52 + 236.45 * getCreditHours();
        if (getGpa() >= 3.85){
        discount= (total * 25) / 100;
        total = total - discount;
        }

    System.out.println("Here is the tuition invoice for " + getFullName() + ":");

    System.out.println("--------------------------------------------------------------------------- ");

    System.out.println(getFullName() + "\t\t\t" + getid() + "\nCredit Hours: " + getCreditHours() + " ($236.45/credit hour)");

    System.out.println("Fees: $52");

    System.out.println("\nTotal payment: $" + String.format("%.2f", total) + "\t\t\t($" + String.format("%.2f", discount) + " discount applied)");

    System.out.println("---------------------------------------------------------------------------");

    }
    
    public void repfile(FileWriter fwriter) throws IOException{
        fwriter.write("\n\n\t1. "+this.getFullName());  		
        fwriter.write("\n\tID: " + this.getid());
        fwriter.write("\n\tGpa: " + this.getGpa()); 
        fwriter.write("\n\tCredit hours: " + this.getCreditHours());  		 		
        
    }

}

abstract class Employee extends Person{
    private String department;

    public Employee(String fullName, String id, String department) {
        super(fullName, id);
        this.department = department.toUpperCase().charAt(0)+department.toLowerCase().substring(1,department.length());
    }

    public Employee(){
        super();
    }

    public String getDepartment() {
        return department;
    }   

    public void setDepartment(String department) {
    this.department = department;
    }

    @Override
    public void print() {
        System.out.println(getFullName() + "\t\t\t" + getid());
    }

}
class Faculty extends Employee{
    private String rank;

    public Faculty(String fullName, String id, String department, String rank) {
        super(fullName, id, department);
        this.rank = rank.toUpperCase().charAt(0)+rank.toLowerCase().substring(1,rank.length());
    }

    public Faculty() {
        super();
    }

    public String getRank(){
        return rank;
    }

    public void setRank(String rank){
        this.rank = rank;
    }

    public void print() {
        System.out.println("---------------------------------------------------------------------------");

        super.print();

        System.out.println(getDepartment()+" Department, " + getRank());

        System.out.println("---------------------------------------------------------------------------");

    }


    public void repfile(FileWriter fwriter) throws IOException{
        fwriter.write("\n\n\t1. "+this.getFullName());  		
        fwriter.write("\n\tID: " + this.getid());  		 		
        fwriter.write("\n\t"+this.getDepartment() + "," + this.getRank());
    }

}

class Staff extends Employee{
    private String status;

    public Staff(String fullName, String id, String department, String status) {
        super(fullName, id, department);
        this.status = status;
        }

        public Staff(){
            super();
        }
        
        public String getstatus() {
            return status;
        }

        public void setstatus(String status) {
            this.status = status;
        }

        public void print() {
            System.out.println("----------------------------------------------------------------");

            super.print();

            System.out.println(getDepartment()+" Department, "+ getstatus());

            System.out.println("----------------------------------------------------------------");
        }


        public void repfile(FileWriter fwriter) throws IOException{
            fwriter.write("\n\n\t1. "+this.getFullName());  		
            fwriter.write("\n\tID: " + this.getid());  		 		
            fwriter.write("\n\t"+this.getDepartment() + "," + this.getstatus());
        }

}

class IdException extends Exception{

    public IdException(String message)
    {
        super(message);
    }
}

class SortbyCreditHours implements Comparator<Student> {
    
    public int compare(Student a, Student b)
        {
     
            return Double.compare(b.getCreditHours(), a.getCreditHours());
        }
}


class SortbyGPA implements Comparator<Student> {
    // Method
        // Sorting in ascending order of roll number

        public int compare(Student a, Student b)
        {
        
            return Double.compare(b.getGpa(), a.getGpa());
            
        }
}