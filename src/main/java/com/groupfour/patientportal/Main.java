/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Chris Was Here
 */
package com.groupfour.patientportal;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * @author Christopher
 */
public class Main 
{
  public static void main(String[] args) throws   FileNotFoundException 
  {
    boolean run = true; 
    Scanner in = new Scanner(System.in);
    while(run) 
    {
	  System.out.println("Patient Portal UI");
          System.out.println("------------------------------------");
	  System.out.println("What operation would you like to do?");
	  System.out.println("\t1) View Personal Information.");
	  System.out.println("\t2) Insert/Update Personal Information.");
	  System.out.println("\t3) Exit UI.");
	  
	  int ans = in.nextInt();
	  
	  switch(ans) {
	  case(1):
		  System.out.println("Printing out Patient.csv");     
     Scanner read = new Scanner(new File("patient.csv"));
     read.useDelimiter(":");
      //String inputFileName = read.nextLine();
      //FileReader fr = new FileReader(patient.csv);
      //Scanner input = new Scanner(file);
    
     while (read.hasNext()) { 
        System.out.print(read.next());
       };
      read.close();
        break;
	  case(2):
		  System.out.println("This Option is in development, try again.");
	  		break;
	  case(3):
		  System.out.println("die, pls.");
	  	  System.exit(0);
	  	  	break;
   }
  }
 }
}