package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private Person personInfo;

	private LocalDate joinDate;

	private Salary salary;

	public Employee(String employeeId, Person personInfo, LocalDate joinDate) {
		super();
		this.employeeId = employeeId;
		this.personInfo = personInfo;
		this.joinDate = joinDate;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public int getAnnualIncomeTax() {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		int monthWorkingInYear;

		if (date.getYear() == joinDate.getYear()) {
			monthWorkingInYear = date.getMonthValue() - joinDate.getMonthValue();
		} else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(salary.getMonthlySalary(), salary.getOtherMonthlyIncome(), monthWorkingInYear,
				salary.getAnnualDeductible(), personInfo.getSpouse() == null, personInfo.getChildren().size());
	}
}
