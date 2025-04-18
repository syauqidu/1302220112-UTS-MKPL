package lib;

public class Grade3Salary implements SalaryGrade {
    private static final int BASE_SALARY = 7000000;

    @Override
    public int calculateSalary(Person person) {
        if (person.isForeigner()) {
            return (int) (BASE_SALARY * 1.5);
        }
        return BASE_SALARY;
    }
}
