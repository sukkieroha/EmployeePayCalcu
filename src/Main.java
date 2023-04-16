import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Employee(123456, "John", "Doe", 200, 1000, 2500, 1000),
                new Employee(234567, "Jane", "Doe", 18.75, 70, 2000, 800),
                new Employee(345678, "Bob", "Smith", 20, 75, 2200, 900),
        };
        Scanner input = new Scanner(System.in);

        int employeeNumber;
        String payCoverage;
        double hoursWorked;


        do {
            System.out.print("Please enter your Employee Number: ");
            try {
                employeeNumber = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid Employee Number.");
                employeeNumber = -1;
            }
        } while (employeeNumber == -1);

        do {
            System.out.print("Please enter your Pay Coverage (W or S): ");
            payCoverage = input.nextLine().toUpperCase();
            if (!(payCoverage.equals("W") || payCoverage.equals("S"))) {
                System.out.println("Invalid input. Please enter a valid Pay Coverage.");
                payCoverage = "";
            }
        } while (payCoverage.equals(""));

        System.out.print("Please enter the number of hours worked this week: ");
        try {
            hoursWorked = Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number of hours worked.");
            hoursWorked = -1;
        }

        double grossPay = 0, netPay = 0, totalDeduction = 0;

        for (Employee employee : employees) {
            if (employee.getEmployeeNumber() == employeeNumber) {
                if (payCoverage.equals("W")) {
                    grossPay = employee.WeeklyPay(hoursWorked);
                } else {
                    grossPay = employee.SemiMonthlyPay(hoursWorked);
                }

                double sssDeduction = employee.calculateSSSDeduction(grossPay);
                double philHealthDeduction = employee.calculatePhilHealthDeduction(grossPay);
                double pagIbigDeduction = employee.calculatePagIbigDeduction(grossPay);
                totalDeduction = employee.calculateTotalDeduction(sssDeduction,philHealthDeduction,pagIbigDeduction);
                double taxableIncome = employee.calculateTaxableIncome(grossPay,totalDeduction);
                double allowance = employee.calculateAllowance();
                grossPay = employee.calculateGrossPay(hoursWorked,allowance);
                netPay = employee.calculateNetPay(hoursWorked,grossPay, totalDeduction, taxableIncome);
                double tax = taxableIncome- netPay;

                System.out.println("Employee Details:");
                System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
                System.out.println("Employee Number: " + employee.getEmployeeNumber());
                System.out.println("Hourly Rate: " + employee.getHourlyRate());
                System.out.println("Rice Allowance: " + employee.getRiceAllowance());
                System.out.println("Phone Allowance: " + employee.getPhoneAllowance());
                System.out.println("Clothing Allowance: " + employee.getClothingAllowance());
                System.out.println("Gross Pay: " + employee.calculateGrossPay(hoursWorked, allowance));
                System.out.println("Deductions: " + employee.calculateTotalDeduction(sssDeduction, philHealthDeduction, pagIbigDeduction));
                System.out.println("Taxable Income:" + employee.calculateTaxableIncome(grossPay, totalDeduction));
                System.out.println("Tax:" + tax);
                System.out.println("Net Pay: " + employee.calculateNetPay(hoursWorked,allowance, totalDeduction,taxableIncome));

            }
        }
    }
}
