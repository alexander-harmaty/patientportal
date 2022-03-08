/* Patient Portal Capstone Project
 * BCS 430W - 
 * @Authors: Alexander Harmaty, Yasin Khan, Brian Noss, 
 * Christopher Scheer, Angela Todaro
 */
package com.groupfour.patientportal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException { 
        
       String user = "pportal";
       String pwd = "admin";
//        System.out.printf("Welcome to Patient Portal. \n");
        Scanner scan = new Scanner(System.in);
//        System.out.println("Please enter username:  ");
//        String username = scan.nextLine();
//        System.out.println("Username: " + username);
//        System.out.println("Please enter password:  ");
//        String password = scan.nextLine();
//        System.out.println("Password: " + password);
//        //printData(username, password);
//        
//        System.out.println("You have logged in successfully.\n");

        System.out.println("\t PATIENT PORTAL MENU");
        System.out.println("\t ----------------------");
        System.out.println("\t1 - View Patient Personal Information");
        System.out.println("\t2 - View Doctor Personal Information");
        System.out.println("\t3 - Insert/Update Patient Personal Information");
        System.out.println("\t4 - Insert/Update Doctor Personal Information");
        System.out.println("\t5 - Quit the Menu");
        System.out.println("Enter your choice: ");
        int choice = scan.nextInt();
        //int number = 0;
        boolean run = true;
        while (run) {
        //create while loop so menu keeps displaying    
        switch (choice) {
            case 1:
                
                    
                    try {
                        System.out.println("Please enter your Patient ID: ");
                    String PatientID = scan.next();
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        //cant be cipher
                        Connection con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM PATIENT WHERE PatientID="+PatientID+";");
                        while (rs.next()) {
                            System.out.println("PATIENTID: " + rs.getInt("PatientID"));
                            System.out.println("FIRSTNAME: " + rs.getString("PFirstName"));
                            System.out.println("LAST NAME: " + rs.getString("PLastName"));
                            System.out.println("PHONE NUMBER: " + rs.getString("PPhone"));
                            System.out.println("EMAIL: " + rs.getString("PEmail"));
                            System.out.println("INSURANCEID: " + rs.getInt("InsuranceID"));
                            System.out.println("INSURANCE COMPANY: " + rs.getString("Insurance"));
                            break;
                            //displays data. there must be a simpler way to implement
                        }
                        return;
                    }
                    
                    catch (Exception e) {
                    }
                    
                    //return;
                    
//            case 1:
//                 try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
//            
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM PATIENT");
//            System.out.printf("PATIENT - PERSONAL INFORMATION \n");
//            while (rs.next()) {
//            System.out.printf(rs.getString("PatientID") + " ");    
//            System.out.printf(rs.getString("PFirstName") + " "); //gets the first column's rows.
//            System.out.printf(rs.getString("PLastName") + " ");
//            System.out.printf(rs.getString("PPhone") + " ");
//            System.out.printf(rs.getString("PEmail") + " ");
//            System.out.printf(rs.getString("InsuranceID") + " ");
//            System.out.printf(rs.getString("Insurance") + " \n");    
//}
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//    }
                break;
            case 2:
                
                    System.out.println("Please enter your Doctor ID: ");
                    String DocID = scan.next();
                    try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        //cant be cipher
                        Connection con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM DOCTOR WHERE DoctorID="+DocID+";");
                        while (rs.next()) {
                            System.out.println(rs.getInt("DoctorID"));
                            System.out.println(rs.getString("DFirstName"));
                            System.out.println(rs.getString("DLastName"));
                            System.out.println(rs.getString("DPhone"));
                            System.out.println(rs.getString("DEmail"));
                            System.out.println(rs.getString("Degree"));
                            System.out.println(rs.getString("Specialty"));

                            //displays data. there must be a simpler way to implement
                        } // End of While Statement
                        
                    } // End of Try Statement
                    catch (Exception e) {
                    }
//                        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
//            
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM DOCTOR");
//            System.out.printf("DOCTOR - PERSONAL INFORMATION \n");
//            while (rs.next()) {
//            System.out.printf(rs.getString("DoctorID") + " ");    
//            System.out.printf(rs.getString("DFirstName") + " "); //gets the first column's rows.
//            System.out.printf(rs.getString("DLastName") + " ");
//            System.out.printf(rs.getString("DPhone") + " ");
//            System.out.printf(rs.getString("DEmail") + " ");
//            System.out.printf(rs.getString("Degree") + " ");
//            System.out.printf(rs.getString("Specialty") + " \n");    
//}
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//    }
                        break;
            case 3:
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
        
                
            case 4:    
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
           
            case 5:
                System.exit(0);
           
            default:
                
    } // End of Switch Choice    
    } // End of While Statement
    } // End of Public Static Voide
    
    private static void printData(String username, String password) throws ClassNotFoundException, SQLException {
     Connection con = null;
     //PreparedStatement ps = null;
    // ResultSet rs = null;
     String user = "pportal";
     String pwd = "admin";
     String query = "SELECT * FROM DOCTOR WHERE username = pportal AND password = admin";
     try{
         con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
         PreparedStatement ps = con.prepareStatement(query);
         
         //ps.setString(1, username);
         //ps.setString(2, password);
         //rs = ps.executeQuery();
         
       //need code for error upon login 
  
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM DOCTOR");
         while (rs.next()) {
             System.out.println(rs.getString("DoctorID"));
        } // End of while statement
        } // End of try statement
        catch (Exception e) {
            System.out.println("An error occurred");
             //if (rs != null)
               //  rs.close();
             //ps.close();
             //con.close();
     } // End of Catch Statement        
     
        //this will create a connection to the database
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
//            
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM DOCTOR");
//            System.out.printf("DOCTOR - PERSONAL INFORMATION \n");
//            while (rs.next()) {
//            System.out.printf(rs.getString("DoctorID") + " ");    
//            System.out.printf(rs.getString("DFirstName") + " "); //gets the first column's rows.
//            System.out.printf(rs.getString("DLastName") + " ");
//            System.out.printf(rs.getString("DPhone") + " ");
//            System.out.printf(rs.getString("DEmail") + " ");
//            System.out.printf(rs.getString("Degree") + " ");
//            System.out.printf(rs.getString("Specialty") + " \n");    
//}
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//    }
//        
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
//            
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM PATIENT");
//            System.out.printf("PATIENT - PERSONAL INFORMATION \n");
//            while (rs.next()) {
//            System.out.printf(rs.getString("PatientID") + " ");    
//            System.out.printf(rs.getString("PFirstName") + " "); //gets the first column's rows.
//            System.out.printf(rs.getString("PLastName") + " ");
//            System.out.printf(rs.getString("PPhone") + " ");
//            System.out.printf(rs.getString("PEmail") + " ");
//            System.out.printf(rs.getString("InsuranceID") + " ");
//            System.out.printf(rs.getString("Insurance") + " \n");    
//}
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//    }
        
//         try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://24.189.211.114:1433;databaseName=PatientPortal;encrypt=true;trustServerCertificate=true;", user, pwd);
//            
//            PreparedStatement st = con.prepareStatement("UPDATE DOCTOR SET DPHONE=? WHERE DoctorID=?");
//           // ResultSet rs = st.executeQuery("UPDATE DOCTOR SET DPHONE=631-999-3488 WHERE DoctorID = 10001");
//           st.setString(1, "800-583-3742");
//           st.setInt(2, 10001);
//           st.executeUpdate();
//           System.out.println("Database updated successfully.");
//           //while (rs.next()) {
//           // System.out.println(rs.getString("DPhone"));   
//}           
//       // }
//        catch(Exception e) {
//            e.printStackTrace();
//    }      
} // End of private static void
} //End of Main