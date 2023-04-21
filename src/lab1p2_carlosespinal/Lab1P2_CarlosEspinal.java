
package lab1p2_carlosespinal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab1P2_CarlosEspinal {

    static Scanner read = new Scanner(System.in);
    
    public static void Menu(){
        System.out.println("--- MENU PRINCIPAL --- \n\n");
        System.out.println("1. Calculadora de Fechas");
        System.out.println("2. Numeros Palindromos \n\n");
        System.out.println("Ingrese la opcion con la que desea trabajar: ");
    }
    
    public static int[] arrayGenerator(String cad){
        int[] arrfinal = new int[cad.length()];
        
        for (int i = 0; i < arrfinal.length; i++) {
            String num = "";
            num += cad.charAt(i);
            int conv = Integer.parseInt(num);
            arrfinal[i] = conv;  
        }
        return arrfinal;
    }
    
    public static void derechaRec(ArrayList<Integer> lista, int posc,int[] array){
        int num;
        if (posc == array.length-1) {
            num = array[posc];
            lista.add(num);
            System.out.print(array[posc]);
        } else{
            num = array[posc];
            lista.add(num);
            System.out.print(array[posc]);
            derechaRec(lista,posc+1,array);
        }
        
    }
    
    public static void izquierdaRec(ArrayList<Integer> lista, int posc, int[] array){
        int num;
        if (posc == 0) {
            num = array[posc];
            System.out.print(array[posc]);
            lista.add(num);
        } else{
            num = array[posc];
            System.out.print(array[posc]);
            lista.add(num);
            izquierdaRec(lista, posc-1, array);
        }
        
    }
    
    public static void arr(int[] arrei){
        for (int i = 0; i < arrei.length; i++) {
            System.out.print(arrei[i]);
        }
    }
    
    
    public static void main(String[] args) {
        char resp = 's';
        do{
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
                    int mes = date1.getMonth()+1;
                    int y = date1.getYear()+1900;


                    int day2 = Integer.parseInt(tdate[0]);
                    int mes2 = Integer.parseInt(tdate[1]);
                    int y2 = Integer.parseInt(tdate[2]);
                    if (day2 > 31 || day2 < 1 || mes2 > 12 || mes2 < 1) {
                        System.out.println("Uno de los datos ingresados en la fecha es invalido, favor ingresar una fecha valida.");
                    }
                    else{
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

                        System.out.println("Fecha actual: "+sdf2.format(date1));
                        System.out.println("Fecha a comparar: "+sdf2.format(date2));
                        System.out.println("Years: "+yf);
                        System.out.println("Meses: "+mesf);
                        System.out.println("Dias: "+dayf);
                    }

                    break;
                case 2:
                    ArrayList<Integer> listaright = new ArrayList<>();
                    ArrayList<Integer> listaleft = new ArrayList<>();
                    System.out.println("Ingrese una cadena de numeros:  ");
                    String cadnumeros = read.next();
                    int [] arraynum = arrayGenerator(cadnumeros);
                    if (cadnumeros.length()%2 != 0 ) {
                        derechaRec(listaright, 0, arraynum);
                        izquierdaRec(listaleft, arraynum.length-1, arraynum);
                        
                        if (listaright.equals(listaleft)) {
                            System.out.println("El numero ingresado es palindromo");
                        } else{
                            System.out.println("El numero ingresado no es palindromo");
                        }
                        
                        
                        
                    }else{
                        
                        System.out.println("La cadena de numeros ingresada no es impar.");
                    }
                    listaright.clear();
                    listaleft.clear();
                    break;

            }
            System.out.println("Desea seguir utilizando el programa?[S/N]: ");
            resp = read.next().charAt(0);
        }while(resp == 's' || resp == 'S');
    }

    private static SimpleDateFormat SimpleDateFormat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
