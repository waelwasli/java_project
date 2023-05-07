/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author user
 */
public class Ecole {

    public Ecole(String nom ,String adress) {
        this.Nom=nom;
        this.Adress=adress;
        
    }
    private String Nom;
    private String Adress;

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    @Override
    public String toString() {
        return "Ecole{" + "Nom=" + Nom + ", Adress=" + Adress + '}';
    }
}
