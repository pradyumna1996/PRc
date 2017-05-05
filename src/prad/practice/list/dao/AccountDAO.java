/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prad.practice.list.dao;

import java.util.List;
import prad.practice.list.entity.Account;

/**
 *
 * @author conne
 */
public interface AccountDAO {
    
    boolean insert(Account accounts);
    List<Account> getAll();
    int insertId();
    Account getByID( int id);
    boolean delete(int id);
    
    
}
