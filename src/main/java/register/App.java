package register;

import java.util.Scanner;

import register.dao.RegistrationDAO;
import register.model.Registration;

public class App {

	public static void main(String[] args) {
		RegistrationDAO dao = new RegistrationDAO();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Add Registration");
			System.out.println("2. View All Registrations");
			System.out.println("3. Update Registration");
			System.out.println("4. Delete Registration");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				Registration registration = new Registration();
				System.out.print("Enter Name: ");
				registration.setName(scanner.next());
				System.out.print("Enter Email: ");
				registration.setEmail(scanner.next());
				System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
				registration.setDateOfBirth(scanner.next());
				System.out.print("Enter Phone Number: ");
				registration.setPhoneNumber(scanner.next());
				System.out.print("Enter Address: ");
				registration.setAddress(scanner.next());
				dao.addRegistration(registration);
				break;

			case 2:
				dao.getRegistrations().forEach(System.out::println);
				break;

			case 3:
				Registration updateReg = new Registration();
				System.out.print("Enter ID to update: ");
				updateReg.setId(scanner.nextInt());
				System.out.print("Enter Name: ");
				updateReg.setName(scanner.next());
				System.out.print("Enter Email: ");
				updateReg.setEmail(scanner.next());
				System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
				updateReg.setDateOfBirth(scanner.next());
				System.out.print("Enter Phone Number: ");
				updateReg.setPhoneNumber(scanner.next());
				System.out.print("Enter Address: ");
				updateReg.setAddress(scanner.next());
				dao.updateRegistration(updateReg);
				break;

			case 4:
				System.out.print("Enter ID to delete: ");
				int id = scanner.nextInt();
				dao.deleteRegistration(id);
				break;

			case 5:
				System.out.println("Exiting...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice! Try again.");

			}

		}
	}
	
}
