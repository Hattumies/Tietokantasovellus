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

    private String name;
    private String id;
    private String passwd;

    public Player(String name, String id, String passwd) {
        this.name = name;
        this.id = id;
        this.passwd = passwd;
    }

    public void uusiPelaaja() throws Exception {
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("INSERT INTO Players(Player, PlayerId, Passwd) VALUES(?,?,?)");
        statement.setString(1, getName());
        statement.setString(2, getId());
        statement.setString(3, getPasswd());
        statement.executeUpdate();
        yhteys.sulje();
    }

    public static void poistaPelaaja(String player) {
        Yhteydet yhteys = new Yhteydet();
        try {
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("DELETE FROM Players where Player =?");
        statement.setString(1, player);
        statement.executeUpdate();
        } catch(Exception e) {
            System.out.println("poista pelaaja: " + e.getMessage());
        }
        yhteys.sulje();
    }
    
    public static Player haePelaaja(String name) throws Exception{
        Yhteydet yhteys = new Yhteydet();
        Player player = null;
        try {
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("SELECT * FROM Players where Player = ?");
        statement.setString(1, name);
        
        if(statement.execute()) {
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                player = new Player(result.getString(1), result.getString(2), result.getString(3));
            }
        }
        } catch(Exception e) {
            System.out.println("Hae pelaaja: " + e.getMessage());
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
