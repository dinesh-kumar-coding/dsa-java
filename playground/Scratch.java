import java.util.Scanner;

public class Scratch {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Hello, Striver!");

    int x = scanner.nextInt();
    System.out.println("Hey " + x);
    scanner.close();
  }
}