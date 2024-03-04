import java.util.Scanner;

public class Menu{
    String[] OPTIONS;

    public Menu(String[] option_list){
        OPTIONS = new String[option_list.length];
        System.arraycopy(option_list, 0, OPTIONS, 0, option_list.length);
    }

    public void start(){
        System.out.println("         __  __ _____ _   _ _   _");
        System.out.println("        |  \\/  | ____| \\ | | | | |");
        System.out.println("        | |\\/| |  _| |  \\| | | | |");
        System.out.println("        | |  | | |___| |\\  | |_| |");
        System.out.println("        |_|  |_|_____|_| \\_|\\___/ ");

        System.out.println("Opcje:");
        for(String option : OPTIONS){System.out.println(option);}
    }
}
