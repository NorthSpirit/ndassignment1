package lt.viko.eif.mjurevicius.ndassignment1.service;

import java.io.IOException;
import java.util.Scanner;

public class ClientPaymentProcessor {

    public static boolean paymentProcess(float paymentSum) {
        boolean taskComplete = false;
        ClientConnectorUnconnector client = new ClientConnectorUnconnector();
        try {
            client.startConnection("127.0.0.1", 14241);
                String response = client.sendMessage("Connecting to payment system.");
                System.out.println("Server response: " + response);
                if (response.equals("Connection made.")) {
                    response = client.sendMessage("Payment sum: " + paymentSum);
                    System.out.println("Server response: " + response);
                    if (response.equals("Sum received, please input password.")) {
                        boolean allowContinue = true;
                        Scanner input = new Scanner(System.in);
                        String userInput = "";

                        while (allowContinue) {
                            userInput = input.nextLine();
                            response = client.sendMessage("Password: " + userInput);
                            System.out.println("Server response: " + response);
                            if (response.equals("Password correct.")) {
                                response = client.sendMessage("Confirming payment...");
                                System.out.println("Server response: " + response);
                                if (response.equals("Payment complete. Have a lovely day.")) {
                                    return true;
                                }
                                else{
                                    return false;
                                }
                            }
                            if (response.equals("Incorrect password. No more attempts remaining. Terminating.")) {
                                return false;
                            }
                        }
                    }
                    return false;
                }
                else {
                    client.sendMessage("Unsupported format.");
                    return false;
                }
        } catch (IOException ex) {
            System.out.println("Exception occurred: " + ex.getMessage());
            return  false;
        } finally{
            client.stopConnection();
        }
    }
}
