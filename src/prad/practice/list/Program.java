/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prad.practice.list;



import java.util.Scanner;
import prad.practice.list.controller.AccountController;

import prad.practice.list.dao.impl.AccountDAOImpl;



/**
 *
 * @author conne
 */

public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        AccountController ac=new AccountController(input,new AccountDAOImpl());
        
        
        while (true) {
                    ac.process();
                    
        }

    }
}
