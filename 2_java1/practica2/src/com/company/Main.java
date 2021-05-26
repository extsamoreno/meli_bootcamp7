package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		int[] arr = {4, 28, 132, 3, 61, 5};

		radixSort(arr);
	}

	public static void radixSort(int[] arr) {
		String[] sArr = StringUtils.getNormalizedStringList(arr);

		int radix = sArr[0].length();

		for (int i = 0; i < radix; ++i) {
			Map<Character, List<String>> map = new HashMap<>();

			for (var s: sArr)
				map.put(s.charAt(i), new ArrayList<String>());

			for (var s: sArr)
				map.get(s.charAt(i)).add(s);
		}

		for (var s: sArr)
			System.out.println(s);
	}
}
