/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hahmolista.models;

import java.sql.PreparedStatement;
import tietokanta.Yhteydet;

/**
 *
 * @author ilmarihu
 */
public class Player {

    String name, id;

    public Player(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void uusiPelaaja() throws Exception {
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("INSERT INTO Players(Player(Player, PlayerId) VALUES(?,?)");
        statement.setString(1, name);
        statement.setString(2, id);
        statement.executeUpdate();
        yhteys.sulje();
    }

    public void poistaPelaaja() throws Exception{
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("DELETE FROM Players(Player(Player, PlayerId) where VALUES(?,?)");
        statement.setString(1, name);
        statement.setString(2, id);
        statement.executeUpdate();
        yhteys.sulje();
    }
    
    public static Player haePelaaja(String name) throws Exception{
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("SELECT * FROM Players(Player(Player, PlayerId) where PlayerName");
        statement.executeUpdate();
        return null;
    }
}
