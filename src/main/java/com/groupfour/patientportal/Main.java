/* Patient Portal Capstone Project
 * BCS 430W - Mary Villani;
 * @Authors: Alexander Harmaty, Yasin Khan, Brian Noss, 
 * Christopher Scheer, Angela Todaro
 */
package com.groupfour.patientportal;

import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException { 
        
       String user = "pportal"; //database login user
       String pwd = "admin";    //database login password
       Scanner scan = new Scanner(System.in);

        boolean run = true;
        while (run) {
        //create while loop so menu keeps displaying 
        System.out.println("\t PATIENT PORTAL MENU");
        System.out.println("\t ----------------------");
        System.out.println("\t1 - View Patient Personal Information");
        System.out.println("\t2 - View Doctor Personal Information");
        System.out.println("\t3 - Insert/Update Patient Personal Information");
        System.out.println("\t4 - Insert/Update Doctor Personal Information");
        System.out.println("\t5 - Delete Patient Personal Information");
        System.out.println("\t6 - Quit the Application");
        System.out.println("Enter your choice: ");
        int choice = scan.nextInt();
        switch (choice) {
            
            case 1: //View Patient Personal Information
                    try {
                        System.out.println("Please enter your Patient ID: ");
                        String PatientID = scan.next();
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        //cant be cipher
                        Connection con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM PATIENT WHERE PatientID="+PatientID+";");
                        while (rs.next()) {
                            System.out.println("PATIENT ID: " + rs.getInt("PatientID"));
                            System.out.println("FIRST NAME: " + rs.getString("PFirstName"));
                            System.out.println("LAST NAME: " + rs.getString("PLastName"));
                            System.out.println("PHONE NUMBER: " + rs.getString("PPhone"));
                            System.out.println("EMAIL: " + rs.getString("PEmail"));
                            System.out.println("INSURANCE ID: " + rs.getInt("InsuranceID"));
                            System.out.println("INSURANCE COMPANY: " + rs.getString("Insurance"));
                            break;
                            //displays data. there must be a simpler way to implement
                        }
                        //return;
                    }
                    catch (Exception e) {
                      
                    }
                break;
                
            case 2: //View Doctor Personal Information
                    System.out.println("Please enter your Doctor ID: ");
                    String DocID = scan.next();
                    try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        //cant be cipher
                        Connection con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM DOCTOR WHERE DoctorID="+DocID+";");
                        while (rs.next()) {
                            System.out.println("DOCTOR ID: " + rs.getInt("DoctorID"));
                            System.out.println("FIRST NAME: " + rs.getString("DFirstName"));
                            System.out.println("LAST NAME: " + rs.getString("DLastName"));
                            System.out.println("PHONE NUMBER: " + rs.getString("DPhone"));
                            System.out.println("EMAIL: " + rs.getString("DEmail"));
                            System.out.println("DEGREE: " + rs.getString("Degree"));
                            System.out.println("SPECIALTY: " + rs.getString("Specialty"));

                            //displays data. there must be a simpler way to implement
                        } // End of while statement
                    } // End of try statement
                    catch (Exception e) {
                    } // End of catch
                        break;
                        
            case 3: //Insert/Update Patient Personal Information
                System.out.println("Enter PatientID:  ");
                int patientid = scan.nextInt(); //trying int
                scan.nextLine();
                System.out.println("Enter PFirstName:  ");
                String pfirstname = scan.nextLine();
                System.out.println("Enter PLastName:  ");
                String plastname = scan.nextLine();
                System.out.println("Enter PPhone:  ");
                String pphone = scan.nextLine();
                System.out.println("Enter PEmail:  ");
                String pemail = scan.nextLine();
                System.out.println("Enter InsuranceID:  ");
                int insuranceid = scan.nextInt(); //trying int
                scan.nextLine();
                System.out.println("Enter Insurance:  ");
                String insurance = scan.nextLine();
                
                String sql = "INSERT INTO PATIENT" + "(PatientID, PFirstName, PLastName, PPhone, PEmail, InsuranceID, Insurance)" + "values (?,?,?,?,?,?,?)";         
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
                PreparedStatement st = con.prepareStatement(sql);       
                //setting values
                st.setInt(1, patientid);
                st.setString(2, pfirstname);
                st.setString(3, plastname);
                st.setString(4, pphone);
                st.setString(5, pemail);
                st.setInt(6, insuranceid);
                st.setString(7, insurance);
                st.executeUpdate();

          //test
           System.out.println("Database updated successfully.");
           break;
           //while (rs.next()) {
           // System.out.println(rs.getString("DPhone"));   
           // }
            case 4: //Insert/Update Doctor Personal Information
                 System.out.println("Enter DoctorID:  ");
                int doctorid = scan.nextInt(); //trying int
                scan.nextLine();
                System.out.println("Enter DFirstName:  ");
                String dfirstname = scan.nextLine();
                System.out.println("Enter DLastName:  ");
                String dlastname = scan.nextLine();
                System.out.println("Enter DPhone:  ");
                String dphone = scan.nextLine();
                System.out.println("Enter DEmail:  ");
                String demail = scan.nextLine();
                System.out.println("Enter Degree:  ");
                String degree = scan.nextLine(); //trying int
                System.out.println("Enter Specialty:  ");
                String specialty = scan.nextLine();
                
                String sql2 = "INSERT INTO DOCTOR" + "(DoctorID, DFirstName, DLastName, DPhone, DEmail, Degree, Specialty)" + "values (?,?,?,?,?,?,?)";         
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
                st = con.prepareStatement(sql2);       
                //setting values
                st.setInt(1, doctorid);
                st.setString(2, dfirstname);
                st.setString(3, dlastname);
                st.setString(4, dphone);
                st.setString(5, demail);
                st.setString(6, degree);
                st.setString(7, specialty);
                
                st.executeUpdate();

           System.out.println("Database updated successfully.");
           break;
           
            case 5: //Delete a patients information
                System.out.println("Enter PatientID:  ");
                patientid = scan.nextInt(); //trying int
                scan.nextLine();
                String sql3 = "DELETE FROM PATIENT WHERE PatientID=" + patientid;         
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
                st = con.prepareStatement(sql3);
                st.executeUpdate();

                System.out.println("Database updated successfully.");
                break;
                
            case 6://Quit application
                System.out.println("Die.");
                System.exit(0);
                break;
                
            default:
                
    } // End of switch statement
    } // End of while statement
    } // End of private static void #1

    private static void printData(String username, String password) throws ClassNotFoundException, SQLException {
     Connection con = null;
    // PreparedStatement ps = null;
    // ResultSet rs = null;
     String user = "pportal";
     String pwd = "admin";
     String query = "SELECT * FROM DOCTOR WHERE username = pportal AND password = admin";
     try{
         con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
         PreparedStatement ps = con.prepareStatement(query);

         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM DOCTOR");
         while (rs.next()) {
             System.out.println(rs.getString("DoctorID"));
            }  // End of while statement
        } // End of try statement
     catch (Exception e) {
        System.out.println("An error occurred");
         //if (rs != null)
           //  rs.close();
         //ps.close();
         //con.close();
        } // End of Catch statement
} // End of private static void #2
} //End of Main
//Yasin