import java.util.Scanner;

public class TextReader {
    private Scanner scanner;
    
    public TextReader() {
        scanner = new Scanner(System.in);
    }
    
    public String readMessage() {
        System.out.print("> ");
        return scanner.nextLine();
    }
}
