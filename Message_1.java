/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

/**
 *
 * @author Student
 */
public class Message {

    public String messageID;
    public String recipient;
    public String messageText;
    public String messageHash;
    public String status;

    private static int messageCounter = 0;

    public Message(String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
        this.status = "";
    }

    public String generateMessageID() {
        return String.format("%010d", (int)(Math.random() * 1000000000));
    }

    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    public boolean checkRecipient() {
        return recipient.startsWith("+") && recipient.length() <= 10;
    }

    public String createMessageHash() {
        String[] words = messageText.split(" ");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2) + ":" + messageCounter + ":" + firstWord + lastWord;
    }

    public String sendMessage() {
        messageCounter++;
        return "Message successfully sent.";
    }

    public static int returnTotalMessages() {
        return messageCounter;
    }
}