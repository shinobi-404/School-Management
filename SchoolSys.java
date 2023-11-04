
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args){
        
        // variable declarations 
        int num = 0;
        Person[] schoolList = new Person[100];
        Scanner myScan = new Scanner(System.in);
        int answer; // variable used for user input 
        
        // welcomes user 
        System.out.println("\n\t\tWelcome to my Personnel Management Program ");
        System.out.println("\nChoose one of the options:\n");
        
        //loops user as long as the user wills
        while(true){
            // try catches the code and inside it checks for user misinputs and mistakes that can make the program crash
            try{

                System.out.println("1- Enter the information of a faculty member");
                System.out.println("2- Enter the information of a student ");
                System.out.println("3- Print tuition invoice for a student");
                System.out.println("4- Print faculty information");
                System.out.println("5- Enter the information of a staff member");
                System.out.println("6- Print the information of a staff member");
                System.out.println("7- Exit Program");
                
                System.out.print("\n\tEnter your selection: ");
                answer = myScan.nextInt();

                // if the user selects 1 than faculty is prompted to enter it 
                if(answer == 1){
                    System.out.println("\nEnter the faculty info:");
                    System.out.print("\n\t\tName of the faculty:  ");
                    myScan.nextLine();
                    String fname = myScan.nextLine();

                    System.out.print("\n\t\tID: ");
                    String fID = myScan.nextLine();

                    System.out.print("\n\t\tRank: ");
                    String fRank = myScan.nextLine();
                    
                    // keeps asking user until the correct rank is entered
                    while (!((fRank.toLowerCase().equals("professor") || fRank.toLowerCase().equals("adjunct")))){
                        
                        System.out.println("\t\t\t\"" + fRank + "\" is invalid");
                        System.out.print("\n\t\tRank: ");
                        fRank = myScan.nextLine();
                    }

                    System.out.print("\n\t\tDepartment: ");
                    String fDep = myScan.nextLine();
                    
                    // loops user until the correct department is entered 
                    while (!((fDep.toLowerCase().equals("mathematics") || fDep.toLowerCase().equals("engineering") || fDep.toLowerCase().equals("sciences")))){
                        
                        System.out.println("\t\t\t\"" + fDep + "\" is invalid");
                        System.out.print("\n\t\tDepartment: ");
                        fDep = myScan.nextLine();
                    }
                    
                    schoolList[num]= new Faculty(fname, fID, fDep, fRank);
                    num++;
                    System.out.println("\nFaculty added!\n\n");
                
                    
                } 
                // prompts user to see enter student information 
                else if(answer == 2){
                    
                    System.out.println("\nEnter the student info:");
                    System.out.print("\n\t\tName of the student:  ");
                    myScan.nextLine();
                    String sname = myScan.nextLine();

                    System.out.print("\n\t\tID: ");
                    String sID = myScan.nextLine();

                    System.out.print("\n\t\tGpa: ");
                    double sGpa = myScan.nextDouble();

                    System.out.print("\n\t\tCredit hours: ");
                    int scredit = myScan.nextInt();

                    schoolList[num] = new Student(sname, sID, sGpa, scredit);
                    num++;
                    System.out.println("\nStudent added!\n\n");
                    
                }
                // asks user for student id to checks student information 
                else if(answer == 3){
                    
                    System.out.print("\n\tEnter the student's ID: ");
                    myScan.nextLine();
                    String checkSID = myScan.nextLine();

                    boolean checkStu = false;

                    for (int i = 0; i<num; i++){
                        
                        if (schoolList[i].getId().equals(checkSID)){
    
                            schoolList[i].print();
                            checkStu = true;
                        } 
                    }
                    if (!checkStu){

                        System.out.println("\tNo Student matched!\n");
                    }
                
                }
                
                else if(answer == 4){

                    System.out.print("\n\tEnter the Faculty's ID: ");
                    myScan.nextLine();
                    String checkFID = myScan.nextLine();

                    boolean checkFac = false;

                    for (int i = 0; i<num; i++){

                        if (schoolList[i].getId().equals(checkFID)){
                            
                            schoolList[i].print();
                            checkFac = true;
                        } 
                    }
                    if (!checkFac){

                        System.out.println("\tNo Faculty matched!");
                    }
                
                }

                
                else if(answer == 5){

                    System.out.print("\n\t\tName of the staff member: ");
                    myScan.nextLine();
                    String staName = myScan.nextLine();

                    System.out.print("\n\t\tEnter the ID: ");
                    String staID = myScan.nextLine();

                    System.out.print("\n\t\tDepartment: ");
                    String staDep = myScan.nextLine();

                    while (!(staDep.toLowerCase().equals("mathematics") || staDep.toLowerCase().equals("engineering")|| staDep.toLowerCase().equals("sciences"))) {
                        
                        System.out.println("\t\t\t\"" + staDep + "\" is invalid");

                        System.out.print("\n\t\tDepartment: ");
                        staDep = myScan.nextLine();
                    }

                    System.out.print("\n\t\tStatus, Enter P for Part Time, or Enter F for Full Time:");
                    String staHours = myScan.nextLine();

                    while (!(staHours.toUpperCase().equals("P") || staHours.toUpperCase().equals("F"))) {
                        
                        System.out.println("\"" + staHours + "\" is invalid");

                        System.out.print("Status, Enter P for Part Time, or Enter F for Full Time:: ");
                        staHours = myScan.nextLine();
                    }
                    
                    String hours = "";
                    
                    if(staHours.equals("P")){
                        hours = "Part Time";
                    }
                    else{
                        hours = "Full Time";
                    }

                    schoolList[num]= new Staff(staName, staID, staDep, hours);
                    num++;
                    System.out.println("\nStaff member added!\n\n");
                
                }

                
                else if(answer == 6){
                    
                    System.out.print("\n\tEnter the Staff's ID: ");
                    myScan.nextLine();
                    String staID = myScan.nextLine();

                    boolean checkStaff = false;

                    for (int i = 0; i < num; i++) {
                        if (schoolList[i].getId().equals(staID)) {
                            
                            schoolList[i].print();
                            checkStaff = true;
                        }
                    }
                    if (!checkStaff) {
                        System.out.println("\tNo Staff member matched!\n");
                    }
                    
                }
                
                else if(answer == 7){
                    
                    System.out.println("\nGoodbye!");
                    System.exit(0);
                    break;
                }
                
                else{
                    System.out.println("\nInvalid entry- please try again\n");// change to exception handling, try, catch // glorrifed if else statement, expect a num 
                }

            }catch(Exception ex){
                System.out.println("\nInvalid entry- please try again\n");
                myScan.nextLine();
                
            }
        }
        myScan.close(); 
    }
       
}


// used strictly for other classes to take data from 
abstract class Person{
    private String fullname;
    private String id;


    public Person(String fullname, String id){
        this.fullname=fullname;
        this.id=id;
    }

    public Person (String fullname){
        this.fullname = fullname;

    }

    public Person(){

    }


	public String getFullName() {
		return fullname;
	}

	public void setFullName(String fullname) {
		this.fullname = fullname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
    }
    public abstract void print();

}
// creates a student 
class Student extends Person{
    private double gpa;
    private int creditHours; 

    public Student(String fullname, String id, double gpa, int creditHours){
        super(fullname, id);
        this.gpa=gpa;
        this.creditHours=creditHours;
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
    @Override
    public void print() {
        double discount= 0;
        double total = 52 + 236.45 * getCreditHours();
        if (getGpa() >= 3.85) {
        discount= (total * 25) / 100;
        total = total - discount;
        }

System.out.println("Here is the tuition invoice for " + getFullName());
System.out.println("--------------------------------------------------------------------------- ");
System.out.println(getFullName() + "\t\t\t" + getId() + "\nCredit Hours: " + getCreditHours() + " ($236.45/credit hour)");
System.out.println("Fees: $52");
System.out.println("\nTotal payment: $" + String.format("%.2f", total) + "\t\t\t($" + String.format("%.2f", discount) + " discount applied)");
System.out.println("---------------------------------------------------------------------------");
}
}

// employee class becomes a class for data and inherits data from employee 
abstract class Employee extends Person{
    private String department;

    public Employee(String fullname, String id, String department) {
        super(fullname, id);
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
        System.out.println(getFullName() + "\t\t\t" + getId());
    }

}
class Faculty extends Employee{
    private String rank;

    public Faculty(String fullname, String id, String department, String rank) {
        super(fullname, id, department);
        this.rank = rank.toUpperCase().charAt(0)+rank.toLowerCase().substring(1,rank.length());
    }
    public Faculty() {
        super();
    }
    public String getRank(){
        return rank;
    }
    public void setRank(String rank){
        this.rank=rank;
    }

    @Override
    public void print() {
        System.out.println("---------------------------------------------------------------------------");
        super.print();
        System.out.println(getDepartment()+" Department, "+getRank());
        System.out.println("---------------------------------------------------------------------------");
    }

}


// staff class uses data from employee 
class Staff extends Employee{
    private String hours;

    public Staff(String fullname, String id, String department, String hours) {
        super(fullname, id, department);
        this.hours = hours;
        }

        public Staff(){
            super();
        }
        
        public String getHours() {
            return hours;
        }

        public void setHours(String hours) {
            this.hours = hours;
        }

        @Override
        public void print() {
            System.out.println("----------------------------------------------------------------");
            super.print();
            System.out.println(getDepartment()+" Department, "+getHours());
            System.out.println("----------------------------------------------------------------");
            
        }
        
}


