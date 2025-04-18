package lib;

public class Grade2Salary implements SalaryGrade {
	private static final int BASE_SALARY = 5000000;

    @Override
    public int calculateSalary(Person person) {
        if (person.isForeigner()) {
            return (int) (BASE_SALARY * 1.5);
        }
        return BASE_SALARY;
    }
}
