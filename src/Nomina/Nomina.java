/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nomina;
import Sleer1.SLeer1;
import Calcular.Main;
/**
 *
 * @author jmanuel
 */
public class Nomina {
    
    private double irpf;
    private double contcom;
    private double fp;
    private double paro;
    private double totalaport;
    private double totalbruto;
    private double totalneto;
    private double adeducir;
    private double FOGASA;
    private double baseSS;
    private double baseirpf;
    private double fpAport;
    private double paroAport;
    private double atepAport;
    private double totalaportdeduccion;
    
    public Nomina(Empresa e1, Trabajador t1){
        devengos(t1.getGrupCot(),t1.getPerliq());
        deducciones();
        aportEmp();        
        printNomina(e1,t1);
    }
    
    public void devengos(char grupCot, double diaLiq){
        if(grupCot=='A'){
            totalbruto=((26790.31d/12d)/30d)*diaLiq;
        }
        else{
            totalbruto=((25986.59d/12d)/30d)*diaLiq;
        }
    }
    
    public void deducciones(){
        double icc=4.7;
        double ifp=0.1;
        double iparo=1.6;
        double iirpf=2.0;
        
        contcom=totalbruto*icc/100;
        paro=totalbruto*iparo/100;
        fp=totalbruto*ifp/100;
        irpf=totalbruto*iirpf/100;
        adeducir=contcom+paro+fp+irpf;
        totalaportdeduccion=contcom+paro+fp;
        totalneto=totalbruto-adeducir;
    }
    
    public double getContingencias(){ return contcom; }
    public double getDesempleo(){ return paro; }
    public double getFP(){ return fp; }
    public double getTotalAportDeducciones(){ return totalaportdeduccion; }
    
    public void aportEmp(){
        double ibaseSS=23.6;
        double iatep=1.5;
        double iparo=6.7;
        double ifp=0.6;
        double iFOGASA=0.2;
        
        baseSS=totalbruto*ibaseSS/100;
        atepAport=totalbruto*iatep/100;
        paroAport=totalbruto*iparo/100;
        fpAport=totalbruto*ifp/100;
        FOGASA=totalbruto*iFOGASA/100;
        
        baseirpf=totalbruto;
        totalaport = baseSS+atepAport+paroAport+fpAport+FOGASA;
        
    }
    
    public void printNomina(Empresa e1, Trabajador t1){
            SLeer1.limpiar();
            System.out.println("\n\n\n\nNOMINA");
            System.out.println("#####################################################");
            System.out.println("Empresa: "+e1.getNom());
            System.out.println("Direccion: "+e1.getDir());
            System.out.println("CIF: "+e1.getCif());
            System.out.print("CCC: ");
            Main.sacaCcc(e1.getCcc());
            System.out.println("\n-----------------------------------------------------");
            System.out.println("Trabajador: "+t1.getNom());
            System.out.println("NIF: "+t1.getNif());
            System.out.println("Nºafiliación SS: "+t1.getNafSS());
            System.out.println("Grupo profesional: "+t1.getGrupProf());
            System.out.println("Grupo cotización: "+t1.getGrupCot());
            System.out.println("F. Antigüedad: "+t1.getFecAnt());
            System.out.println("-----------------------------------------------------");
            System.out.println(Main.getMensajeliq());
            System.out.println("-----------------------------------------------------");
            System.out.println("I DEVENGOS");
            System.out.println("Salario base:\t\t\t"+Main.redondear(getTotalbruto(),2)); // MODIFICAR 15 -> periodoliquidacion
            System.out.println("\nII DEDUCCIONES");
            System.out.println("Contingencias comunes:\t4,70%\t"+Main.redondear(getContingencias(),2));
            System.out.println("Desempleo:\t\t1,60%\t"+Main.redondear(getDesempleo(),2));
            System.out.println("Formación profesional:\t0,10%\t"+Main.redondear(getFP(),2));
            System.out.println("\nTOTAL DEVENGADO:\t\t"+Main.redondear(getTotalbruto(),2)); // MODIFICAR 15 -> periodoliquidacion
            System.out.println("TOTAL APORTACIONES:\t\t"+Main.redondear(getTotalAportDeducciones(),2));
            System.out.println("IRPF:\t\t\t2,00%\t"+Main.redondear(getIrpf(),2));
            System.out.println("TOTAL A DEDUCIR:\t\t"+Main.redondear(getAdeducir(),2));
            System.out.println("\nLIQUIDO TOTAL A PERCIBIR:\t"+Main.redondear(getTotalneto(),2));
            System.out.println("#####################################################");
            System.out.println("Base de cotizacion a la SS:\t"+Main.redondear(getTotalbruto(),2)+"\t23,60%\t"+Main.redondear(getBaseSS(),2));
            System.out.println("\nBase de contigencias profesionales: "+Main.redondear(getTotalbruto(),2)); // MODIFICAR 15 -> periodoliquidacion
            System.out.println("\tAT y EP:\t\t1,50%\t"+Main.redondear(getAtEp(),2));
            System.out.println("\tDesempleo:\t\t6,70%\t"+Main.redondear(getParoAport(),2));
            System.out.println("\tFormación profesional:\t0,60%\t"+Main.redondear(getFpAport(),2));
            System.out.println("\tFondo Garantia Social:\t0,20%\t"+Main.redondear(getFOGASA(),2));
            System.out.println("Total aportación empresarial:\t\t"+Main.redondear(getTotalaport(),2));
            System.out.println("#####################################################");
 
    }
    
    public double getBaseSS(){ return baseSS; }
    public double getAtEp() { return atepAport; }
    public double getParoAport() { return paroAport; }
    public double getFpAport() { return fpAport; }
    public double getFOGASA() { return FOGASA; }
    
    public double getIrpf(){
        return irpf;
    }
    
    public void setIrpf(double irpf){
        this.irpf=irpf;
    }
    
    public double getContcom(){
        return contcom;
    }
    
    public void setContcom(double contcom){
        this.contcom=contcom;
    }
    
    public double getFp(){
        return fp;
    }
    
    public void setFp(double fp){
        this.fp=fp;             
    }
    
    public double getParo(){
        return paro;
    }
    
    public void setParo(double paro){
        this.paro=paro;
    }
    
    public double getTotalaport(){
        return totalaport;
    }
    
    public void setTotalaport(double totalaport){
        this.totalaport=totalaport;
    }
    
    public double getTotalbruto(){
        return totalbruto;
    }
           
    
    public void setTotalbruto(double totalbruto){
        this.totalbruto=totalbruto;
    }
    
    public double getTotalneto(){
        return totalneto;
    }
    
    public void setTotalneto(double totalneto){
        this.totalneto=totalneto;        
    }
    
    public double getAdeducir(){
        return adeducir;
    }
    
    public void setAdeducir(double adeducir){
        this.adeducir=adeducir;
    }
}
