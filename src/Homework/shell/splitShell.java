package Homework.shell;

import java.util.Scanner;

public class splitShell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        input=input.replace(';','?');
        System.out.println(input);
    }
}
