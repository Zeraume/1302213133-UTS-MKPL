package lib;

import java.time.Year;
import java.time.MonthDay;

public class Employee {

    private EmployeeData employeeData;
    private Grade grade;
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;
    private FamilyData familyData;

    public Employee(EmployeeData employeeData, Grade grade) {
        this.employeeData = employeeData;
        this.grade = grade;
        this.familyData = new FamilyData();
    }
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	 public void setMonthlySalary() {
        int baseSalary = getBaseSalaryByGrade(grade);
        monthlySalary = employeeData.isForeigner() ? (int) (baseSalary * 1.5) : baseSalary;
    }
	
	public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setOtherMonthlyIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.familyData.setSpouse(spouseName, spouseIdNumber);
    }

    public void addChild(String childName, String childIdNumber) {
        this.familyData.addChild(childName, childIdNumber);
    }
	
	public int getAnnualIncomeTax() {
        int monthsWorked = calculateMonthsWorked();
        boolean isSingle = familyData.isSingle();
        int numChildren = familyData.getNumChildren();

        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthsWorked, annualDeductible, isSingle, numChildren);
    }

	private int calculateMonthsWorked() {
        int currentYear = Year.now().getValue();
        int monthsWorked;
        if (employeeData.getYearJoined() == currentYear) {
            int currentMonth = MonthDay.now().getMonthValue();
            monthsWorked = currentMonth - employeeData.getMonthJoined() + 1;
        } else {
            monthsWorked = 12;
        }
        return monthsWorked;
    }

	private int getBaseSalaryByGrade(Grade grade) {
        switch (grade) {
            case GRADE_1:
                return 3000000;
            case GRADE_2:
                return 5000000;
            case GRADE_3:
                return 7000000;
            default:
                throw new IllegalArgumentException("Invalid grade");
        }
    }
}
