import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<Integer> myList = new LinkedList<>();
    private static int actionsMade = 0;
    private static int smallest;
    private static int largest;
    private static int average;
    private static String option = "";
    private final static String END = "end";
    private final static String LARGEST = "largest";
    private final static String SMALLEST = "smallest";
    private final static String AVERAGE = "average";



    public static void main(String[] args) {
        greet();
        askUser();
    }

    private static void askUser(){
        Scanner scanner = new Scanner(System.in);

        while (!option.equals(END)){
            option = scanner.nextLine();
            menu(option.toLowerCase());
        }
    }

    private static void greet(){
        System.out.println("You can type at any given time:\n" +
                "1. \"smallest\" to get the smallest number it has encountered so far\n" +
                "2. \"largest\" to get the largest number it has encountered so far\n" +
                "3. \"average\" to get the average of all numbers it has encountered so far\n" +
                "4. any number you want to offer\n" +
                "5. \"end\" to end the application");
    }

    private static void addNumber(int number){
        actionsMade++;
        if(actionsMade == 1){
          smallest = number;
          largest = number;
          myList.add(number);
        } else if(number < smallest){
           smallest = number;
           myList.add(number);
        } else if(number > largest ){
            largest = number;
            myList.add(number);
        }else {
            myList.add(number);
        }
    }

    private static void returnSmallest(){
        if(actionsMade == 0){
            System.out.println("Please type a number first");
        }else {
            System.out.println("Smallest number: " + smallest);

        }
    }

    private static void returnLargest(){
        if(actionsMade == 0){
            System.out.println("Please type a number first");
        } else {
            System.out.println("Largest number: " + largest);
        }
    }

    private static void returnAverage(){
        int totalValue = 0;
        for(int currentNumber : myList){
            totalValue += currentNumber;
        }
        try {
            average = totalValue / myList.size();
            System.out.println("The average is: " + average);
        }catch (ArithmeticException e){
            System.out.println("Please type a number first");
        }
    }

    private static void menu(String option){
        switch (option){
            case SMALLEST:
                returnSmallest();
                break;
            case LARGEST:
                returnLargest();
                break;
            case AVERAGE:
                returnAverage();
                break;
            case END:
                System.out.println("Goodbye");
                break;
            default:
                try {
                    String[] splitOption = option.split(" ");
                    for(int i = 0; i < splitOption.length; i++){
                        addNumber(Integer.valueOf(splitOption[i]));
                    }
                }catch (NumberFormatException e){
                    System.out.println("=================================");
                    System.out.println("Error, be more careful next time.");
                    greet();
                }
            break;
        }
    }




}
