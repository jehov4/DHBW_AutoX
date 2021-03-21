package Configurator;

import java.util.*;

public class Configurator {

    MementoCaretaker caretaker = new MementoCaretaker();

    public void Configure(){
        Configuration configuration = new Configuration();
        caretaker.setMemento(new Configuration(configuration));
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit){
            System.out.println("[1] print");
            System.out.println("[2] set parameter");
            System.out.println("[3] undo");
            System.out.println("[4] exit");
            System.out.println("> ");
            String input = scanner.nextLine();
            int option = -1;
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input Invalid try again");
                continue;
            }
            switch (option){
                case 1:
                    configuration.print();
                    break;
                case 2:
                    caretaker.setMemento(new Configuration(configuration));
                    configuration.print();
                    System.out.println("Enter ID >");
                    int innerOption = -1;
                    boolean accepted = false;
                    while (!accepted){
                        try {
                            innerOption = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Input invalid try again");
                        }
                        accepted = configuration.printConfigurationOption(innerOption);
                    }

                    while(!configuration.newValue(innerOption, scanner.nextLine())){}

                    break;
                case 3:
                    configuration = caretaker.getMemento();
                    break;
                case 4:
                    return;
            }






        }
    }


}
