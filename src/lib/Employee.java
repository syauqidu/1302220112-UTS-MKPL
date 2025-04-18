package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private Person personInfo;

	private int yearJoined;
	private int monthJoined;
	private int dayJoined;
	private int monthWorkingInYear;

	private Salary salary;

	public Employee(String employeeId, Person personInfo, int yearJoined, int monthJoined, int dayJoined,
			int monthWorkingInYear) {
		super();
		this.employeeId = employeeId;
		this.personInfo = personInfo;
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
		this.dayJoined = dayJoined;
		this.monthWorkingInYear = monthWorkingInYear;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public int getAnnualIncomeTax() {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		} else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(salary.getMonthlySalary(), salary.getOtherMonthlyIncome(), monthWorkingInYear,
				salary.getAnnualDeductible(), personInfo.getSpouse() == null, personInfo.getChildren().size());
	}
}
