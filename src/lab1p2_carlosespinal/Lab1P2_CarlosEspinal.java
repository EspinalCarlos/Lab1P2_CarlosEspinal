
package lab1p2_carlosespinal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Lab1P2_CarlosEspinal {

    static Scanner read = new Scanner(System.in);
    
    public static void Menu(){
        System.out.println("--- MENU PRINCIPAL --- \n\n");
        System.out.println("1. Calculadora de Fechas");
        System.out.println("2. Numeros Palindromos \n\n");
        System.out.println("Ingrese la opcion con la que desea trabajar: ");
    }
    
    public static void main(String[] args) {
        Menu();
        int opc = read.nextInt();
        
        switch (opc) {
            case 1:
                Date date1 = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("Ingrese la fecha que desea comparar de la siguiente manera (DIA-MES-AÑO): ");
                
                String sdate2 = read.next();
                String[] tdate = sdate2.split("-");
                
                int day = date1.getDate();
                System.out.println(day);
                int mes = date1.getMonth()+1;
                System.out.println(mes);
                int y = date1.getYear()+1900;
                System.out.println(y);
                
                int day2 = Integer.parseInt(tdate[0]);
                int mes2 = Integer.parseInt(tdate[1]);
                int y2 = Integer.parseInt(tdate[2]);
                Date date2 = new Date(y2-1900, mes2-1, day2);
                
                int dayf = 0;
                int mesf = 0;
                int yf = 0;
                
                if(day > day2){
                    dayf += day - day2;
                } else{
                    dayf = day2 - day;
                    
                }
                
                if(mes > mes2){
                    mesf += mes - mes2;
                } else{
                    mesf += mes2 - mes;
                }
                
                if(y > y2){
                    yf = y - y2;
                } else{
                    yf = y2-y;
                }
               
                System.out.println(sdf2.format(date1));
                System.out.println(sdf2.format(date2));
                System.out.println("Years: "+yf);
                System.out.println("Meses: "+mesf);
                System.out.println("Dias: "+dayf);
                
                
                
                
                
                
                
                break;
            case 2:
                
                break;
            
        }
    }

    private static SimpleDateFormat SimpleDateFormat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
