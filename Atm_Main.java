package banking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Atm_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int inr = 10;
		while(true) {
			System.out.println("Welcome to ATM");
			System.out.println("------------------------------------");
			System.out.println("Press 1 Administration LogIn");
			System.out.println("Press 2 for ATM Services");
			int scr=Integer.parseInt(br.readLine());
			System.out.println("------------------------------------");
			if(scr==1) {
			 while(true){
				System.out.println("Press 1 to load ATM(Administrators only)");
				System.out.println("Press 2 to Check User Details(Administrators only)");
				System.out.println("Press 0 to Exit");
				int adm=Integer.parseInt(br.readLine());
			if(adm==1) {
			System.out.println("Enter Denomination: ");
			int den=Integer.parseInt(br.readLine());
			System.out.println("Enter Numbers: ");
			int num=Integer.parseInt(br.readLine());
			System.out.println("Total value is : ");
			int tot=den*num;
			System.out.println(tot);
			cash lCash=new cash(den,num,tot);
			boolean ans=load_cash.load(lCash);
			if(ans) {
				System.out.println("Cash updated successfully");
				System.out.println("Cash: "+lCash);
				
			}
		}
		else if(adm==2) {
			cus_details.cus();
			break;
		}
		else if(adm==0) {
			break;
		}
		}
		}
			else if (scr==2) {
			    boolean checker=false;
			    String accountString;
			    String pinString;
			    int n=3;
			    
				while(n>-1) {
					System.out.println("Enter account number :");
					 accountString=br.readLine();
					System.out.println("Enter password :");
					 pinString=br.readLine();
					if(Atm_process.security(accountString, pinString)) {
						System.out.println("Account is logged In");
						checker=true;
						System.out.println("------------------------------------");
						
					}else {
						System.out.println("Wrong Account no or Wrong pin you got "+n+" tries left");
						System.out.println("Try Again....");
						n--;
						System.out.println("-------------------------------------");
					}
				while(checker) {
					System.out.println("Enter 1 to check balance");
					System.out.println("Enter 2 to Withdraw");
					System.out.println("Enter 3 to Transfer cash");
					System.out.println("Enter 4 for ATM Balance");
					System.out.println("Enter 0 to exit");
				    inr=Integer.parseInt(br.readLine());
					if(inr==1) {
						Atm_process.checkBalance(accountString);
					}
					else if(inr==2) {
						System.out.println("Enter the amount you want to WithDraw :");
						String amounntString=br.readLine();
						n=3;
						while(n>-1) {
							System.out.println("Enter the Pin");
							String pincString=br.readLine();
						if(pincString.equals(pinString)) {
						Atm_process.withDraw(accountString, amounntString);
						break;
						}else {
							System.out.println("Wrong pin Try Again "+n+" tries left");
							n--;
						}
						}
					}
					else if(inr==3) {
						System.out.println("Enter the Transfer Account No :");
						String recString=br.readLine();
						System.out.println("Enter the amount to be Transferred :");
						String amounntString=br.readLine();
						n=3;
						while(n>-1) {
							System.out.println("Enter the Pin");
							String pincString=br.readLine();
						if(pincString.equals(pinString)) {
						Atm_process.transfer(accountString, recString, amounntString);
						break;
						}else {
							System.out.println("Wrong pin Try Again "+n+" tries left");
							n--;
						}
						}
					}
					else if(inr==4) {
						load_cash.balance();
						
					}else if(inr==0) {
						System.out.println("ThankYou For Banking With Us");
						System.out.println("--------------------------------------");
						break;
					}
				}
				if(inr==0) break;
				}
				
			}
			
		}
		
	}

}
//create table customerB(a_n int,a_h varchar2(20),pin int,a_b int);
