package spring1.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/morseTranslator")
public class MorseToLatinAlphabet {
    private final Map<String, Character> morseToLatin = Map.ofEntries(
            Map.entry(".-", 'a'),
            Map.entry("-...", 'b'),
            Map.entry("-.-.", 'c'),
            Map.entry("-..", 'd'),
            Map.entry(".", 'e'),
            Map.entry("..-.", 'f'),
            Map.entry("--.", 'g'),
            Map.entry("....", 'h'),
            Map.entry("..", 'i'),
            Map.entry(".---", 'j'),
            Map.entry("-.-", 'k'),
            Map.entry(".-..", 'l'),
            Map.entry("--", 'm'),
            Map.entry("-.", 'n'),
            Map.entry("---", 'o'),
            Map.entry(".--.", 'p'),
            Map.entry("--.-", 'q'),
            Map.entry(".-.", 'r'),
            Map.entry("...", 's'),
            Map.entry("-", 't'),
            Map.entry("..-", 'u'),
            Map.entry("...-", 'v'),
            Map.entry(".--", 'w'),
            Map.entry("-..-", 'x'),
            Map.entry("-.--", 'y'),
            Map.entry("--..", 'z'),
            Map.entry(".----", '0'),
            Map.entry("..---", '1'),
            Map.entry("...--", '2'),
            Map.entry("....-", '3'),
            Map.entry(".....", '4'),
            Map.entry("-....", '5'),
            Map.entry("--...", '6'),
            Map.entry("---..", '7'),
            Map.entry("----.", '8'),
            Map.entry("-----", '9'),
            Map.entry(" ",(char)0));

    @GetMapping("/translate/{morseString}")
    public String translate(@PathVariable String morseString) {
        return Stream.of(morseString.split("   "))
                .map(s-> s.split(" "))
                .map(sArr-> Stream.of(sArr)
                        .map(morseToLatin::get)
                        .map(Object::toString)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));

    }
}
