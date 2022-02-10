package com.simran.emp;
import java.util.*;

import org.springframework.context.ApplicationContext;
public class LoginAdmin {

	public static void menu(ApplicationContext ac) {
		Scanner input = new Scanner(System.in);
		String userName;
		String password;
		do {
			System.out.print("Enter Admin User Name: ");
			userName = input.next();
			System.out.print("Enter Password: ");
			password = input.next();
			if(userName.equals("admin") && password.equals("admin"))
				break;
			else
				System.out.println("Invalid Credentials!");
		}while( true);
		AdminClient.menu(ac);
		input.close();
	}
}
