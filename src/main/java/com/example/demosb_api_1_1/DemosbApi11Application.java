package com.example.demosb_api_1_1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class DemosbApi11Application implements CommandLineRunner {



    @Value("${spring.datasource.url}")
    String url ;
    @Value("${spring.datasource.username}")
    String userid;
    @Value("${spring.datasource.password}")
    String password;


    public static void main(String[] args) {
        SpringApplication.run(DemosbApi11Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
 /*  String userid = "ora23";
        String password = "Mansour123";
        String server = "mons-oracle19.condorcet.be";
        String port = "1521";
        String database="orcl.condorcet.be";
        url = "jdbc:oracle:thin:@//" + server + ":" + port + "/" + database;//construit l'URL de la base de données*/
        Connection dbConnect=null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            dbConnect = DriverManager.getConnection(url, userid, password);
            // connexion avec le login et le password
            // et récupération d'un objet connection
        }
        catch (Exception e){
            System.out.println("erreur : "+e);
            System.exit(0);
        }

        try(
                Statement stmt = dbConnect.createStatement();
                //représente une requête SQL
                ResultSet rs = stmt.executeQuery("select * from APICOURS ");
                //récupération des données à partir de la table client
                //ensemble des lignes répondant à la requête
        )
        {
            while (rs.next()) {
                int id_cours = rs.getInt("ID_COURS");
                String matière = rs.getString("MATIERE");
                int heures = rs.getInt("HEURES");
                System.out.println(id_cours + " " + matière + " " + heures);
            }
        } catch (SQLException e) {
            System.out.println("erreur SQL " + e);
        } catch (Exception e) {
            System.out.println("erreur " + e);
        }
        try{
            dbConnect.close();
        } catch (SQLException e) {
            System.out.println("erreur de fermeture de connexion "+e);
        }

    }
}
