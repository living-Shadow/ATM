package banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class load_cash {
	public static boolean load(cash c) {
		boolean f=false;
		try {
			Connection con=connect.con();
			String query="insert into cash(de,num,val) values(?,?,?)";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1,c.getDenomination());
			psmt.setInt(2,c.getNumber());
			psmt.setInt(3,c.getValue());
			psmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			//System.out.println(e);
		}
		return f;
	}
	public static boolean balance() {
		boolean f=false;
		try {
			Connection connection=connect.con();
			String queryString="Select * from cash";
			Statement stmtStatement=connection.createStatement();
			ResultSet rSet=stmtStatement.executeQuery(queryString);
			System.out.println("Denomination      numbers      values");
			System.out.println("-----------------------------------------");
			int total=0;
			while(rSet.next()) {
				int deno=rSet.getInt(1);
				int num=rSet.getInt(2);
				int value=rSet.getInt(3);
				System.out.format("%5s %15s %18s",deno,num,value);
				System.out.println();
				total+=value;
			}
			f=true;
			System.out.println("-----------------------------------------------");
			System.out.println("The Total Amount Available in the ATM :"+total);
			System.out.println("-----------------------------------------------");
			
		} catch (Exception e) {
			//System.out.println(e);
		}
		return f;
	}
}
