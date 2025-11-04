import java.util.Scanner;

public class InputReader {
    private Scanner scanner;
    
    public InputReader() {
        scanner = new Scanner(System.in);
    }
    
    public int readMessage() {
        System.out.print("> ");
        return scanner.nextInt();
    }
}
