package com.klu.MarketMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import com.klu.MarketBean.MarketBean;
import com.klu.MarketConnections.MarketDBUtil;
import com.klu.MarketInsert.MarketInsertion;


public class MarketMain {
	
	private static Scanner sc;

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		
		MarketBean ab = new MarketBean();
		MarketInsertion cd = new MarketInsertion();
		sc = new Scanner(System.in);
		String choice = null;
		do
		{
			System.out.println("Market Operations");
			System.out.println("1.Insertion");
			System.out.println("2.Display");
			System.out.println("3.Total Cost");
			System.out.println("Enter an number to perform Operation : ");
			int ch = sc.nextInt();
			switch(ch)
			{
				case 1 :  System.out.println("Insertion");
				 		  System.out.println("Enter itemid : ");
				 		  int id = sc.nextInt();
				 		  ab.setItemid(id);
				 		  System.out.println("Enter itemname : ");
				 		  String name = sc.next();
				 		  ab.setIteamname(name);
				 		  System.out.println("Enter itemcost : ");
				 		  int cost = sc.nextInt();
				 		  ab.setIteamCost(cost);
				 		  int i = cd.MarketInsert(ab);
				 		  if(i>0)
				 		  {
				 			  System.out.println("Ur insertion is successfull");
				 		  }
				 		  else
				 		  {
				 			  System.out.println("Ur insertion is failed");
				 		  }
				 		  break;
				 		  
				case 2 : System.out.println("Display of items");
						 cd.Items_Display();
						 break;
						 
				case 3 : System.out.println("Total Cost of items");
						 cd.items_totalCost();
				  		 break;
				  		 
				default : System.exit(0);
			}
			System.out.println("Enter your choice to repeat the Market operation [ Yes/No ] : ");
			choice = sc.next();
		}
		while(choice.equals("Yes"));
	}
}
