package org.employee.employeemanagement.dao;

import org.employee.employeemanagement.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/manager_employee";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String birthDay = rs.getString("birthDay");
                String position = rs.getString("position");
                String department = rs.getString("department");

                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employee.setAddress(address);
                employee.setBirthDay(birthDay);
                employee.setPosition(position);
                employee.setDepartment(department);

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public void addEmp(Employee employee) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (name, email, country) VALUES (?, ?, ?)")) {


            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
