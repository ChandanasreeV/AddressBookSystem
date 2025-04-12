package AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain1 {

    // ContactPerson class
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

        public String getFirstName() {
            return firstName;
        }

        public void updateDetails(Scanner scanner) {
            System.out.print("New Last Name: ");
            this.lastName = scanner.nextLine();
            System.out.print("New Address: ");
            this.address = scanner.nextLine();
            System.out.print("New City: ");
            this.city = scanner.nextLine();
            System.out.print("New State: ");
            this.state = scanner.nextLine();
            System.out.print("New ZIP: ");
            this.zip = scanner.nextLine();
            System.out.print("New Phone Number: ");
            this.phoneNumber = scanner.nextLine();
            System.out.print("New Email: ");
            this.email = scanner.nextLine();
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + ", " + address + ", " + city + ", " +
                   state + ", " + zip + ", " + phoneNumber + ", " + email;
        }
    }

    // AddressBook class
    static class AddressBook {
        private List<ContactPerson> contacts = new ArrayList<>();

        public void addContact(ContactPerson contact) {
            contacts.add(contact);
            System.out.println("Contact added successfully!");
        }

        public void editContact(String name, Scanner scanner) {
            for (ContactPerson contact : contacts) {
                if (contact.getFirstName().equalsIgnoreCase(name)) {
                    System.out.println("Editing contact: " + contact);
                    contact.updateDetails(scanner);
                    System.out.println("Contact updated successfully!");
                    return;
                }
            }
            System.out.println("Contact not found.");
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

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to Address Book Program!");

        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
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

                    ContactPerson newContact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    addressBook.addContact(newContact);
                    break;

                case 2:
                    System.out.print("Enter first name of contact to edit: ");
                    String nameToEdit = scanner.nextLine();
                    addressBook.editContact(nameToEdit, scanner);
                    break;

                case 3:
                    addressBook.displayContacts();
                    break;

                case 4:
                    System.out.println("Exiting Address Book. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

