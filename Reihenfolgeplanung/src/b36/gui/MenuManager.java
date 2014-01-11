package b36.gui;

import java.io.Console;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Erik
 * Date: 10.12.13
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
public class MenuManager {

    public void welcomeHeading(){
        heading();
        menu();
        int input = -1;
        while(input != 0){
            secondMenu();
            input = readInteger();
             if (input == 1){
                showInfo();
            } else if (input == 2){
                setup();
            } else if (input == 3){
                reloadMenu();
            }
        }
        System.out.println("exit...");
    }

    private void reloadMenu() {
        welcomeHeading();
    }

    public int readInteger(){
        int input = -1;
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        try {
            input = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("unable to format the input to Integer");
            e.printStackTrace();
        }
        return input;
    }

    public void setup(){

    }

    public void showInfo(){
        System.out.println("no info yet.");
    }

    private void heading(){
        System.out.println("Welcome to Jobrunner");
    }

    private void menu(){
        System.out.println("");
        System.out.println("1. info");
        System.out.println("2. set the values");
        System.out.println("3. reload menu");
        System.out.println("0. quit");
        System.out.println("");
    }

    private void secondMenu(){
        System.out.println("");
        System.out.println("3. reload menu");
        System.out.print("input: ");
    }

}
