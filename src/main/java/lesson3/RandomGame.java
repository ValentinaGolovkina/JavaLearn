package lesson3;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        Random rand = new Random();
        String secretWord = words[rand.nextInt(words.length-1)];
        //System.out.println("Загаданное слово: "+secretWord);
        System.out.println("Компьютер загадал слово. Попробуй угадать: ");
        boolean gessed=true;
        Scanner sc = new Scanner(System.in);
        do {
            gessed=true;
            String word = sc.nextLine();
            int length = secretWord.length() < word.length() ? secretWord.length() : word.length();
            String result = "";
            for (int i = 0; i < length; i++) {
                if (word.charAt(i) == secretWord.charAt(i)) {
                    result += word.charAt(i);
                } else {
                    result += '#';
                    gessed = false;
                }
            }
            if (!gessed) {
                if (result.length() < 15)
                    for (int i = result.length(); i < 15; i++)
                        result += '#';
                System.out.println("Ты не угадал. Буквы на своих местах: " + result);
                System.out.println("Попробуй снова: ");
            }
        } while (!gessed);
        System.out.println("Поздравляю! Ты угадал слово: "+secretWord);
    }
}
