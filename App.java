import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       // System.out.println("hello wor");

        Scanner sc = new Scanner(System.in);
        System.out.print("> ");

       int data = sc.nextInt();
       System.out.println("나이는" + data + "살 입니다.");
    
       sc.close();
    }
}
