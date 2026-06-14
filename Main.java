package Main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Message> sentMessages = new ArrayList<>();
    static ArrayList<Message> storedMessages = new ArrayList<>();
    static ArrayList<Message> disregardedMessages = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("\nWelcome to QuickChat");
            System.out.println("1) Send Message");
            System.out.println("2) Show Recently Sent Messages");
            System.out.println("3) Quit");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("Enter recipient (+27...): ");
                String recipient = input.nextLine();

                System.out.print("Enter message: ");
                String text = input.nextLine();

                if (text.length() > 250) {
                    System.out.println("Message exceeds 250 characters.");
                    continue;
                }

                Message msg = new Message(recipient, text);

                System.out.println("\nChoose option:");
                System.out.println("1 Send");
                System.out.println("2 Disregard");
                System.out.println("3 Store");

                int action = input.nextInt();

                if (action == 1) {
                    sentMessages.add(msg);
                    System.out.println(msg.sendMessage());

                } else if (action == 2) {
                    disregardedMessages.add(msg);
                    System.out.println("Message discarded.");

                } else if (action == 3) {
                    storedMessages.add(msg);
                    System.out.println("Message stored successfully.");
                }

                System.out.println("Message ID: " + msg.messageID);
                System.out.println("Hash: " + msg.messageHash);
                System.out.println("Recipient: " + msg.recipient);
                System.out.println("Message: " + msg.messageText);

            } else if (choice == 2) {

                System.out.println("\n--- SENT MESSAGES ---");

                for (Message m : sentMessages) {
                    System.out.println(m.messageText);
                }

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}

