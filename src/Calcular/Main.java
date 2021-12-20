package Calcular;

import Nomina.*;
import Sleer1.SLeer1;

/**
 *
 * @author jmanuel
 */
public class Main {

//Atributos de la clase
    private static String mensajeliq; //Usado para guardar el periódo de liquidación.
    private static char repetir;

//Método redondear    
    public static double redondear(double numero, int decimales) {
        return Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
    }

//Métodos de control de entrada de datos    
    public static String pideNom() {
        String nom = SLeer1.datoString("Introduzca el nombre: ");
        return nom;
    }

    public static String pideNif() {
        String nif = "";
        do {
            nif = SLeer1.datoString("Introduzca el NIF (CIF): ");
            if (nif.length() != 9) {
                System.err.println("El NIF (CIF) debe tener una longitud de 9 carácteres (8 números y una letra)\n");
            }
        } while (nif.length() != 9);
        return nif;
    }

    public static String pideDir() {
        String dir = SLeer1.datoString("Introduzca la dirección: ");
        return dir;
    }

    public static String pideCcc() {
        String ccc = "";
        do {
            ccc = SLeer1.datoString("Introduzca el CCC: ");
            if (ccc.length() != 20) {
                System.out.println("El CCC debe tener una longitud de 20 carácteres (números)");
            }
        } while (ccc.length() != 20);
        return ccc;
    }

    public static String pideGrupProf() {
        /*String grupProf=SLeer1.datoString("Introduzca su grupo profesional: "); <-- DESCOMENTAR CUANDO SE PUEDA MODIFICAR, BORRAR return"Subalternos";
        return grupProf;*/
        return "Subalternos";
    }

    public static char pideGrupCot() {
        char grupCot = 'A';
        do {
            grupCot = SLeer1.datoChar("Introduzca su grupo de cotización (A o B): ");
            if (grupCot == 'a' || grupCot == 'b') {
                grupCot -= 'a';
                grupCot += 'A';
            }
            if (grupCot != 'A' && grupCot != 'B') {
                System.err.println("Ese grupo no está contemplado en la normativa actual.\n");
            }
        } while (grupCot != 'A' && grupCot != 'B');
        return grupCot;
    }

    public static String pideNafSS() {
        String nafSS = "";
        do {
            nafSS = SLeer1.datoString("Introduzca el NAF: ");
            if (nafSS.length() != 12) {
                System.err.println("El NAF debe tener una longitud de 12 carácteres (números).\n");
            }
        } while (nafSS.length() != 12);
        return nafSS;
    }

//Métodos para pedir el día, mes y año. Se usan en otros métodos como el de pedir la fecha de antigüedad.
    public static int pideMes() {
        int mes = 0;

        do {
            mes = SLeer1.datoInt(" -Introduzca el mes: ");
            if (mes < 1 || mes > 12) {
                System.err.println(" -Ese mes no existe\n");
            }
        } while (mes < 1 || mes > 12);

        return mes;
    }

    public static int pideDia(int m) {
        int dia = 0;
        boolean ndias = true;

        do {
            ndias = true;
            dia = SLeer1.datoInt(" -Introduzca el día: ");
            if (dia > 0) {
                switch (m) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (dia > 31) {
                            ndias = false;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (dia > 30) {
                            ndias = false;
                        }
                        break;
                    case 2:
                        if (dia > 28) {
                            ndias = false;
                        }
                        break;
                    default:
                        return -1;
                }
                if (!ndias) {
                    System.err.println(" -Ese mes no tiene tantos días");
                }
            } else {
                System.err.println(" -Los días de los meses empiezan por el 1.");
            }
        } while (dia < 1 || !ndias);

        return dia;
    }

    public static int pideAnyo() {

        int anyo = SLeer1.datoInt(" -Introduzca el año: ");

        return anyo;
    }

//Pequeño método para ahorrarme tener que darle formato a la fecha cada vez que quiera sacarla por pantalla.
    public static String formatoFec(int d, int m, int a) {
        return d + "/" + m + "/" + a;
    }

//Pide la fecha de antigüedad del trabajador en la empresa
    public static String pideFecAnt() {
        System.out.println("Fecha de antigüedad");
        int a = pideAnyo();
        int m = pideMes();
        int d = pideDia(m);

        return formatoFec(d, m, a);
    }

//Saca el C.C.C. "formateado", es decir, con guiones y to esa movida    
    public static void sacaCcc(String ccc) {
        char[] ccchar = ccc.toCharArray();
        for (int i = 0; i < 20; i++) {
            System.out.print(ccchar[i]);
            if (i == 3 | i == 7 | i == 9) {
                System.out.print("-");
            }
        }
    }

//Pide el intervalo de días que ha trabajado en el mismo mes, por defecto el año es 2021    
    public static int pidePerLiq() {
        int a = 2021;
        int m = 0;
        int di = 0;
        int df = 0;
        int tot = 0;
        System.out.println("\nPERIODO DE LIQUIDACIÓN");
        m = pideMes();
        System.out.println(" +Día de inicio");
        di = pideDia(m);
        System.out.println(" +Día de finalización");
        do {
            df = pideDia(m);
            if (df < di) {
                System.err.println(" El día de finalización no puede ser anterior al día de inicio");
            }
        } while (df < di);

        tot = (df - di + 1);

        mensajeliq = "Periodo de liquidación: del " + formatoFec(di, m, a) + " al " + formatoFec(df, m, a);

        return tot;
    }

    public static String getMensajeliq() {
        return mensajeliq;
    }

    public static void setMensajeliq(String mensajeliq) {
        Main.mensajeliq = mensajeliq;
    }

    public static char getRepetir() {
        return repetir;
    }

    public static void setRepetir(char repetir) {
        Main.repetir = repetir;
    }

    public static void limpiar() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

public static void main(String[] args) {
    
        int cont=0;
        do{            
            if(cont > 0){
                limpiar();
            }
            cont++;
            
            Trabajador t1=new Trabajador(pideNom(),pideNif(),pideGrupProf(),pideGrupCot(),pideNafSS(),pideFecAnt(),pidePerLiq());
            //Trabajador t1=new Trabajador();
            Empresa e1=new Empresa();
            Nomina no=new Nomina(e1,t1);
                        
            setRepetir(SLeer1.datoChar("Para continuar pulse S:\t"));
            if (getRepetir() == 's') {
                setRepetir('S');
            }
            
        }while(getRepetir() =='S');       
    }
}


