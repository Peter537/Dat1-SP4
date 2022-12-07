package main;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FormulaOne formulaOne = new FormulaOne(getPassword());
        formulaOne.run();
    }

    public static String getPassword() {
        File file = new File("Data/databasepassword.txt");
        try {
            Scanner scanner = new Scanner(file);
            return scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}