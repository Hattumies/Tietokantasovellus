/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hahmolista.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import tietokanta.Yhteydet;

/**
 *
 * @author ilmarihu
 */
public class Item {
    String item, owner;
    
    public Item(String item, String owner) {
        this.item = item;
        this.owner = owner;
    }
    
    public void uusiItem() throws Exception{
        Yhteydet yhteydet = new Yhteydet();
        PreparedStatement statement = yhteydet.getYhteys().prepareStatement("INSERT INTO Items(ItemName, CharacterName) VALUES(?,?)");
        statement.setString(1, item);
        statement.setString(2, owner);
        statement.executeUpdate();
        yhteydet.sulje();
    }
    
    public void poistaItem(String item) throws Exception{
        Yhteydet yhteydet = new Yhteydet();
        PreparedStatement statement = yhteydet.getYhteys().prepareStatement("IDELETE FROM Items WHERE ItemName = *");
        statement.setString(1, item);
        statement.executeUpdate();
        yhteydet.sulje();
    }
    
    public static ArrayList<Item> haeKaikki() throws Exception{
        ArrayList<Item> items = new ArrayList();
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("SELECT * FROM Items");
        ResultSet result = statement.executeQuery();
        while(result.next()) {
            Item item = new Item(result.getString(1),result.getString(2));
            items.add(item);
        }
        yhteys.sulje();
        
        return items;
    }
    
    public static Item hae(String item) throws Exception{
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("SELECT * from ITEMS WHERE ItemName = ?");
        statement.setString(1, item);
        Item esine = null;
        if(statement.execute()) {
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                esine = new Item(result.getString(1),result.getString(2));
            }
        }
        yhteys.sulje();
        if (esine == null) {
            throw new Exception();
        }
        return esine;
    }
    
}
