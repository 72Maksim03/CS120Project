import cli.BankConsole;
import user.User;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("2548", "Bob", "bob@example.com", "+3744567890");
        User user2 = new User("1002", "Emma", "emma@example.com", "+1987654321");

        System.out.println("User 1 details:");
        System.out.println(user1);

        System.out.println("\nUser 2 details:");
        System.out.println(user2);

        BankConsole bankConsole = new BankConsole();
        bankConsole.start();
    }
}
