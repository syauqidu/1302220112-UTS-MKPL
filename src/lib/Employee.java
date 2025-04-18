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

	public int getMonthWorking() {
		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		if (date.getYear() == joinDate.getYear()) {
			return date.getMonthValue() - joinDate.getMonthValue();
		} else {
			return 12;
		}
	}

	public int getAnnualIncomeTax() {
		int monthWorkingInYear = getMonthWorking();
		return TaxFunction.calculateTax(personInfo, salary, monthWorkingInYear);
	}
}
