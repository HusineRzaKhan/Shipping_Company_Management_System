public class Person {
    private int CNIC;
    private String name;
    private int age;
    private int contact;

    public Person(int cNIC, String name, int age, int contact) {
        CNIC = cNIC;
        this.name = name;
        this.age = age;
        this.contact = contact;
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

    
}
