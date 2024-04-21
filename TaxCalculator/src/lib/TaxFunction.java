package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	 public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        int tax = 0;

        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        numberOfChildren = Math.min(numberOfChildren, 3); 

        int taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, isMarried, numberOfChildren);
        int taxDeduction = calculateTaxDeduction(isMarried, numberOfChildren);

        tax = (int) Math.round(0.05 * (taxableIncome - deductible - taxDeduction));

        return Math.max(tax, 0); 
    }

    private static int calculateTaxableIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, boolean isMarried, int numberOfChildren) {
        int basicIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        int taxExemption = calculateTaxExemption(isMarried, numberOfChildren);

        return basicIncome - taxExemption;
    }

    private static int calculateTaxExemption(boolean isMarried, int numberOfChildren) {
        int baseExemption = isMarried ? 54000000 + 4500000 : 54000000;
        int childrenExemption = numberOfChildren * 1500000;

        return baseExemption + childrenExemption;
    }

    private static int calculateTaxDeduction(boolean isMarried, int numberOfChildren) {
        return calculateTaxExemption(isMarried, numberOfChildren);
    }
	
}
