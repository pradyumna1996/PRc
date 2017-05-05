/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prad.practice.list.controller;

import java.util.Scanner;
import prad.practice.list.dao.AccountDAO;
import prad.practice.list.entity.Account;

/**
 *
 * @author conne
 */
public class AccountController {

    private Scanner input;
    private AccountDAO accountDAO;

    public AccountController(Scanner input, AccountDAO accountDAO) {
        this.input = input;
        this.accountDAO = accountDAO;
    }

    private void menu() {
        System.out.println("1. Add Account");
        System.out.println("2. Show Accounts");
        System.out.println("3. Search By ID");
        System.out.println("4. Delete By ID");
        System.out.println("5. Exit");
        System.out.println("Enter Your Choice [1-5]:");
    }

    private void addView() {

        Account acc = new Account();

        System.out.println("---Add Account--");

        acc.setId(accountDAO.insertId());

        System.out.println("Enter Account Type:");
        acc.setName(input.next());

        System.out.println("Enter Interest: ");
        acc.setInterest(input.nextDouble());

        System.out.println("Enter Minimum Balance");
        acc.setMinimumBalance(input.nextInt());

        accountDAO.insert(acc);
    }

    private void showAllView() {
        System.out.println("-----List of Type of Accounts---");

        for (Account a : accountDAO.getAll()) {

            System.out.println("Id: " + a.getId());
            System.out.println("Name : " + a.getName());
            System.out.println("Interest :" + a.getInterest());
            System.out.println("Minimum Balance: " + a.getMinimumBalance());

        }
    }

    public void searchView() {

        System.out.println("Enter ID of Account Type To Search: ");
        Account a = accountDAO.getByID(input.nextInt());
        if (a != null) {
            System.out.println("Id: " + a.getId());
            System.out.println("Name : " + a.getName());
            System.out.println("Interest :" + a.getInterest());
            System.out.println("Minimum Balance: " + a.getMinimumBalance());
        }else {
            System.out.println("Sorry Type Is Not Found");
        }
    }
    
    
    public void deleteView() {

        System.out.println("Enter ID of Account Type To Delete: ");
        Account a = accountDAO.getByID(input.nextInt());
        if (a != null) {
            System.out.println("Id: " + a.getId());
            System.out.println("Name : " + a.getName());
            System.out.println("Interest :" + a.getInterest());
            System.out.println("Minimum Balance: " + a.getMinimumBalance());
            System.out.println("Sure , Delete [Y/N]:");
            if(input.next().equalsIgnoreCase("y")){
                accountDAO.delete(a.getId());
            }
        
        }else {
            System.out.println("Sorry Type Is Not Found");
        }
    }
    
    

    public void process() {
        menu();
        switch (input.nextInt()) {

            case 1:
                addView();
                break;

            case 2:

                showAllView();
                break;
            case 3:
                searchView();
                break;
                
            case 4:
                deleteView();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

}
