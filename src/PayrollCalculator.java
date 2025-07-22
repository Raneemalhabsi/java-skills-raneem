public class PayrollCalculator {
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate){
        if (hoursWorked < 0 || hourlyRate < 0){
            System.out.println("Invalid input: Negative");
            return 0.0;
        }
        double payroll= 0.0;
        switch(employeeType){
            case "FULL_TIME":
                if (hoursWorked <= 40){
                    payroll = hoursWorked * hourlyRate;
                }
                else{
                    double overtime = hoursWorked - 40;
                    payroll = (1.5 * overtime * hourlyRate) + (40 * hourlyRate);

                }
                break;

            case "PART_TIME":
                if (hoursWorked > 25){
                    System.out.println("Employee exceeded the part time limit!");
                    hoursWorked = 25;
                }
                payroll= hoursWorked * hourlyRate;
                break;
            case "CONTRACTOR":
                payroll=  hoursWorked * hourlyRate;
                break;
            case "INTERN":
                if (hoursWorked > 20){
                    System.out.println("Intern exceeded the time limit!");
                    hoursWorked = 20;
                }
                payroll = (0.8 * hourlyRate) * hoursWorked;
                break;
            default:
                System.out.println("Invalid employee type!");
                break;
        }
    return payroll;
    }

    public static double calculateTaxDeduction (double grossPay, boolean hasHealthInsurance) {
        double tax=0;
        if (grossPay > 0 && grossPay <=500){
            tax = 0.1 * grossPay;
        } else if (grossPay > 501 && grossPay <= 1000) {
            tax = 0.15 * grossPay;
        } else if(grossPay > 1001 && grossPay <= 2000){
            tax= 0.2 * grossPay;
        }else if(grossPay > 2000){
            tax = 0.25 * grossPay;
        }
        if (hasHealthInsurance){
            tax = tax - 50;
        }
        return tax;
    }

    public static void processPayroll(String[] employeeType, double[] hours, double[] rates, String [] names){
        int n = employeeType.length;
        double payTotal = 0.0;
        double highestPay = Double.MIN_VALUE;
        double lowestPay = Double.MAX_VALUE;
        int overtimeCounter = 0;
        String highestPayName ="";
        String lowestPayName ="";

        System.out.println("Payroll Report:");
        for (int i=0; i<n; i++){
            double gross = calculateWeeklyPay(employeeType[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(gross, true);
            double net = gross - tax;

            System.out.println("Employee: " + names[i]);
            System.out.println("Type: " + employeeType[i]);
            System.out.println("Hours Worked: " + hours[i]);
            System.out.println("Hourly Rate: $" + rates[i]);
            System.out.println("Gross Pay: $" + gross);
            System.out.println("Tax Deducted: $" + tax);
            System.out.println("Net Pay: $" + net);
            System.out.println("----------------------------------");

            payTotal += gross;
            if (gross > highestPay) {
                highestPay = gross;
                highestPayName = names[i];
            }

            if (gross < lowestPay) {
                lowestPay = gross;
                lowestPayName = names[i];
            }
            if (employeeType[i].equals("FULL_TIME") && hours[i] > 40) {
                overtimeCounter++;
            }
        }

        double averagePay = payTotal / n;

        System.out.println("\n--- Payroll Summary ---");
        System.out.println("Highest Paid: " + highestPayName + " ($" + highestPay + ")");
        System.out.println("Lowest Paid: " + lowestPayName + " ($" + lowestPay + ")");
        System.out.println("Average Gross Pay: $" + averagePay);
        System.out.println("Number of Employees with Overtime: " + overtimeCounter);
    }

    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "INTERN", "FULL_TIME", "CONTRACTOR"};
        double[] hours = {42, 20, 22, 38, 45};
        double[] rates = {20, 15, 10, 22, 30};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        processPayroll(types, hours, rates, names);


    }

}
