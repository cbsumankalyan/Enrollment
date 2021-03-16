package Pages;

import java.util.Random;

public class TurkeyGovID {
	
	public static String getSaltString() {
		String SALTCHARS = "0123456789";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 11) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public static boolean checkNumber(String number) {
		
		int oddDigits = 0;
		int evenDigits = 0;
		int rule;
		int sum = 0;

		if (number.length() < 11) {
			return false;
		}

		if (number.startsWith("0")) {
			return false;
		}

		char arrChar[] = number.toCharArray();
		int[] arr = new int[arrChar.length];
		for (int i = 0; i < arrChar.length; i++) {
			arr[i] = Integer.parseInt(arrChar[i] + "");
		}

		if (arr[10] % 2 != 0) {
			return false;
		}

		for (int i = 0; i < 9; i++) {
			
			sum += arr[i];
			if ((i % 2) == 0) {
				oddDigits += arr[i];
			} else {
				evenDigits += arr[i];
			}
		}

		sum += arr[9];
		rule = ((oddDigits * 7) - evenDigits);

		if (rule % 10 != arr[9]) {
			return false;
		}

		if ((sum % 10) != arr[10]) {
			return false;
		}

		return true;
	}
	
}
