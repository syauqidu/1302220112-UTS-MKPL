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

	// Menghitung berapa lama pegawai bekerja dalam setahun ini
	public int getMonthWorking() {
		LocalDate date = LocalDate.now();
		if (date.getYear() == joinDate.getYear()) {
			return date.getMonthValue() - joinDate.getMonthValue();
		} else {
			return 12;
		}
	}

	//Menhitung Annual Tax seorang employee
	public int getAnnualIncomeTax() {
		int monthWorkingInYear = getMonthWorking();
		return TaxFunction.calculateTax(personInfo, salary, monthWorkingInYear);
	}
}
