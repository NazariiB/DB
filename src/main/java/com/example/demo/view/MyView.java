package com.example.demo.view;

import com.example.demo.controller.*;
import com.example.demo.controller.impl.ProductControllerImpl;
import com.example.demo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Scanner;

@Component
public class MyView {
    private final Scanner input = new Scanner(System.in);
    @Autowired
    private WorkerController workerController;
    @Autowired
    private ProductController productController;
    @Autowired
    private TeamController teamController;
    @Autowired
    private VendingMachineController vendingMachineController;
    @Autowired
    private MoneyController moneyController;
    @Autowired
    private LoadedSnacksController loadedSnacksController;
    @Autowired
    private ContentOfTheMachineController contentOfTheMachineController;
    @Autowired
    private SoldProductsController soldProductsController;
    @Autowired
    private ReloadedSnacksMachineController reloadedSnacksMachineController;

    public void printAllTables() {
        System.out.println("\n_____________All__workers___________________________\n");
        List<Worker> workers = workerController.findAll();
        workers.forEach(System.out::println);

        System.out.println("\n_____________All__teams____________________________\n");
        var workers0 = teamController.findAll();
        workers0.forEach(System.out::println);

        System.out.println("\n_____________All__product___________________________\n");
        var workers1 = productController.findAll();
        workers1.forEach(System.out::println);

        System.out.println("\n_____________All__vendingMachine___________________\n");
        var workers2 = vendingMachineController.findAll();
        workers2.forEach(System.out::println);

        System.out.println("\n_____________All__money____________________________\n");
        var workers3 = moneyController.findAll();
        workers3.forEach(System.out::println);

        System.out.println("\n_____________All__loadedSnacks____________________\n");
        var workers4 = loadedSnacksController.findAll();
        workers4.forEach(System.out::println);

        System.out.println("\n_____________All__contentOfTheMachine_____________\n");
        var workers5 = contentOfTheMachineController.findAll();
        workers5.forEach(System.out::println);

        System.out.println("\n_____________All__soldProducts____________________\n");
        var workers6 = soldProductsController.findAll();
        workers6.forEach(System.out::println);

        System.out.println("\n_____________All__reloadedSnacksMachine___________\n");
        var workers7 = reloadedSnacksMachineController.findAll();
        workers7.forEach(System.out::println);
    }
    private void printMenu() {
        System.out.print(
                "___________________MY___PROGRAM________________________\n"+
                "| 1- print all tables\n" +
                "| 2- select specific table \n" +
                "| q- stop program\n" +
                "--------------------------------------------------------\n" +
                "Select action \n>>>"
        );
    }

    private void printTables() {
        System.out.print(
                "___________________MY___PROGRAM________________________\n"+
                        "| 3- select worker\n" +
                        "| 4- select team\n" +
                        "| 5- select vending_machine\n" +
                        "| 6- select product\n" +
                        "| 7- select content_of_the_machine\n" +
                        "| 8- select sold_products\n" +
                        "| 9- select money\n" +
                        "| 10- select reloading_snacks_machine\n" +
                        "| 11- select loaded_snack\n" +
                        "| 12- main menu\n" +
                        "--------------------------------------------------------\n" +
                        "Select action \n>>>"
        );
    }

    private void printTableFun(String table) {
        System.out.print(
                "___________________"+ table +"________________________\n"+
                        "| 3.3- create new item\n" +
                        "| 3.4- print table\n" +
                        "| 3.5- delete item\n" +
                        "| 3.6- find item by id\n" +
                        "| 3.7- update item\n" +
                        "| 3.8- main menu\n" +
                        "--------------------------------------------------------\n" +
                        "Select action \n>>>"
        );
    }


    private void createUpdateItem(GeneralController gc, boolean isCreate) {
        if(isCreate)
            System.out.println("\n________________create_________________");
        else
            System.out.println("\n________________update_________________");
        if(gc instanceof WorkerController) {
            createWorker(isCreate);
        } else if (gc instanceof TeamController) {
            createTeam(isCreate);
        } else if(gc instanceof VendingMachineController) {
            createVenadingMachine(isCreate);
        } else if(gc instanceof ProductController) {
            createProduct(isCreate);
        } else if(gc instanceof ContentOfTheMachineController) {
            createContentOfMachine(isCreate);
        } else if(gc instanceof SoldProductsController) {
            createSoldProduct(isCreate);
        } else if(gc instanceof MoneyController) {
            createMoney(isCreate);
        } else if(gc instanceof ReloadedSnacksMachineController) {
            createReloadingSnackMachine(isCreate);
        } else if(gc instanceof LoadedSnacksController) {
            createLoadedSnacks(isCreate);
        } else {
            System.out.println("\n-----------incorect-input-------------\n");
        }
    }

    private void printTable(GeneralController gc) {
        System.out.println("\n________________print________________\n");
        var list = gc.findAll();
        list.forEach(System.out::println);
    }

    private void deleteItem(GeneralController gc) {
        System.out.print("\n________________delete________________\nEnter id \n>>>");
        Integer id = Integer.parseInt(input.nextLine());
        int res = gc.delete(id);
        System.out.println("________________affected_" + res + "_rows____________");
    }

    private void findItemById(GeneralController gc) {
        System.out.print("\n________________find________________\nEnter id \n>>>");
        Integer id = Integer.parseInt(input.nextLine());
        Optional res = gc.findById(id);
        if(res.isPresent()) {
            System.out.println(res.get());
        }else {
            System.out.println("\n__________item_does_not_exist______\n");
        }
    }

    private void selectTable() {
        String table = input.nextLine();
        GeneralController gc;
        if(table.equals("3")) {
            gc = workerController;
            table = "worker";
        } else if (table.equals("4")) {
            gc = teamController;
            table = "team";
        } else if(table.equals("5")) {
            gc = vendingMachineController;
            table = "vending_machine";
        } else if(table.equals("6")) {
            gc = productController;
            table = "product";
        } else if(table.equals("7")) {
            gc = contentOfTheMachineController;
            table = "content_of_the_machine";
        } else if(table.equals("8")) {
            gc = soldProductsController;
            table = "sold_products";
        } else if(table.equals("9")) {
            gc = moneyController;
            table = "money";
        } else if(table.equals("10")) {
            gc = reloadedSnacksMachineController;
            table = "reloading_snacks_machine";
        } else if(table.equals("11")) {
            gc = loadedSnacksController;
            table = "loaded_snack";
        } else {
            System.out.println("\n-----------incorect-input-------------\n");
            return;
        }
        String chose;
        do {
            printTableFun(table);
            chose = input.nextLine();
            if(chose.equals("3.3")) {
                createUpdateItem(gc, true);
            } else if(chose.equals("3.4")) {
                printTable(gc);
            } else if(chose.equals("3.5")) {
                deleteItem(gc);
            } else if (chose.equals("3.6")) {
                findItemById(gc);
            } else if (chose.equals("3.7")) {
                createUpdateItem(gc, false);
            }
        }while (!chose.equalsIgnoreCase("3.8"));
    }

    public void show() {
        String str;
        do {
            printMenu();
            str = input.nextLine();
            if(str.equals("1")) {
                printAllTables();
            } else if(str.equals("2")) {
                printTables();
                selectTable();
            }
        } while (!str.equalsIgnoreCase("q"));
    }

    private void createWorker(boolean isCreate) {
        Integer id = 0;
        System.out.print("name\n>>>");
        String name = input.nextLine();
        System.out.print("surname\n>>>");
        String surname = input.nextLine();
        System.out.print("phone number\n>>>");
        String phoneNumber = input.nextLine();
        System.out.print("team id\n>>>");
        Integer teamId = Integer.parseInt(input.nextLine());
        System.out.print("position\n>>>");
        String position = input.nextLine();
        System.out.print("sallery\n>>>");
        String sallery = input.nextLine();
        Worker worker = new Worker(0, name, surname, phoneNumber, teamId, position, sallery);
        if (isCreate) {
            System.out.println("Created worker\n" + worker);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }
        int res = isCreate ? workerController.create(worker) : workerController.update(id, worker);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createProduct(boolean isCreate) {
        Integer id = 0;
        System.out.print("name\n>>>");
        String name = input.nextLine();
        System.out.print("price\n>>>");
        Double price = Double.parseDouble(input.nextLine());
        System.out.print("mass\n>>>");
        Integer mass = Integer.parseInt(input.nextLine());
        System.out.print("companie name\n>>>");
        String companieName = input.nextLine();
        Product worker = new Product(0, name, price, mass, companieName);
        if (isCreate) {
            System.out.println("Created product\n" + worker);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }
        int res = isCreate ? productController.create(worker) : productController.update(id, worker);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createTeam(boolean isCreate) {
        int id = 0;
        System.out.print("name\n>>>");
        String name = input.nextLine();
        Team worker = new Team(0, name);
        if (isCreate) {
            System.out.println("Created team\n" + worker);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }
        int res = isCreate ? teamController.create(worker) : teamController.update(id, worker);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createVenadingMachine(boolean isCreate) {
        int id = 0;
        System.out.print("vending_machine_model\n>>>");
        String vending_machine_model = input.nextLine();
        System.out.print("max_amount_of_snacks\n>>>");
        Integer max_amount_of_snacks = Integer.parseInt(input.nextLine());
        System.out.print("gps_cordinates\n>>>");
        String gps_cordinates = input.nextLine();
        System.out.print("amount_of_snacks\n>>>");
        Integer amount_of_snacks = Integer.parseInt(input.nextLine());
        VendingMachine item = new VendingMachine(0, vending_machine_model, max_amount_of_snacks, gps_cordinates, amount_of_snacks);
        if (isCreate) {
            System.out.println("Created item\n" + item);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }
        int res = isCreate ? vendingMachineController.create(item) : vendingMachineController.update(id, item);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createContentOfMachine(boolean isCreate) {
        int id = 0;
        System.out.print("vendingMachine_id\n>>>");
        Integer vendingMachine_id = Integer.parseInt(input.nextLine());
        System.out.print("product_id\n>>>");
        Integer product_id = Integer.parseInt(input.nextLine());
        System.out.print("quantity\n>>>");
        Integer quantity = Integer.parseInt(input.nextLine());
        ContentOfMachine item = new ContentOfMachine(0, vendingMachine_id, product_id, quantity);
        if (isCreate) {
            System.out.println("Created item\n" + item);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }
        int res = isCreate ? contentOfTheMachineController.create(item) : contentOfTheMachineController.update(id, item);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }
    private void createSoldProduct(boolean isCreate) {
        int id = 0;
        System.out.print("vendingMachine_id\n>>>");
        Integer vendingMachine_id = Integer.parseInt(input.nextLine());
        System.out.print("product_id\n>>>");
        Integer product_id = Integer.parseInt(input.nextLine());
        System.out.print("quantity\n>>>");
        Integer quantity = Integer.parseInt(input.nextLine());
        System.out.print("time_of_purchase\n>>>");
        String time_of_purchase = input.nextLine();
        SoldProducts item = new SoldProducts(0, vendingMachine_id, product_id, quantity, time_of_purchase);
        if (isCreate) {
            System.out.println("Created item\n" + item);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }
        int res = isCreate ? soldProductsController.create(item) : soldProductsController.update(id, item);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }
    private void createMoney(boolean isCreate) {
        int id = 0;
        System.out.print("date\n>>>");
        String date = input.nextLine();
        System.out.print("amount_to_earn\n>>>");
        Double amount_to_earn = Double.parseDouble(input.nextLine());
        System.out.print("amount_to_put\n>>>");
        Double amount_to_put = Double.parseDouble(input.nextLine());
        System.out.print("vendingMachine_id\n>>>");
        Integer vendingMachine_id =Integer.parseInt(input.nextLine());
        System.out.print("team_id\n>>>");
        Integer team_id =Integer.parseInt(input.nextLine());
        Money item = new Money(0, date, amount_to_earn, amount_to_put, vendingMachine_id, team_id);
        if (isCreate) {
            System.out.println("Created item\n" + item);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }
        int res = isCreate ? moneyController.create(item) : moneyController.update(id, item);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }
    private void createReloadingSnackMachine(boolean isCreate) {
        int id = 0;
        System.out.print("time_reloading\n>>>");
        String time_reloading = input.nextLine();
        System.out.print("vendingMachine_id\n>>>");
        Integer vendingMachine_id =Integer.parseInt(input.nextLine());
        System.out.print("team_id\n>>>");
        Integer team_id =Integer.parseInt(input.nextLine());
        ReloadedSnackMachine item = new ReloadedSnackMachine(0, time_reloading, vendingMachine_id, team_id);
        if (isCreate) {
            System.out.println("Created item\n" + item);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }
        int res = isCreate ? reloadedSnacksMachineController.create(item) : reloadedSnacksMachineController.update(id, item);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }
    private void createLoadedSnacks(boolean isCreate) {
        int id = 0;
        System.out.print("reloading_snack_machines_id\n>>>");
        Integer reloading_snack_machines_id =Integer.parseInt(input.nextLine());
        System.out.print("product_id\n>>>");
        Integer product_id =Integer.parseInt(input.nextLine());
        System.out.print("quantity\n>>>");
        Integer quantity =Integer.parseInt(input.nextLine());
        LoadedSnacks item = new LoadedSnacks(0, reloading_snack_machines_id, product_id, quantity);
        if (isCreate) {
            System.out.println("Created item\n" + item);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }
        int res = isCreate ? loadedSnacksController.create(item) : loadedSnacksController.update(id, item);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }
}