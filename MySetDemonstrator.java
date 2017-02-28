package by.epam.lesson8.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySetDemonstrator {
	public static void main(String[] args)

	/*
	 * Реализуйте самостоятельно динамическую структуру Множество, не содержащую
	 * дублирующихся элементов. Используйте параметризацию при описании класса.
	 * (Условие не означает необходимости повторить все возможности класса
	 * HashSet).
	 */
	{

		Integer[] g = { 1, 2, 3, 4, 5 };

		MySet<Integer> tempset1 = new MySet<Integer>(5, g);
		System.out.println(tempset1);

		List<Integer> tempset = new ArrayList<>();
		Collections.addAll(tempset, 1, 2, 2, 3, 4, 5, 5);

		MySet<Integer> tempset2 = new MySet<Integer>(tempset);
		System.out.println(tempset2);

		List<String> stringtempset = new ArrayList<>();
		Collections.addAll(stringtempset, "TheFirstString", "TheSecondString", "TheThirdString", "TheFirstString",
				"TheThirdString");
		MySet<String> tempset3 = new MySet<String>(stringtempset);
		System.out.println(tempset3);

		Collections.addAll(stringtempset, "TheFirstString", "TheFourthString");
		MySet<String> tempset4 = new MySet<String>(stringtempset);
		System.out.println(tempset4);

		System.out.println();
		System.out.println("The result of equals: " + tempset2.equals(tempset1));
		System.out.println(tempset2);
		System.out.println(tempset1);
		System.out.println();

		System.out.println();
		System.out.println("The result of equals: " + tempset3.equals(tempset4));
		System.out.println(tempset3);
		System.out.println(tempset4);
		System.out.println();

		System.out.println("The result of contains: " + tempset3.contains("TheFirstString"));
		System.out.println("I try to find \"TheFirstString\" item in " + tempset3);
		System.out.println();

		System.out.println("The result of contains: " + tempset2.contains(100));
		System.out.println("I try to find 100 item in " + tempset2);
		System.out.println();

		System.out.println(tempset2);
		System.out.println("The result of add 100: " + tempset2.add(100));
		System.out.println("The result of add 1: " + tempset2.add(1));
		System.out.println(tempset2);
		System.out.println();

		System.out.println(tempset2);
		System.out.println("The result of remove 1 is " + tempset2.remove(1));
		System.out.println(tempset2);

		System.out.println("The result of remove 4 is " + tempset2.remove(4));
		System.out.println(tempset2);

		System.out.println("The result of remove 100 is " + tempset2.remove(100));
		System.out.println(tempset2);

		System.out.println("The result of remove 100 is " + tempset2.remove(100));
		System.out.println(tempset2);
		System.out.println();

		System.out.println(tempset3);
		System.out.println("The result of remove 100 is " + tempset3.remove("TheFirstString"));
		System.out.println(tempset3);

		// System.out.println(tempset2);

	}
}
