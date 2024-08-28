package console;

import entity.Employee;
import java.util.List;
import java.util.Scanner;
import service.EmployeeService;

public class ConsoleApp {
    private static final EmployeeService service = new EmployeeService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management:");
            System.out.println("1. View all");
            System.out.println("2. View by ID");
            System.out.println("3. create ");
            System.out.println("4. update");
            System.out.println("5. delete");
            System.out.println("6. exit");

            System.out.print("angka: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewAllEmployees();
                case 2 -> viewEmployeeById();
                case 3 -> addNewEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> {
                    System.out.println("Exit");
                    System.exit(0);
                }
                default -> System.out.println("Invalid");
            }
        }
    }

    private static void viewAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        employees.forEach(System.out::println);
    }

    private static void viewEmployeeById() {
        System.out.print("masukkan ID: ");
        int id = scanner.nextInt();
        Employee employee = service.getEmployeeById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("takde.");
        }
    }

    private static void addNewEmployee() {
        System.out.print("masukkan ID: ");
        int id = scanner.nextInt();
        System.out.print("masukkan nama: ");
        String name = scanner.next();
        service.addEmployee(new Employee(id, name));
        System.out.println("mantap");
    }

    private static void updateEmployee() {
        System.out.print("masukkan ID: ");
        int id = scanner.nextInt();
        System.out.print("masukkan nama: ");
        String name = scanner.next();
        service.updateEmployee(new Employee(id, name));
        System.out.println("mantap");
    }

    private static void deleteEmployee() {
        System.out.print("masukkan ID");
        int id = scanner.nextInt();
        service.deleteEmployee(id);
        System.out.println("mantap");
    }
}
