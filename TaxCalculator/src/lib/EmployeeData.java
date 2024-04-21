package lib;

public class EmployeeData {
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private boolean isForeigner;
    private boolean gender;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getYearJoined() {
        return yearJoined;
    }
    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }
    public int getMonthJoined() {
        return monthJoined;
    }
    public void setMonthJoined(int monthJoined) {
        this.monthJoined = monthJoined;
    }
    public int getDayJoined() {
        return dayJoined;
    }
    public void setDayJoined(int dayJoined) {
        this.dayJoined = dayJoined;
    }
    public boolean isForeigner() {
        return isForeigner;
    }
    public void setForeigner(boolean isForeigner) {
        this.isForeigner = isForeigner;
    }
    public boolean isGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public EmployeeData(String firstName, String lastName, String idNumber, String address, int yearJoined,
            int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;
    }
    
}

