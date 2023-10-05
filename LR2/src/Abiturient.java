public class Abiturient {
    private int id;
    private String firstName;
    private String lastName;
    private String patronymicName;
    private String address;
    private String phone;
    private double averageScore;
    public Abiturient(int id, String lastName, String firstName, String patronymicName, String address, String phone, double averageScore) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.address = address;
        this.phone = phone;
        this.averageScore = averageScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }





    @Override
    public String toString() {
        return "Abiturient{" +
                "id=" + id +
                ",  lastName='" + lastName + '\'' +
                ",  firstName='" + firstName + '\'' +
                ",  patronymicName='" + patronymicName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ",  averageScore=" + averageScore +
                '}';
    }


}

