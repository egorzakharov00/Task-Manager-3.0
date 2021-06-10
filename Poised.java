// import scanner class
import java.util.Scanner;

public class Poised {
    // main method
    public static void main(String[] args) {
        // scanner object
        Scanner input = new Scanner(System.in);
        System.out.println("Lets build");

        // get details about architect and store details in variables
        System.out.println("Enter the architect's name and surname:");
        String architectName = input.nextLine();
        System.out.println("Enter the architect's telephone number:");
        String architectNumber = input.nextLine();
        System.out.println("Enter the architect's email address:");
        String architectEmail = input.nextLine();
        System.out.println("Enter the architect's physical address");
        String architectAddress = input.nextLine();

        // get details about contractor and store details in variables
        System.out.println("Enter the contractor's name and surname");
        String contractorName = input.nextLine();
        System.out.println("Enter the contractor's telephone number:");
        String contractorNumber = input.nextLine();
        System.out.println("Enter the contractor's email address:");
        String contractorEmail = input.nextLine();
        System.out.println("Enter the contractor's physical address");
        String contractorAddress = input.nextLine();

        // get details about customer and store details in variables
        System.out.println("Enter the customer's name and surname");
        String customerName = input.nextLine();
        System.out.println("Enter the customer's telephone number:");
        String customerNumber = input.nextLine();
        System.out.println("Enter the customer's email address:");
        String customerEmail = input.nextLine();
        System.out.println("Enter the customer's physical address");
        String customerAddress = input.nextLine();

        // create architect, contractor and customer objects
        Person architect = new Person(architectName, architectNumber, architectEmail, architectAddress);
        Person contractor = new Person(contractorName, contractorNumber, contractorEmail, contractorAddress);
        Person customer = new Person(customerName, customerNumber, customerEmail, customerAddress);

        // get details about project and store in variables
        System.out.println("Enter the project number:");
        int projectNumber = input.nextInt();
        input.nextLine();   // skip empty line entered by user
        System.out.println("Enter the project name:");
        String projectName = input.nextLine();
        System.out.println("What type of building is being designed? E.g. House, apartment block or store, etc.");
        String buildingType = input.nextLine();
        System.out.println("Enter the physical address for the project:");
        String projectAddress = input.nextLine();
        System.out.println("Enter the ERF number:");
        int erfNumber = input.nextInt();
        System.out.println("Enter the The total fee being charged for the project:");
        double projectFee = input.nextDouble();
        System.out.println("Enter total amount paid to date:");
        double amountPaid = input.nextDouble();
        input.nextLine(); // skip empty line entered by user
        System.out.println("Enter the deadline for the project:");
        String deadline = input.nextLine(); // change deadline type to date?

        // create a project object
        Project project = new Project(projectNumber, projectName, buildingType, projectAddress, erfNumber,
                projectFee, amountPaid, deadline, architect, contractor, customer, false, "");

        // Output instruction and get choice to change/update details
        System.out.println("Enter 0 to change/update details");
        int choice = input.nextInt();
        // if user chooses to change/update details
        if (choice == 0) {
            // set int type to 99 (can be any random int besides 0)
            int type = 99;
            // while user does not exit loop over menu
            while (type != 0) {
                // output options
                System.out.println("""
                        Enter 1 to change the due date of the project
                        Enter 2 to change the total amount of the fee paid to date
                        Enter 3 to update a contractor’s contact details
                        Enter 0 to exit out of change/update section""");
                // get option type
                type = input.nextInt();

                // if - else chain executing code depending on option type chosen

                // if type is 1 output instruction, get new due date and set new deadline for project
                if (type == 1) {
                    System.out.println("Enter a new due date for the project");
                    String newDate = input.next();
                    project.setDeadline(newDate);
                }

                // if type is 2 output instruction, get new amount and set new total amount for project
                else if (type == 2) {
                    System.out.println("Enter the total amount of the fee paid to date");
                    double newAmount = input.nextDouble();
                    project.setTotalAmount(newAmount);
                }

                // if type is 3
                else if (type == 3) {
                    // output instruction
                    System.out.println("""
                            Enter 1 to update a contractor's email address
                            Enter 2 to update a contractor's telephone number
                            Enter 3 to update both""");
                    // get update choice
                    int update = input.nextInt();

                    // if choice is 1, output message, get new email and set new email for contractor
                    if (update == 1) {
                        System.out.println("Enter an updated contractor's email address");
                        String newEmail = input.next();
                        contractor.setEmail(newEmail);
                    }

                    // if choice is 2, output message, get new number and set new number for contractor
                    else if (update == 2) {
                        System.out.println("Enter an updated contractor's telephone number");
                        String newNumber = input.next();
                        contractor.setNumber(newNumber);
                    }

                    // if choice is 3, execute both if and else if blocks above
                    else if (update == 3) {
                        System.out.println("Enter an updated contractor's email address");
                        String newEmail = input.next();
                        contractor.setEmail(newEmail);
                        System.out.println("Enter an updated contractor's telephone number");
                        String newNumber = input.next();
                        contractor.setNumber(newNumber);
                    }
                }
            }
        }

        // output message and get input to finalize project or not
        System.out.println("""
                Enter 0 to finalize the project or
                Enter anything other integer to pass""");
        int finalizeChoice = input.nextInt();
        // if user chooses to finalize project
        // finalize the project by calling finalizeProject from the Project class
        if (finalizeChoice == 0) {
            project.finalizeProject();
            // get current date and set it as the completion date using the setCompletionDate method
            String completionDate = "Today's Date"; // Was told to keep date in string format by lecturer
            project.setCompletionDate(completionDate);
            // check if project is paid for in full.
            // If true output message else output invoice by calling the invoice method in the Project class
            if (project.totalPaid == project.totalDue) {
                System.out.println("Paid in full");
            } else {
                project.invoice();
            }
        }
    }
}
