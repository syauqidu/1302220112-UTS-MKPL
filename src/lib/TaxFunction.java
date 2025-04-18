package lib;

public class TaxFunction {

	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus
	 * dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan
	 * bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan)
	 * dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena
	 * pajaknya adalah Rp 54.000.000. Jika pegawai sudah menikah maka penghasilan
	 * tidak kena pajaknya ditambah sebesar Rp 4.500.000. Jika pegawai sudah
	 * memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp
	 * 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	public static int getNumberOfChildren(Person person) {
		if (person.getChildren().size() > 3) {
			return 3;
		}
		return person.getChildren().size();
	}

	public static void checkMonthWorking(int numberOfMonthWorking) {
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
	}

	public static int getTidakKenaPajak(Person person, int numberOfChildren) {
		if (person.getSpouse() != null) {
			return (54000000 + 4500000 + (numberOfChildren * 1500000));
		} else {
			return 54000000;
		}
	}

	public static int getTotalIncome(Salary salary) {
		return salary.getMonthlySalary() + salary.getOtherMonthlyIncome();
	}

	public static int calculateTax(Person person, Salary salary, int numberOfMonthWorking) {
		int tax;
		int numberOfChildren = getNumberOfChildren(person);

		checkMonthWorking(numberOfMonthWorking);

		return (int) Math.round(0.05 * (((getTotalIncome(salary)) * numberOfMonthWorking) - salary.getAnnualDeductible()
				- getTidakKenaPajak(person, numberOfChildren)));

	}

}
