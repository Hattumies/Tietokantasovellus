/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tietokanta;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ilmarihu
 */
//"jdbc:postgresql://localhost:5432/ilmarihu"
public class Yhteydet {

    Connection yhteys;

    public Connection getYhteys() {
        return yhteys;
    }

    public Yhteydet() {
        muodosta();
    }

    private void muodosta() {
        try {
            Class.forName("org.postgresql.Driver");
            yhteys = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ilmarihu");
        } catch (Exception e) {
        }
    }

    public void sulje() {
        try {
            yhteys.close();
        } catch (Exception e) {
        }
    }
}
