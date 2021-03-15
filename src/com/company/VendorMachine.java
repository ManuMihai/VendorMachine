package com.company;

import java.util.ArrayList;

public class VendorMachine {

    private ArrayList<Product> products;
    private String vendorMachineName;

    public VendorMachine(String vendorMachineName) {
        this.products = new ArrayList<Product>();
        this.vendorMachineName = vendorMachineName;
    }

    public void addProducts (String productName, double productPrice){
        if (findProductByName(productName) == null){
            Product newProduct = Product.createProduct(productName,productPrice);
            this.products.add(newProduct);
            System.out.println("product " + productName + " was added to the vendor machine");
        }
    }

    public boolean changeProductNameAndPrice (String oldName, String newName, double newPrice){
        if (findProductByName(oldName) != null){
            for (int i = 0; i < products.size(); i++){
                if (products.get(i).getName().equals(oldName)){
                    Product changeProduct = new Product(newName, newPrice);
                    this.products.set(i, changeProduct);
                    return true;
                }
            }
        }
        return false;
    }



    public void deleteProduct (String productName){
        if (findProductByName(productName) != null){
            for (int i = 0; i < this.products.size(); i++){
                if (this.products.get(i).getName().equals(productName)){
                    this.products.remove(i);
                }
            }
            System.out.println("Product " + productName + " was deleted !");
        } else {
            System.out.println("Product " + productName + " was not found !");
        }
    }

    public Product findProductByName (String name){

        for (int i = 0; i < products.size(); i++){
            Product isProduct = new Product(products.get(i).getName(), products.get(i).getPrice());

            if (isProduct.getName().equals(name)){
                return isProduct;
            }
        }

        return null;
    }

    public void printProducts (){
        System.out.println("Products list");
        for (int i = 0 ; i < this.products.size(); i++){
            System.out.println((i) + " " +
                    this.products.get(i).getName() + " -> " +
                    this.products.get(i).getPrice());
        }
    }

    public boolean isOn (boolean isOn){
        if (isOn){
            return true;
        }
        return false;
    }


    public ArrayList<Product> getProducts() {
        return products;
    }
}
