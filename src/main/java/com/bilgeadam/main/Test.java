package com.bilgeadam.main;

import java.util.ArrayList;
import java.util.List;

import com.bilgeadam.entity.Address;
import com.bilgeadam.entity.PhoneNumber;
import com.bilgeadam.entity.User;
import com.bilgeadam.entity.UserInformation;
import com.bilgeadam.service.UserService;

public class Test {

	public static void main(String[] args) {
//USer oluþturmak için butun iþlemler user uzerinden yapýlacak cascade typelarý ona göre ayarladýk
		UserService userService = new UserService();

		PhoneNumber phoneNumber = new PhoneNumber("555-555-555");
		PhoneNumber phoneNumber2 = new PhoneNumber("666-666-666");
		List<PhoneNumber> phonesList = new ArrayList<>();
		phonesList.add(phoneNumber2);
		phonesList.add(phoneNumber);

		Address address = new Address("Ankara");
		Address address2 = new Address("Bolu");
		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		addresses.add(address2);
		UserInformation userInformation = new UserInformation("Merve", "ÖZtürk", "merve@gmail.com", phonesList,
				addresses);// phonenumber ve adress gerekli

		phoneNumber.setUserInformation(userInformation);// phonenumberlara user ýnformation setleme
		phoneNumber2.setUserInformation(userInformation);

		address.setUserInformation(userInformation);
		address2.setUserInformation(userInformation);

		User user = new User("xxx", "123", userInformation);// user information gerekli
//		User user2 = new User("yyy", "123", userInformation);
//		userInformation.setUser(user2);

		userInformation.setUser(user);

		userService.save(user);

	}

}
