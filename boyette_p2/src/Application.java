public class Application {

    public static void main(String[] args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000), saver2 = new SavingsAccount(3000);

        SavingsAccount.modifyInterestRate(.04);

        System.out.printf("This is a program which calculates the monthly balance for two savings accounts, then prints the new balance.\n\n");

        System.out.printf("For an annual interest rate of %.0f%%:\n", (SavingsAccount.getAnnualInterestRate()*100));

        System.out.printf("A savings account with a balance of $%,.02f, the balance after one month will be %,.02f.\n", saver1.getSavingsBalance(), (saver1.getSavingsBalance() + saver1.calculateMonthlyInterest()));
        System.out.printf("A savings account with a balance of $%,.02f, the balance after one month will be %,.02f.\n", saver2.getSavingsBalance(), (saver2.getSavingsBalance() + saver2.calculateMonthlyInterest()));

        SavingsAccount.modifyInterestRate(.05);

        System.out.printf("\nFor an annual interest rate of %.0f%%:\n", (SavingsAccount.getAnnualInterestRate()*100));

        System.out.printf("A savings account with a balance of $%,.02f, the balance after one month will be %,.02f.\n", saver1.getSavingsBalance(), (saver1.getSavingsBalance() + saver1.calculateMonthlyInterest()));
        System.out.printf("A savings account with a balance of $%,.02f, the balance after one month will be %,.02f.\n", saver2.getSavingsBalance(), (saver2.getSavingsBalance() + saver2.calculateMonthlyInterest()));
    }
}
