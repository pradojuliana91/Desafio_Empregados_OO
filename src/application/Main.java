package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String nameDept = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        int dayPay = sc.nextInt();
        System.out.print("Email: ");
        sc.nextLine();
        String emailDept = sc.nextLine();
        System.out.print("Telefone: ");
        String phoneDept = sc.nextLine();

        Department department = new Department(nameDept, dayPay, new Address(emailDept, phoneDept));

        System.out.print("Quantos funcionários tem o departamento? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Dados do funcionário " + (i+1) + ": ");
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salário: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(name, salary);

            department.addEmployee(emp);
        }

        showReport(department);

        sc.close();
    }

    private static void showReport(Department department) {
        System.out.println("FOLHA DE PAGAMENTO: ");
        System.out.printf(String.valueOf(department));
        System.out.println("\nFuncionários: ");
        for (Employee emp : department.getEmployees()) {
            System.out.println(emp);
        }
        System.out.print("Para dúvidas favor entrar em contato: " + department.getAddress());
    }
}