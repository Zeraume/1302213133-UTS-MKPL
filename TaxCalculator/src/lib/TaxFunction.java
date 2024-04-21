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
	
	// Method untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        int tax = 0;

		// Memastikan jika jumlah bulan bekerja melebihi 12 bulan per tahun
        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        numberOfChildren = Math.min(numberOfChildren, 3); // Batasi jumlah anak maksimal menjadi 3

		// Hitung penghasilan yang dikenakan pajak dan pemotongan pajak
        int taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, isMarried, numberOfChildren);
        int taxDeduction = calculateTaxDeduction(isMarried, numberOfChildren);

        tax = (int) Math.round(0.05 * (taxableIncome - deductible - taxDeduction));

        return Math.max(tax, 0); // Memastikan pajak tidak kurang dari 0
    }

	// Method untuk menghitung penghasilan yang dikenakan pajak
    private static int calculateTaxableIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, boolean isMarried, int numberOfChildren) {
		// Hitung penghasilan dasar dan pemotongan pajak
        int basicIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        int taxExemption = calculateTaxExemption(isMarried, numberOfChildren);

        return basicIncome - taxExemption;
    }

	// Method untuk menghitung pemotongan pajak
    private static int calculateTaxExemption(boolean isMarried, int numberOfChildren) {
		// Tentukan pemotongan dasar dan pemotongan berdasarkan jumlah anak
        int baseExemption = isMarried ? 54000000 + 4500000 : 54000000;
        int childrenExemption = numberOfChildren * 1500000;

        return baseExemption + childrenExemption;
    }

	// Method untuk menghitung pemotongan pajak
    private static int calculateTaxDeduction(boolean isMarried, int numberOfChildren) {
        return calculateTaxExemption(isMarried, numberOfChildren);
    }
	
}
