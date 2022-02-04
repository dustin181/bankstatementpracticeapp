import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    protected String firstName, lastName;
    protected Integer yearlySalary;

}

@Data
class Manager extends Employee {

    private List<Employee> employees;

    @Builder
    public Manager(String firstName, String lastName, Integer yearlySalary, List<Employee> employees){
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearlySalary = yearlySalary;
        this.employees = employees;
    }


    public static void main(String[] args) {
        Employee employee1 = new Employee("Mike", "Smith", 30000);
        Employee employee2 = new Employee("Jake", "Johnson", 40000);
        Employee employee3 = new Employee("Rick", "Miller", 70000);
        Employee employee4 = new Employee("Carl", "Daniels", 80000);
        Employee employee5 = new Employee("Sally", "Stabler", 90000);
        Employee employee6 = new Employee("Carrie", "Washington", 40000);
        
        List<Employee> employeelist1 = List.of(employee1, employee2, employee6);
        List<Employee> employeelist2 = List.of(employee3, employee4, employee5);

        Manager manager1 = Manager.builder()
                .firstName("Jason")
                .lastName("Westin")
                .yearlySalary(0)
                .employees(employeelist1)
                .build();

        Manager manager2 = Manager.builder()
                .firstName("Abby")
                .lastName("Carol")
                .yearlySalary(0)
                .employees(employeelist2)
                .build();

        List<Employee> filteredListEmployees = List.of(manager1, manager2)
                .stream()
                .flatMap(x -> x.getEmployees().stream())
                .filter(x -> x.getFirstName().startsWith("C"))
                .sorted(Comparator.comparing(Employee::getYearlySalary))
                .collect(Collectors.toList());

        Integer salarySum = List.of(manager1, manager2)
                .stream()
                .flatMap(x -> x.getEmployees().stream())
                .filter(x -> x.getFirstName().startsWith("C"))
                .map(x -> x.getYearlySalary())
                .reduce(0, Integer::sum);

        Integer salarySum2 = List.of(manager1, manager2)
                .stream()
                .flatMap(x -> x.getEmployees().stream())
                .filter(x -> x.getFirstName().startsWith("C"))
                .map(x -> x.getYearlySalary())
                .mapToInt((x) -> x)
                .sum();

        filteredListEmployees.forEach(System.out::println);

        System.out.println("salary sum is: " + salarySum);
        System.out.println("salary sum is: " + salarySum2);
    }
}





