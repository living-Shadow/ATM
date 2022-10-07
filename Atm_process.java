package banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Atm_process {
	public static boolean security(String accno,String pin) {
		boolean a=false;
		try {
			Connection connection=connect.con();
			Statement stmtStatement=connection.createStatement();
			String queryString="select pin,a_h from customerB where a_n="+accno;
			ResultSet rSet=stmtStatement.executeQuery(queryString);
			String pinn="";
			String nameString="";
			while(rSet.next()) {
		         pinn=rSet.getString(1);
		         nameString=rSet.getString(2);
			}
			if(pinn.equals(pin)) {
			a=true;
			System.out.println("Welcome "+nameString);
			}
			
		} catch (Exception e) {
		//	System.out.println(e);
		}
		return a;
	}
	public static boolean checkBalance(String accno) {
		boolean a=false;
		try {
			Connection connection=connect.con();
			Statement stmStatement=connection.createStatement();
			String queryString="select a_b from customerB where a_n="+accno;
			ResultSet rSet=stmStatement.executeQuery(queryString);
			String balString="";
			
			while(rSet.next()) {
			balString=rSet.getString(1);
			
			}
			System.out.println("Balance :"+balString);
			System.out.println("----------------------------------");
			a=true;
		} catch (Exception e) {
		//	System.out.println(e);
		}
		return a;
	}
	
	
	public static boolean withDraw(String accno,String amount) {
		boolean a=false;
		try {
			Connection connection=connect.con();
			Statement stmtStatement=connection.createStatement();
			String queryString="select a_b from customerB where a_n="+accno;
			ResultSet rSet=stmtStatement.executeQuery(queryString);
			int balString=0;
			while(rSet.next()) {
			balString=rSet.getInt(1);
			}
			int ammount=Integer.parseInt(amount);
			if(ammount>10000 && ammount<100) {
				System.out.println("The max limit is 10,000rs and min limit is 100");
			}else if(balString < ammount){
				System.out.println("Insufficient Balance");
			}else {
			    String cashString="select num from cash";
			    rSet=stmtStatement.executeQuery(cashString);
			    int t2000=0;
			    int t100=0;
			    int t500=0;
			    int arr[]=new int[3];
			    int i=0;
			    while(rSet.next()) {
			    	
			    	arr[i]=rSet.getInt(1);
			    	i+=1;
			    }
			    t2000=arr[0];
			    t500=arr[1];
			    t100=arr[2];
			    String qu100="",qu2000="",qu500="";
			    int track=ammount;
			    boolean check=false;
			    int f2000=0,f500=0,f100=0;
			    while(track!=0) {
				if(track<=5000) {
					if(track>=3000 && t2000>0) {
						t2000-=1;
						int t1=t2000*2000;
						qu2000="update cash set num="+t2000+",val="+t1+" where de=2000";
						track-=2000;
						f2000++;
					}
					else if(track>=1000 && t500>0) {
						t500-=1;
						int t2=t500*500;
						qu500="update cash set num="+t500+",val="+t2+" where de=500";
						track-=500;
						f500++;
					//	System.out.println(track);
					}
					else if(track>0 && t100>0) {
					track-=100;
					t100-=1;
					f100++;
					int	t3=t100*100;
						qu100="update cash set num="+t100+",val="+t3+" where de=500";
						
					}
				}
			    }
				if(track==0) {
					check=true;
				if(f2000>0) {	stmtStatement.executeUpdate(qu2000); }
				if(f500>0)	{stmtStatement.executeUpdate(qu500);}
				if(f100>0)	{stmtStatement.executeUpdate(qu100);}
					
				}else {
					System.out.println("Insufficient Balance in the ATM");
				}
				
			    if(check) {
				balString-=ammount;
				String remString=""+balString;
				String updatequery="update customerB Set a_b="+remString+" where a_n="+accno;
				stmtStatement.executeUpdate(updatequery);
				System.out.println("Amount WithDrawn Successfully");
				System.out.println("-------------------------------------");
			    }
			}
			
			a=true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return a;
	}
	public static boolean transfer(String accno,String senderaccno,String amount) {
		boolean a=false;
		try {
			Connection connection=connect.con();
			Statement stmtStatement=connection.createStatement();
			String queryString="select a_b from customerB where a_n="+accno;
			ResultSet rSet=stmtStatement.executeQuery(queryString);
			int balString=0;
			while(rSet.next()) {
			balString=rSet.getInt(1);
			}
			int recb=0;
			String recString="select a_b from customerB where a_n="+senderaccno;
			rSet=stmtStatement.executeQuery(recString);
			while(rSet.next()) {
				recb=rSet.getInt(1);
			}
			int ammount=Integer.parseInt(amount);
			if(ammount>10000 && ammount<100) {
				System.out.println("The max limit is 10,000rs and min limit is 100");
			}else if(balString < ammount){
				System.out.println("Insufficient Balance");
			}else {
				System.out.println("Your current balance is "+balString);
				balString-=ammount;
				String remString=""+balString;
				String updatequery="update customerB Set a_b="+remString+" where a_n="+accno;
				stmtStatement.executeUpdate(updatequery);
				recb+=ammount;
				String recIncString=""+recb;
				String uprecString="update customerB set a_b="+recIncString+" where a_n="+senderaccno;
				stmtStatement.executeUpdate(uprecString);
				System.out.println("Cash Transferred successfully..");
				System.out.println("Your current balance is "+remString+"Rs");
				System.out.println("------------------------------------------------");
			}
			
			a=true;
			
		} catch (Exception e) {
		//    System.out.println(e);
		}
		return a;
	}

}
