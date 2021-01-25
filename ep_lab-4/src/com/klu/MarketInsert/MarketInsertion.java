package com.klu.MarketInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.klu.MarketBean.MarketBean;
import com.klu.MarketConnections.MarketDBUtil;


public class MarketInsertion {
	public int MarketInsert(MarketBean market) throws ClassNotFoundException, SQLException {
		Connection con=MarketDBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("insert into market values(?,?,?)");  
		ps.setInt(1,market.getItemid());
		ps.setString(2,market.getIteamname());
		ps.setInt(3,market.getIteamCost());
		int i = ps.executeUpdate();
		con.close();
		return i;
		
		
	}
	
	public void Items_Display() throws  ClassNotFoundException, SQLException {
		Connection con=MarketDBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("select * from market ");
		ResultSet display = (ResultSet) ps.executeQuery();
		System.out.println("itemid   iteamname   iteamCost");
		while(display.next()) {
			System.out.print(display.getInt(1));
			System.out.print("\t  "+display.getString(2));
			System.out.print("\t \t  "+display.getString(3));
		}
		con.close();
		
	}
	
	public void items_totalCost() throws ClassNotFoundException, SQLException{
		Connection con=MarketDBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("SELECT sum(itemcost) FROM market.market;");
		ResultSet display = (ResultSet) 
		ps.executeQuery();
		System.out.println("itemcost");
		int sum = 0;
		while(display.next()) {
			int c = display.getInt(1);
			sum = sum + c;
			System.out.println("Total Cost "+sum);
		}
		con.close();

}
}
