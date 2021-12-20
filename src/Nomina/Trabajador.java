/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nomina;
import Calcular.Main;
/**
 *
 * @author jmanuel
 */
public class Trabajador {
    
    private String nom;
    private String nif;
    private String grupProf;
    private char grupCot;
    private String nafSS;
    private String fecAnt;
    private int perliq;
    
    public Trabajador(){
        nom="Rosa María de los Cármenes";
        nif="67458779C";
        grupProf="Subalternos";
        grupCot='A';
        nafSS="3546576878";
        fecAnt="12/01/2005";
        perliq=30;
        Main.setMensajeliq("Perdiódo de liquidación: del 01/01/2021 al 31/01/2021");
    }
    
    public Trabajador(String nom, String nif, String grupProf, char grupCot, String nafSS, String fecAnt, int perliq){
        this.nom=nom;
        this.nif=nif;
        this.grupProf="Subalternos"; // MODIFICAR por this.grupProf=grupProf cuando se pueda cambiar el grupo profesional
        this.grupCot=grupCot; 
        this.nafSS=nafSS;
        this.fecAnt=fecAnt;
        this.perliq=perliq;
    }
    
    public String getNom(){
        return nom;
    }
    public String getNif(){
        return nif;
    }
    public String getGrupProf(){
        return grupProf;
    }
    public char getGrupCot(){
        return grupCot;
    }
    public String getNafSS(){
        return nafSS;
    }
    public String getFecAnt(){
        return fecAnt;
    }
    
    public void setNom(String nom){
        this.nom=nom;
    }
    public void setNif(String nif){
        this.nif=nif;
    }
    public void setGrupProf(String grupProf){
        this.grupProf=grupProf;
    }
    public void setGrupCot(char grupCot){
        this.grupCot=grupCot;
    }
    public void setNafSS(String nafSS){
        this.nafSS=nafSS;
    }
    public void setFecAnt(String fecAnt){
        this.fecAnt=fecAnt;
    }

    public int getPerliq() {
        return perliq;
    }

    public void setPerliq(int perliq) {
        this.perliq = perliq;
    }
    
    
}
