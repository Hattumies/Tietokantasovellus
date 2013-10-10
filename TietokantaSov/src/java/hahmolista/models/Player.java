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
public class Player {

    String name, id, passwd;

    public Player(String name, String id, String passwd) {
        this.name = name;
        this.id = id;
        this.passwd = passwd;
    }

    public void uusiPelaaja() throws Exception {
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("INSERT INTO Players(Player(Player, PlayerId, Passwd) VALUES(?,?)");
        statement.setString(1, name);
        statement.setString(2, id);
        statement.executeUpdate();
        yhteys.sulje();
    }

    public void poistaPelaaja() throws Exception{
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("DELETE FROM Players(Player(Player, PlayerId, Passwd) where VALUES(?,?,?)");
        statement.setString(1, name);
        statement.setString(2, id);
        statement.setString(3, passwd);
        statement.executeUpdate();
        yhteys.sulje();
    }
    
    public static Player haePelaaja(String name) throws Exception{
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("SELECT * FROM Players(Player(Player, PlayerId, Passwd) where PlayerName = ?");
        statement.setString(1, name);
        Player player = null;
        if(statement.execute()) {
            ResultSet result = statement.getResultSet();
            if(result.next()) {
                player = new Player(result.getString(1), result.getString(2), result.getString(3));
            }
        }
        yhteys.sulje();
        if(player == null) {
            throw new Exception();
        }
        return player;
    }
    
    public static ArrayList haeKaikkiPelaajat() throws Exception{
        ArrayList<Player> players = new ArrayList();
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("SELECT * from Players");
        ResultSet result = statement.executeQuery();
        while(result.next()) {
            Player player = new Player(result.getString(1), result.getString(2), result.getString(3));
            players.add(player);
        }
        
        return players;
    }
}
