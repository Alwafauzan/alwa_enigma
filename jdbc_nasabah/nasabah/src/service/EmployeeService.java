package service;

import java.util.List;

import entity.Employee;
import repository.EmployeeRepository;

public class EmployeeService {
    private final EmployeeRepository repository = new EmployeeRepository();

    public List<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return repository.getEmployeeById(id);
    }

    public void addEmployee(Employee employee) {
        repository.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        repository.updateEmployee(employee);
    }

    public void deleteEmployee(int id) {
        repository.deleteEmployee(id);
    }
}
