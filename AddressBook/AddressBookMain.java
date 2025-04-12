package AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    // ContactPerson class - holds contact details
    static class ContactPerson {
        private String firstName, lastName, address, city, state, zip, phoneNumber, email;

        public ContactPerson(String firstName, String lastName, String address, String city,
                             String state, String zip, String phoneNumber, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + ", " + address + ", " + city + ", " +
                   state + ", " + zip + ", " + phoneNumber + ", " + email;
        }
    }

    // AddressBook class - manages contacts
    static class AddressBook {
        private List<ContactPerson> contacts = new ArrayList<>();

        public void addContact(ContactPerson contact) {
            contacts.add(contact);
            System.out.println("Contact added successfully!");
        }

        public void displayContacts() {
            if (contacts.isEmpty()) {
                System.out.println("No contacts to display.");
            } else {
                for (ContactPerson c : contacts) {
                    System.out.println(c);
                }
            }
        }
    }

    // Main method - console interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to Address Book Program!");

        System.out.print("How many contacts do you want to add? ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Contact " + (i + 1) + ":");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("City: ");
            String city = scanner.nextLine();
            System.out.print("State: ");
            String state = scanner.nextLine();
            System.out.print("ZIP: ");
            String zip = scanner.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            ContactPerson contact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
            addressBook.addContact(contact);
        }

        System.out.println("\nAll Contacts:");
        addressBook.displayContacts();

        scanner.close();
    }
}
