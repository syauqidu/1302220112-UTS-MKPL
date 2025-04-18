package lib;

public class Salary {
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;

	public Salary(int monthlySalary, int otherMonthlyIncome, int annualDeductible) {
		this.monthlySalary = monthlySalary;
		this.otherMonthlyIncome = otherMonthlyIncome;
		this.annualDeductible = annualDeductible;
	}

	public int getMonthlySalary() {
		return monthlySalary;
	}

	public int getOtherMonthlyIncome() {
		return otherMonthlyIncome;
	}

	public int getAnnualDeductible() {
		return annualDeductible;
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	//Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
	public void setMonthlySalary(Person person, SalaryGrade salaryGrade) {
		this.monthlySalary = salaryGrade.calculateSalary(person);
	}

}
