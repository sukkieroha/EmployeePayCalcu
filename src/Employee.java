public class Employee {
    private int employeeNumber;
    private String firstName;
    private String lastName;
    private double hourlyRate;
    private double riceAllowance;
    private double phoneAllowance;
    private double clothingAllowance;
    private double sssDeduction;
    private double philHealthDeduction;
    private double pagIbigDeduction;
    private double totalDeduction;
    private double taxDeduction;
    private double allowance;

    public Employee(int employeeNumber, String firstName, String lastName,
                    double hourlyRate, double riceAllowance, double phoneAllowance,
                    double clothingAllowance) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
        this.riceAllowance = riceAllowance;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.totalDeduction = totalDeduction;
        this.taxDeduction = taxDeduction;
        this.allowance = allowance;
    }

    // Getters and setters
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getRiceAllowance() {
        return riceAllowance/4;
    }

    public void setRiceAllowance(double riceAllowance) {
        this.riceAllowance = riceAllowance;
    }

    public double getPhoneAllowance() {
        return phoneAllowance/4;
    }

    public void setPhoneAllowance(double phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance/4;
    }

    public void setClothingAllowance(double clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }
    public double WeeklyPay(double hoursWorked) {
        double weeklyPay = hoursWorked * hourlyRate;
        return weeklyPay;
    }

    public double SemiMonthlyPay(double hoursWorked) {
        double semiMonthlyPay = hoursWorked * hourlyRate;
        return semiMonthlyPay;
    }
    public double calculateGrossPay (double hoursWorked, double allowance){
        double grossPay = hoursWorked * hourlyRate + allowance;
        return grossPay;
    }
    public double calculateTotalDeduction(double sssDeduction,double philHealthDeduction, double pagIbigDeduction) {
         double totalDeduction = sssDeduction + philHealthDeduction+ pagIbigDeduction;
        return totalDeduction;
    }
    public double calculateTaxableIncome( double grossPay,double totalDeduction){
        double taxableIncome = grossPay - totalDeduction;
        return taxableIncome;
    }
    public double calculateAllowance() {

        double riceAllowance = 0;
        riceAllowance = riceAllowance / 4;
        double phoneAllowance=0;
        phoneAllowance= phoneAllowance /4;
        double clothingAllowance=0;
        clothingAllowance= clothingAllowance / 4;
        double allowance = riceAllowance + phoneAllowance + clothingAllowance;
        return allowance;
    }
    public double calculateNetPay(double hoursWorked, double grossPay, double totalDeduction, double taxableIncome) {
            grossPay = calculateGrossPay(hoursWorked, allowance);
            totalDeduction = calculateTotalDeduction(sssDeduction, philHealthDeduction, pagIbigDeduction);
            taxableIncome = grossPay - totalDeduction;

             taxDeduction = 0.0;
            if (taxableIncome > 0 && taxableIncome <= 10000) {
                taxDeduction = taxableIncome * 0.05;
            } else if (taxableIncome > 10000 && taxableIncome <= 20000) {
                taxDeduction = (taxableIncome - 10000) * 0.1 + 500;
            } else if (taxableIncome > 20000 && taxableIncome <= 35000) {
                taxDeduction = (taxableIncome - 20000) * 0.15 + 1500;
            } else if (taxableIncome > 35000 && taxableIncome <= 50000) {
                taxDeduction = (taxableIncome - 35000) * 0.2 + 4500;
            } else if (taxableIncome > 50000) {
                taxDeduction = (taxableIncome - 50000) * 0.25 + 9250;
            }

            double netPay = grossPay - totalDeduction - taxDeduction;
            return netPay;
        }

    // Calculate SSS Deduction
    public double calculateSSSDeduction(double grossPay) {

        double sssDeduction = 0.00;
        if (grossPay >= 1000.00 && grossPay <= 1249.99) {
            sssDeduction = 36.30;
        } else if (grossPay >= 1250.00 && grossPay <= 1749.99) {
            sssDeduction = 54.50;
        } else if (grossPay >= 1750.00 && grossPay <= 2249.99) {
            sssDeduction = 72.70;
        } else if (grossPay >= 2250.00 && grossPay <= 2749.99) {
            sssDeduction = 90.80;
        }
        return sssDeduction;
    }

    public double calculatePhilHealthDeduction(double grossPay) {
        double philHealthDeduction = grossPay * 0.02;
        return philHealthDeduction;
    }

    public double calculatePagIbigDeduction(double grossPay) {
        double pagIbigDeduction = grossPay * .02;
        return pagIbigDeduction;
    }
}



