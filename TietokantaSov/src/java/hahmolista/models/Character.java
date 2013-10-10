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
import java.util.ArrayList;
import tietokanta.Yhteydet;

/**
 *
 * @author ilmarihu
 */
public class Character {
     private String nimi;
     private String pelaaja;
    private String mental;
    private String physical;
    private String social;
    private String template;
    private int advantage;
    
    public Character(String nimi, String pelaaja, String mental, String physical, String social, String template, int advantage) {
        this.nimi = nimi;
        this.pelaaja = pelaaja;
        this.mental = mental;
        this.physical = physical;
        this.social = social;
        this.template = template;
        this.advantage = advantage;
        
    }
    
    public void uusiHahmo() {
        Yhteydet yhteydet = new Yhteydet();
        try {
        PreparedStatement statement = yhteydet.getYhteys().prepareStatement("INSERT INTO Characters(CharacterName, Player, Mental, Physical, Social, Template, MetanormalAdvantage) VALUES(?,?,?,?,?,?,?)");
        statement.setString(1, getNimi());
        statement.setString(2, getPelaaja());
        statement.setString(3, getMental());
        statement.setString(4, getPhysical());
        statement.setString(5, getSocial());
        statement.setString(6, getTemplate());
        statement.setInt(7, getAdvantage());
        statement.executeUpdate();
        } catch(Exception e) {
            System.out.println("luonti: " + e.getMessage());
        }
        
        yhteydet.sulje();
    }
    
    public void poistaHahmo(String nimi) {
        Yhteydet yhteys = new Yhteydet();
        try {
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("DELETE FROM Characters WHERE CharacterName = ?");
        statement.setString(1, nimi);
        statement.executeUpdate();
        } catch(Exception e) {
            System.out.println("poistaminen: " + e.getMessage());
        }
        yhteys.sulje();
    }
    
    public static ArrayList<Character> haeKaikki() {
        ArrayList<Character> hahmot = new ArrayList();
        Yhteydet yhteys = new Yhteydet();
        try {
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("SELECT * from Characters");
        ResultSet result = statement.executeQuery();
        while(result.next()) {
            Character hahmo = new Character(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getInt(7));
            hahmot.add(hahmo);
        }
        } catch(Exception e) {
            System.out.println("hae kaikki: " + e.getMessage());
        }
        yhteys.sulje();
        return hahmot;
    }
    
    public static Character hae(String nimi) {
        Yhteydet yhteys = new Yhteydet();
        Character hahmo = null;
        try {
        PreparedStatement statement = yhteys.getYhteys().prepareStatement("SELECT * from Characters WHERE CharacterName = ?");
        statement.setString(1, nimi);
        
        if(statement.execute()) {
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                hahmo = new Character(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getInt(7));
            }
        }
        yhteys.sulje();
        
        } catch(Exception e) {
            System.out.println("haku: " + e.getMessage());
        }
        
        return hahmo;
    }

    /**
     * @return the nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * @param nimi the nimi to set
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * @return the pelaaja
     */
    public String getPelaaja() {
        return pelaaja;
    }

    /**
     * @param pelaaja the pelaaja to set
     */
    public void setPelaaja(String pelaaja) {
        this.pelaaja = pelaaja;
    }

    /**
     * @return the mental
     */
    public String getMental() {
        return mental;
    }

    /**
     * @param mental the mental to set
     */
    public void setMental(String mental) {
        this.mental = mental;
    }

    /**
     * @return the physical
     */
    public String getPhysical() {
        return physical;
    }

    /**
     * @param physical the physical to set
     */
    public void setPhysical(String physical) {
        this.physical = physical;
    }

    /**
     * @return the social
     */
    public String getSocial() {
        return social;
    }

    /**
     * @param social the social to set
     */
    public void setSocial(String social) {
        this.social = social;
    }

    /**
     * @return the template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * @param template the template to set
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * @return the advantage
     */
    public int getAdvantage() {
        return advantage;
    }

    /**
     * @param advantage the advantage to set
     */
    public void setAdvantage(int advantage) {
        this.advantage = advantage;
    }
}
