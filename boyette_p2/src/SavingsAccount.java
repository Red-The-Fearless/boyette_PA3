public class SavingsAccount
{
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double initialBalance)
    {
        savingsBalance = initialBalance;
    }

    public double calculateMonthlyInterest()
    {
        return (savingsBalance * (annualInterestRate / 12));
    }

    public static void modifyInterestRate(double newAnnualInterestRate)
    {
        annualInterestRate = newAnnualInterestRate;
    }

    public static double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    public double getSavingsBalance()
    {
        return savingsBalance;
    }
}