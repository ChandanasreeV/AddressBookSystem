package AddressBook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain2 {

    // Class to hold contact details
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

        @Override
        public String toString() {
            return firstName + " " + lastName + ", " + address + ", " + city + ", " +
                   state + ", " + zip + ", " + phoneNumber + ", " + email;
        }
    }

    // AddressBook class with delete logic
    static class AddressBook {
        private List<ContactPerson> contacts = new ArrayList<>();

        public void addContact(ContactPerson contact) {
            contacts.add(contact);
            System.out.println("Contact added successfully!");
        }

        public void deleteContact(String name) {
            Iterator<ContactPerson> iterator = contacts.iterator();
            boolean found = false;

            while (iterator.hasNext()) {
                ContactPerson contact = iterator.next();
                if (contact.getFirstName().equalsIgnoreCase(name)) {
                    iterator.remove();
                    found = true;
                    System.out.println("Contact deleted successfully!");
                    break;
                }
            }

            if (!found) {
                System.out.println("Contact not found.");
            }
        }

        public void displayContacts() {
            if (contacts.isEmpty()) {
                System.out.println("No contacts to display.");
            } else {
                for (ContactPerson contact : contacts) {
                    System.out.println(contact);
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
            System.out.println("2. Delete Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
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

                    ContactPerson contact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    addressBook.addContact(contact);
                    break;

                case 2:
                    System.out.print("Enter first name of contact to delete: ");
                    String nameToDelete = scanner.nextLine();
                    addressBook.deleteContact(nameToDelete);
                    break;

                case 3:
                    addressBook.displayContacts();
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

