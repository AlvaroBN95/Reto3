/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nomina;

/**
 *
 * @author jmanuel
 */
public class Empresa {
    
    private String nom;
    private String dir;
    private String cif;
    private String ccc;
    
    public Empresa(){
        nom="Severo Ochoa S.L.";
        dir="Calle Illueca Nº28";
        cif="45678876X";
        ccc="12345678911234567891";
    }
    
    public Empresa(String nom, String dir, String cif, String ccc){
        this.nom=nom;
        this.dir=dir;
        this.cif=cif;
        this.ccc=ccc;        
    }
    
    public String getNom(){
        return nom;
    }
    
    public String getDir(){
        return dir;
    }
    
    public String getCif(){
        return cif;
    }
    
    public String getCcc(){
        return ccc;
    }
    
    public void setNom(String nom){
        this.nom=nom;
    }
    
    public void setDir(String dir){
        this.dir=dir;
    }
    
    public void setCif(String cif){
        this.cif=cif;
    }
    
    public void setCcc(String ccc){
        this.ccc=ccc;
    }
    
}
