public class Employee {
    private int CNIC;
    private String name;
    private int age;
    private int contact;
    private int id;
    private int salary;
    private String designation;
    
    public Employee(int cNIC, String name, int age, int contact, int id, int salary, String designation) {
        CNIC = cNIC;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.id = id;
        this.salary = salary;
        this.designation = designation;
    }

    public int getCNIC() {
        return CNIC;
    }

    public void setCNIC(int cNIC) {
        CNIC = cNIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    
    
}
