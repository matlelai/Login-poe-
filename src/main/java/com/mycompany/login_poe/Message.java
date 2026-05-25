package com.mycompany.login_poe;

import java.util.Scanner;
import java.util.UUID;
import javax.lang.model.SourceVersion;

public class Message {


    // --- Main Program ---
    public void run() {
        // Step 1: Create message and generate ID
        try (Scanner input = new Scanner(System.in)) {
            // Step 1: Create message and generate ID
            Messages msg = createMessage(input);
            
            // Step 2: Handle user choice
            handleMessageAction(input, msg);
        }
    }

    // --- Housekeeping: Message ID is created ---
    // Input: Message content from user
    // Output: Message object with ID, prints "Message ID generated: <Message ID>"
    public Messages createMessage(Scanner input) {
        System.out.print("Enter message content: ");
        String content = input.nextLine();
        
        String messageId = generateMessageId();
        System.out.println("Message ID generated: " + messageId);
        
        return new Messages(messageId, content);
    }

    // --- Processing: MessageSent ---
    // Additional test data: 3 choices
    // System returns different messages based on choice
    public void handleMessageAction(Scanner input, Messages msg) {
        int choice;
        
        do{
           System.out.println("\nWhat would you like to do?");
           System.out.println("1. Send Message");
           System.out.println("2. Disregard Message");
           System.out.println("3. Store Message");
           System.out.println("4. Quit");
           System.out.print("Enter choice: ");
       
        choice = input.nextInt();
        input.nextLine();
        
        switch (choice) {
            case 1 -> sendMessage(msg);
            case 2 -> disregardMessage();
            case 3 -> storeMessage(msg);
            case 4 -> System.out.println("Existing program...");
            default -> System.out.println("Invalid choice.");       
        }
        
    } while (choice != 4);
    }
    // --- End of Job Methods ---
    
    // Case 1: User selected 'Send Message'
    // The system should return: "Message successfully sent."
    public void sendMessage(Messages msg) {
        System.out.println("Message successfully sent.");
    }
    
    // Case 2: User selected 'Disregard Message'
    // The system should return: "Press 0 to delete the message."
    public void disregardMessage() {
        System.out.println("Press 0 to delete the message.");
    }
    
    // Case 3: User selected 'Store Message'
    // The system should return: "Message successfully stored."
    public void storeMessage(Messages msg) {
        System.out.println("Message successfully stored.");
    }

    // Helper method for generating ID
    private String generateMessageId() {
        return "MSG-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }
}

// --- Data Class ---
class Messages {
    private final String messageId;
    private final String content;

    public Messages(String messageId, String content) {
        this.messageId = messageId;
        this.content = content;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getContent() {
        return content;
    }
}
