package gui;

import java.sql.*;
import java.util.*;

public class BookApp {
	static Connection con;
	static PreparedStatement ps;
	static String url = "jdbc:mysql://localhost:3306/studentschema", username = "root", password = "admin",
			query = "Select * from studentt order by stdName";
	static Statement st;
	static ResultSet rs;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		try {

			ps = con.prepareStatement("insert into studentt(`stdName`,`stdProgram`,`stdGender`) values(?,?,?)");
			System.out.print("Enter Name: ");
			String stdName = input.nextLine();
			System.out.print("Enter Gender: ");
			String gn = input.nextLine();
			System.out.print("Enter Program: ");
			String pg = input.nextLine();

			ps.setString(1, stdName);
			ps.setString(2, gn);
			ps.setString(3, pg);
			ps.execute();
			ps.close();
			System.out.println("Data inserted Successfully");
			System.out.println();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

}
