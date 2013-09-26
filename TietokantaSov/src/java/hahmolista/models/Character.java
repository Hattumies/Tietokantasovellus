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
     Yhteydet yhteydet;
     String nimi, pelaaja, mental, physical, social, template;
     int advantage;
    
    public Character(String nimi, String pelaaja, String mental, String physical, String social, String template, int advantage) {
        this.nimi = nimi;
        this.pelaaja = pelaaja;
        this.mental = mental;
        this.social = social;
        this.template = template;
        
    }
    
    public void uusiHahmo() throws SQLException {
        yhteydet = new Yhteydet();
        PreparedStatement statement = yhteydet.getYhteys().prepareStatement("INSERT INTO Characters(CharacterName, Player, Mental, Physical, Social, Template, MetanormalAdvantage) VALUES(?,?,?,?,?,?,?))");
    }
    
    public void poistaHahmo() {
        
    }
    
    public static Character hae() {
        return null;
    }
}
