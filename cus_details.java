package banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;

public class cus_details {
	public static boolean cus() {
		boolean s=false;
		try {
			Connection connection=connect.con();
			String query="select * from customerB";
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery(query);
			System.out.format("%5s %7s %6s %15s","Acc_No","ACC_Holder","Pin","ACC_Balance");
			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println();
			while(rs.next()) {
				int acc=rs.getInt(1);
				String holder=rs.getString(2);
				int pin=rs.getInt(3);
				int bal=rs.getInt(4);
				String acb=NumberFormat.getNumberInstance(new Locale("en","IN")).format(bal)+"Rs";
				System.out.format("%5s %8s %10s %11s",acc,holder,pin,acb);
				System.out.println();
			}
			s=true;
		} catch (Exception e) {
			//System.out.println(e);
		}
		return s;
	}

}
