// class for Project objects
public class Project {

    // initialise project attributes
    int number;
    String name;
    String building;
    String address;
    int erf;
    double totalDue;
    double totalPaid;
    String deadline;
    Person architect;
    Person contractor;
    Person customer;
    boolean finalized;
    String completionDate;

    // Project constructor
    public Project(int number, String name, String building, String address, int erf, double totalDue,
                   double totalPaid, String deadline, Person architect, Person contractor, Person customer,
                   Boolean finalized, String completionDate) {

        // set Project attributes

        this.number = number;

        // if name of building is not provided then set name to building type followed by customer surname
        if (name.length() == 0) {
            this.name = building + " " + ((customer.name).split(" "))[1];
        }
        else {
            this.name = name;
        }

        this.building = building;
        this.address = address;
        this.erf = erf;
        this.totalDue = totalDue;
        this.totalPaid = totalPaid;
        this.deadline = deadline;
        this.architect = architect;
        this.contractor = contractor;
        this.customer = customer;
        this.finalized = finalized;
        this.completionDate = completionDate;

    }

    // change deadline using set method
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    // change total amount using set method
    public void setTotalAmount(double totalAmount) {
        this.totalPaid = totalAmount;
    }

    // finalize project by changing the status to true
    public void finalizeProject() {
        this.finalized = true;
    }

    // change completion date
    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    // method to return invoice as a string
    public String invoice() {

        return "Invoice for " + customer.name +
                "\nEmail: " + customer.email +
                "\nTelephone number: " + customer.number +
                "\nAmount still due: " + (totalDue-totalPaid);
    }

}
