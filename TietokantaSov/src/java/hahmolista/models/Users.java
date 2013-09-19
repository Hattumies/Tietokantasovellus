/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hahmolista.models;

import java.util.HashMap;

/**
 *
 * @author ilmarihu
 */
public class Users {
    HashMap users;
    
    public Users() {
        users = new HashMap();
        users.put("kalanaama", "kalle");
    }
    
    public boolean tarkistaKirjautuminen(String kayttajanimi, String salasana) {
        if(users.get(salasana) == kayttajanimi ) {
            return true;
        } else {
            return false;
        }
    }
}
