import java.io.*;
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
        doDecoding(getFilePath());
    }

    private static void encodeFile() {
        doEncoding(getFilePath());
    }

    private static void doEncoding(String path) {
        File f = new File(path);
        try {
            System.out.println(f.getName());
            Scanner s = new Scanner(f);
            String encodedPath = "encoded_" + f.getName();
            FileWriter fw = null;
            try {
                fw = new FileWriter(encodedPath, true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while(s.hasNextLine()) {
                System.out.println("Encoding the file ...");
                String line = encrypt(s.nextLine());
                try {
                    fw.write(line+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            scanner.close();
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String encrypt(String s) {
        StringBuilder ciphertext = new StringBuilder(s);
        return ciphertext.reverse().toString();
    }

    private static String decrypt(String s) {
        StringBuilder plaintext = new StringBuilder(s);
        return plaintext.reverse().toString();
    }

    private static void doDecoding(String path) {
        File f = new File(path);
        try {
            System.out.println(f.getName());
            Scanner s = new Scanner(f);
            String encodedPath = "decoded_" + f.getName();
            FileWriter fw = null;
            try {
                fw = new FileWriter(encodedPath, true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while(s.hasNextLine()) {
                System.out.println("Decoding the file ...");
                String line = decrypt(s.nextLine());
                try {
                    fw.write(line+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getFilePath() {
        System.out.print("Enter the path of the file : ");
        return scanner.nextLine();
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
