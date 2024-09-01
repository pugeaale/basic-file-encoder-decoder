import java.util.Scanner;

public class Main {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int userOption = 0;
        do {
            displayMenu();
            userOption = getUserOption();
        } while( !checkUserOption(userOption) );

        if( userOption == 1 ) encodeFile();
        else if (userOption == 2) decodeFile();
        else sayGoodbye();
    }

    private static void sayGoodbye() {
        System.out.println("See you soon !");
    }

    private static void decodeFile() {
        System.out.print("Enter the path of the file to decode : ");
        scanner.nextLine();
    }

    private static void encodeFile() {
        System.out.print("Enter the path of the file to encode : ");
        scanner.nextLine();
    }

    private static void displayMenu() {
        System.out.println("""
                Welcome to the File Encoder/Decoder
                ====================================
                1. Encode a file....................
                2. Decode a file....................
                3. Exit
                ====================================
                """);
    }

    private static int getUserOption() {
        System.out.print(" Select an option : ");
        int in = scanner.nextInt();
        scanner.nextLine();
        return in;
    }

    private static boolean checkUserOption(int userOption) {
        if(userOption >= 1 && userOption <= 3)  return true;
        else return false;
    }
}
