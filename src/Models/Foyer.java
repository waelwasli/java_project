/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author user
 */
public class Foyer {

    public Foyer(String nom, String adresse) {
        this.Nom=nom;
        this.Adresse=adresse;
    }
    private String Nom;
    private String Adresse;

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    @Override
    public String toString() {
        return "Foyer{" + "Nom=" + Nom + ", Adresse=" + Adresse + '}';
    }
    
}
