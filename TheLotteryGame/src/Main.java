import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> winningNumbers = new ArrayList<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        List<Integer> guessedNumbers = new ArrayList<>();

        final int winningNumbersSize = 6;

        for(int i = 0; i < winningNumbersSize; i++)
        {
            while (true)
            {
                int winningNumber = random.nextInt(49) + 1;

                if(!winningNumbers.contains(winningNumber))
                {
                    winningNumbers.add(winningNumber);
                    break;
                }
            }
        }

        System.out.println("Please enter your six numbers between 1 and 49.");

        for(int i = 0; i < winningNumbersSize; i++)
        {
            System.out.println("Your current numbers are " + guessedNumbers);
            System.out.print("Please enter a number (1-49):");

            while (true)
            {
                try
                {
                    String numberString = scanner.nextLine();
                    int number = Integer.parseInt(numberString);

                    if(number >= 1 && number <= 49 && !guessedNumbers.contains(number))
                    {
                        guessedNumbers.add(number);
                        break;
                    }
                    else
                    {
                        System.out.print("Invalid Number, Guess a different number:");
                    }
                }
                catch (NumberFormatException ex)
                {
                    System.out.println("Invalid Input, Please enter number!");
                }
            }
        }

        System.out.println("The winning numbers were: " + winningNumbers);
        System.out.println("Your guessed numbers were: "+ guessedNumbers);

        guessedNumbers.retainAll(winningNumbers);
        System.out.println("Match numbers are: "+ guessedNumbers);

        if(guessedNumbers.containsAll(winningNumbers))
        {
            System.out.println("You've won the lottery!");
        }
        else
        {
            System.out.println("Sorry, you've lost!");
        }

        scanner.close();
    }
}