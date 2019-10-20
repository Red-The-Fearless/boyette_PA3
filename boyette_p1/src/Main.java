import java.security.SecureRandom;
import java.util.Scanner;


public class Main
{

    public static Scanner scan = new Scanner(System.in);
    public static SecureRandom secRandGen = new SecureRandom();

    public static int[] questionGenerator(int choice, int range, int i)
    {
        int quesNum[] = new int[3];
        quesNum[0] = secRandGen.nextInt(range - 1) + 1;
        quesNum[1] = secRandGen.nextInt(range - 1) + 1;
        quesNum[2] = choice;

        System.out.print(i + ". ");

        switch(quesNum[2])
        {
            case 1:
                System.out.print("What is " + quesNum[0] + " plus " + quesNum[1] + "? ");
                break;

            case 2:
                System.out.print("What is " + quesNum[0] + " minus " + quesNum[1] + "? ");
                break;

            case 3:
                System.out.print("What is " + quesNum[0] + " times " + quesNum[1] + "? ");
                break;

            case 4:
                System.out.print("What is " + quesNum[0] + " divided by " + quesNum[1] + "? ");
                break;

            case 5:
                quesNum[2] = secRandGen.nextInt(4) + 1;

                switch(quesNum[2])
                {
                    case 1:
                        System.out.print("What is " + quesNum[0] + " plus " + quesNum[1] + "? ");
                        break;

                    case 2:
                        System.out.print("What is " + quesNum[0] + " minus " + quesNum[1] + "? ");
                        break;

                    case 3:
                        System.out.print("What is " + quesNum[0] + " times " + quesNum[1] + "? ");
                        break;

                    case 4:
                        System.out.print("What is " + quesNum[0] + " divided by " + quesNum[1] + "? ");
                        break;
                }

                break;
        }

        return quesNum;
    }

    public static int[] menu() throws InterruptedException
    {
        int answers[] = new int[2];

        do
        {
            System.out.println("The following menu lists different difficulties to practice.");
            System.out.println("Each difficulty will contain that number of digits.");
            System.out.println();
            System.out.println("1. Single Digit");
            System.out.println("2. Double Digit");
            System.out.println("3. Triple Digit");
            System.out.println("4. Quadruple Digit");
            System.out.println();

            System.out.print("Select an option by typing a number from 1-4 and pressing ENTER: ");
            answers[1] = scan.nextInt();

            System.out.println();
        }
        while(answers[1] > 4 || answers[1] < 1);

        do
        {
            System.out.println("This is a program created to assist a student in practicing arithmetic.");
            System.out.println("The following menu lists different arithmetic operations to practice:");
            System.out.println();
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. All");
            System.out.println();

            System.out.print("Select an option by typing a number from 1-5 and pressing ENTER: ");
            answers[0] = scan.nextInt();

            System.out.println();
        }
        while(answers[0] > 5 || answers[0] < 1);

        return answers;
    }


    public static boolean checkAns(int choice, int[] quesNum, double ans)
    {
        switch (quesNum[2])
        {
            case 1:
                if((quesNum[0] + quesNum[1]) == ans)
                    return true;
                else
                    return false;

            case 2:
                if((quesNum[0] - quesNum[1]) == ans)
                    return true;
                else
                    return false;

            case 3:
                if((quesNum[0] * quesNum[1]) == ans)
                    return true;
                else
                    return false;


            case 4:
                if((((double)quesNum[0] / quesNum[1]) < ans - .01) || (((double)quesNum[0] / quesNum[1]) > ans + .01))
                    return false;
                else
                    return true;
        }
        return false;
    }

    public static void correctAns()
    {
        int rand = secRandGen.nextInt(4) + 1;

        switch(rand)
        {
            case 1:
                System.out.println("Very good, you got it right!");
                System.out.println();
                return;

            case 2:
                System.out.println("Excellent, you are doing great!");
                System.out.println();
                return;

            case 3:
                System.out.println("Nice work, I knew you could do it!");
                System.out.println();
                return;

            case 4:
                System.out.println("Keep up the good work!");
                System.out.println();
                return;
        }
    }

    public static void incorrectAns()
    {
        int rand = secRandGen.nextInt(4) + 1;

        switch(rand)
        {
            case 1:
                System.out.println("Your answer is incorrect, but have faith!");
                System.out.println();
                return;

            case 2:
                System.out.println("Wrong, but I know you can do it!");
                System.out.println();
                return;

            case 3:
                System.out.println("You didn't get it this time, but don't give up!");
                System.out.println();
                return;

            case 4:
                System.out.println("That is not right, keep trying!");
                System.out.println();
                return;
        }
    }

    public static void checkScore(int numCorrect)
    {
        System.out.println("You answered " + numCorrect + " out of 10 correctly!");
        if(numCorrect >= 8)
        {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
        else
        {
            System.out.println("You did well, but please ask your teacher for help!");
        }
        return;
    }

    public static int runGame(int[] choice)
    {
        int quesNum[] = new int[3];
        int range = (int) Math.pow(10.0, choice[1]), numCor = 0;
        double ans;

        System.out.println("Please answer the following 10 questions.");
        System.out.println();


        for(int i = 0; i < 10; i++)
        {
            quesNum = Main.questionGenerator(choice[0], range, (i+1));
            ans = scan.nextDouble();
            if (Main.checkAns(choice[0], quesNum, ans)) {
                numCor += 1;
                Main.correctAns();
            } else {
                Main.incorrectAns();
            }
        }

        return numCor;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] menuOptions;
        int numCorrect;
        char cont;

        do
        {
            menuOptions = menu();

            numCorrect = Main.runGame(menuOptions);

            System.out.println();

            Main.checkScore(numCorrect);

            System.out.println();

            System.out.println("Do you want to play again? (Y/N)");
            cont = scan.next().charAt(0);
        }
        while(cont != 'n' && cont != 'N');

        return;
    }
}
