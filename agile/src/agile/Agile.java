/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile;

import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author HugoP
 */
public class Agile {

    public double result(double prix, int nb, String tax) {
        double ptax = TAX(tax);

        double res = nb * prix ;
        res = discount(res);
        res = res + TAX(tax)*res ; 
        res = Math.round(res);
        return res;
    }

    public double TAX(String tax) {

        double ptax;
        switch (tax.toLowerCase()) {
            case "ut":
                ptax = 0.0685;
                break;
            case "nt":
                ptax = 0.08;
                break;
            case "tx":
                ptax = 0.0625;
                break;
            case "al":
                ptax = 0.04;
                break;
            case "ca":
                ptax = 0.0825;
                break;
            default:
                ptax = 0;

        }
        return ptax;
    }

    public double discount(double prixbrut) {
        if (prixbrut >= 1000) {
            if (prixbrut >= 5000) {
                if (prixbrut >= 7000) {
                    if (prixbrut >= 10000) {
                        if (prixbrut >= 50000) {
                            return prixbrut - prixbrut * 0.15;
                        }
                        return prixbrut - prixbrut * 0.010;
                    }
                    return prixbrut - prixbrut * 0.07;
                }
                return prixbrut - prixbrut * 0.05;
            }

            return prixbrut - prixbrut * 0.03;
        } else {
            return prixbrut;
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Agile x = new Agile();
        Scanner sc = new Scanner(System.in);
        System.out.println("Rentrez le prix (la virgule doit être un point)");
        String couille = sc.nextLine(); 
        double prix = Double.parseDouble(couille);
    
        int nb =0 ; boolean condi = true ; 
     while(condi){
          System.out.println("Rentrez le nb darticle avec un nombre positif entier");
        String couillebis = sc.nextLine() ;
         nb = Integer.parseInt(couillebis);
        if(nb > 0) condi = false ; 
     
     }
        System.out.println("Rentrez le code etat");
        String couilleTris = sc.nextLine();
       
       
      //  System.out.println(x.result(1000, 2, "uT"));
        
        System.out.println(x.result(prix, nb, couilleTris));
    }

}
