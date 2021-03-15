package com.company;

import java.util.Scanner;

public class Main {
    private static    Scanner scanner = new Scanner(System.in);
    private static    VendorMachine myVendor = new VendorMachine("Metrou Pacii");

    public static void main(String[] args) {

        int choise = 0;
        boolean flag = true;
        printActions();

        while (flag){
            choise = scanner.nextInt();
            scanner.nextLine();
            switch (choise){
                case 0:
                    flag = false;
                    break;
                case 1:
                    myVendor.printProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    printActions();
                    break;
            }
        }

    }

    private static void removeProduct(){
        System.out.println("Enter product name that you whant to remove: ");
        String name = scanner.nextLine();
        if (myVendor.findProductByName(name) != null){
            myVendor.deleteProduct(name);
        }else {
            System.out.println("product doesn't exist");
        }
    }

    private static void updateProduct(){
        System.out.println("Enter product name that you whant to update: ");
        String name = scanner.nextLine();
        if (myVendor.findProductByName(name) != null){
            System.out.println("Enter the new product name: ");
            String newProductName = scanner.nextLine();
            System.out.println("Enter the price for the new product :");
            double price = scanner.nextDouble();
            scanner.nextLine();
            myVendor.changeProductNameAndPrice(name,newProductName, price);
        } else {
            System.out.println("product doesn't exist");
        }

    }


    private static void addProduct (){
        System.out.println("Enter product name : ");
        String name = scanner.nextLine();
        System.out.println("Enter product price : ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        myVendor.addProducts(name,price);
    }

    private static void printActions(){
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - to shut down\n" +
                "1 - to print products\n" +
                "2 - to add a new product\n" +
                "3 - to update existing product\n" +
                "4 - to remove existing product\n" +
                "5 - to print a list of available actions");
        System.out.println("Choose your action: ");
    }

}
