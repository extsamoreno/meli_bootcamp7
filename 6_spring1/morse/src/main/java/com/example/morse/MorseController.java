package com.example.morse;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.valueOf;

@RestController
@RequestMapping("/morse")
public class MorseController {

	static final Map<Character, String> letterToMorse = Map.ofEntries(
			Map.entry('A',".-"),
			Map.entry('B', "-..."),
			Map.entry('C', "-.-."),
			Map.entry('D', "-.."),
			Map.entry('E', "."),
			Map.entry('F', "..-."),
			Map.entry('G', "--."),
			Map.entry('H', "...."),
			Map.entry('I', ".."),
			Map.entry('J', ".---"),
			Map.entry('K', "-.-"),
			Map.entry('L', ".-.."),
			Map.entry('M', "--"),
			Map.entry('N', "-."),
			Map.entry('Ñ', "--.--"),
			Map.entry('O', "---"),
			Map.entry('P', ".--."),
			Map.entry('Q', "--.-"),
			Map.entry('R', ".-."),
			Map.entry('S', "..."),
			Map.entry('T', "-"),
			Map.entry('U', "..-"),
			Map.entry('V', "...-"),
			Map.entry('W', ".--"),
			Map.entry('X', "-..-"),
			Map.entry('Y', "-.--"),
			Map.entry('Z', "--.."),
			Map.entry('0', "-----"),
			Map.entry('1', ".----"),
			Map.entry('2', "..---"),
			Map.entry('3', "...--"),
			Map.entry('4', "....-"),
			Map.entry('5', "....."),
			Map.entry('6', "-...."),
			Map.entry('7', "--..."),
			Map.entry('8', "---.."),
			Map.entry('9', "----."),
			Map.entry('.', ".-.-.-"),
			Map.entry(',', "--..--"),
			Map.entry('?', "..--.."),
			Map.entry('"', ".-..-."),
			Map.entry('/', "-..-.")
		);

	@GetMapping("/translate/{message}")
	public String getMorse(@PathVariable String message) {
		message = message.toUpperCase();
		String response = "";

		for (int i = 0; i < message.length(); ++i)
			response += letterToMorse.get(message.charAt(i)) + " ";

		return response.trim();
	}
}
