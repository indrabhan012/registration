package register.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import register.model.Registration;

public class RegistrationDAO {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/registrationdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Indar@28929";
    
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
 // Create
    public void addRegistration(Registration registration) {
        String query = "INSERT INTO Registration (Name, Email, DateOfBirth, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, registration.getName());
            ps.setString(2, registration.getEmail());
            ps.setString(3, registration.getDateOfBirth());
            ps.setString(4, registration.getPhoneNumber());
            ps.setString(5, registration.getAddress());
            ps.executeUpdate();
            System.out.println("Registration added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Read
    public List<Registration> getRegistrations() {
        List<Registration> registrations = new ArrayList<>();
        String query = "SELECT * FROM Registration";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Registration registration = new Registration();
                registration.setId(rs.getInt("ID"));
                registration.setName(rs.getString("Name"));
                registration.setEmail(rs.getString("Email"));
                registration.setDateOfBirth(rs.getString("DateOfBirth"));
                registration.setPhoneNumber(rs.getString("PhoneNumber"));
                registration.setAddress(rs.getString("Address"));
                registrations.add(registration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrations;
    }

 // Update
    public void updateRegistration(Registration registration) {
        String query = "UPDATE Registration SET Name = ?, Email = ?, DateOfBirth = ?, PhoneNumber = ?, Address = ? WHERE ID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, registration.getName());
            ps.setString(2, registration.getEmail());
            ps.setString(3, registration.getDateOfBirth());
            ps.setString(4, registration.getPhoneNumber());
            ps.setString(5, registration.getAddress());
            ps.setInt(6, registration.getId());
            ps.executeUpdate();
            System.out.println("Registration updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Delete
    public void deleteRegistration(int id) {
        String query = "DELETE FROM Registration WHERE ID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Registration deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
