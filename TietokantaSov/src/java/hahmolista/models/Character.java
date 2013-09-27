/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hahmolista.models;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tietokanta.Yhteydet;

/**
 *
 * @author ilmarihu
 */
public class Character {
     String nimi, pelaaja, mental, physical, social, template;
     int advantage;
    
    public Character(String nimi, String pelaaja, String mental, String physical, String social, String template, int advantage) {
        this.nimi = nimi;
        this.pelaaja = pelaaja;
        this.mental = mental;
        this.social = social;
        this.template = template;
        this.advantage = advantage;
        
    }
    
    public void uusiHahmo() throws SQLException {
        Yhteydet yhteydet = new Yhteydet();
        PreparedStatement statement = yhteydet.getYhteys().prepareStatement("INSERT INTO Characters(CharacterName, Player, Mental, Physical, Social, Template, MetanormalAdvantage) VALUES(?,?,?,?,?,?,?))");
        statement.setString(1, nimi);
        statement.setString(2, pelaaja);
        statement.setString(3, mental);
        statement.setString(4, physical);
        statement.setString(5, social);
        statement.setString(6, template);
        statement.setInt(7, advantage);
        statement.executeUpdate();
        yhteydet.sulje();
    }
    
    public void poistaHahmo(String nimi) throws Exception {
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("DELETE FROM Characters WHERE CharacterName = ?");
        statement.setString(1, nimi);
        statement.executeUpdate();
        yhteys.sulje();
    }
    
    public static Character hae(String nimi) throws Exception {
        Yhteydet yhteys = new Yhteydet();
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("SELECT * from Characters WHERE CharacterName = ?");
        statement.setString(1, nimi);
        Character hahmo = null;
        if(statement.execute()) {
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                hahmo = new Character(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getInt(7));
            }
        }
        yhteys.sulje();
        if (hahmo == null) {
            throw new Exception();
        }
        return hahmo;
    }
}