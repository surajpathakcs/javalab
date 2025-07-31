import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Server.Calc stub = (Server.Calc) Naming.lookup("rmi://localhost/calc");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.print("Choose operation (1 = multiply, 2 = divide): ");
        int choice = sc.nextInt();

        if (choice == 1)
            System.out.println("Result: " + stub.multiply(a, b));
        else if (choice == 2)
            System.out.println("Result: " + stub.divide(a, b));
        else
            System.out.println("Invalid choice");
    }
}
