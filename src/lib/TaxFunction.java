package lib;

public class TaxFunction {
	//Mengembalikan banyak anak yang harus ditanggung
	public static int getNumberOfChildren(Person person) {
		if (person.getChildren().size() > 3) {
			return 3;
		}
		return person.getChildren().size();
	}

	//Melakukan check apakah dia sudah bekerja lebih dari 1 tahun
	public static void checkMonthWorking(int numberOfMonthWorking) {
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
	}

	//Menghitung besarnya tidak kena pajak seseorang
	public static int getTidakKenaPajak(Person person, int numberOfChildren) {
		if (person.getSpouse() != null) {
			return (54000000 + 4500000 + (numberOfChildren * 1500000));
		} else {
			return 54000000;
		}
	}

	//Menghitung total semua pemasukkan dan gaji
	public static int getTotalIncome(Salary salary) {
		return salary.getMonthlySalary() + salary.getOtherMonthlyIncome();
	}

	
	 /* Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan */
	public static int calculateTax(Person person, Salary salary, int numberOfMonthWorking) {
		int tax;
		int numberOfChildren = getNumberOfChildren(person);

		checkMonthWorking(numberOfMonthWorking);

		return (int) Math.round(0.05 * ((getTotalIncome(salary) * numberOfMonthWorking) - salary.getAnnualDeductible()
				- getTidakKenaPajak(person, numberOfChildren)));

	}

}
