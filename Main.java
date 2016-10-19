package test20161019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {

		ArrayList<Type> types = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			
			int randomNumber1 = randomNumber();
			int randomNumber2 = randomNumber();
			
			types.add(new Type(randomNumber1, randomNumber2, randomNumber1 + " " + randomNumber2));
		}

		for (Type type : types) {

			System.out.println(type.param1 + " " + type.param2 + " " + type.param3);
		}

		System.out.println("-------------");
		
		/* ---------------------------------------
		 * Egy tulajdonság szerinti sorba rendezés
		 */
		Collections.sort(types, new Comparator<Type>() {

			@Override
			public int compare(Type t1, Type t2) {

				return t1.param1 - t2.param1;
			}
		});
		
		/* ---------------------------------------
		 * Két tulajdonság szerinti sorba rendezés
		 */
		Collections.sort(types, new Comparator<Type>() {

			@Override
			public int compare(Type t1, Type t2) {

				if (t1.param1 == t2.param1) {
					
					return t1.param2 - t2.param2;
				} else {
					
					return t1.param1 - t2.param1;
				}
			}
		});

		for (Type type : types) {

			System.out.println(type.param1 + " " + type.param2 + " " + type.param3);
		}
	}

	public static int randomNumber() {

		return (int) Math.floor(Math.random() * 100) + 1;
	}

	public static class Type {

		int param1;
		int param2;
		String param3;

		Type(int param1, int param2, String param3) {

			this.param1 = param1;
			this.param2 = param2;
			this.param3 = param3;
		}
	}
}
