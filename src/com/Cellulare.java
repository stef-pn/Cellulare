package com;
import java.util.Scanner;

public class Cellulare {
	
    public double credito = 0.0; //credito iniziale
    public int chiamate = 0; //quantità chiamate iniziale
    public double tariffa = 0.6; //tariffa iniziale
    public double minuti;
    public double costoChiamata;
    public boolean acceso = true;


    Scanner scanner = new Scanner(System.in);

    public void mostraMenu() {
       
      while (acceso) {

        System.out.println("\n Scegli l'operazione che vuoi compiere tra le seguenti, digitando il numero corrispondente: \n 1.Ricarica \n 2.Imposta tariffa \n 3.Chiama \n 4.Visualizza il tuo credito \n 5.Registro chiamate \n 6.Resetta le chiamate \n 0.Spegni");

        int scelta = scanner.nextInt();

        switch (scelta) {
            case 1:
                ricarica();
                break;
            case 2:
                impostaTariffa();
                break;
            case 3:
                chiama();
                break;
            case 4:
                visualizzaCredito();
                break;
            case 5:
                registro();
                break;
            case 6:
                resettaChiamate();
                break;
            case 0:
                acceso = false;
                System.out.println("Arrivederci!");          
                break;
            default:
                System.out.println("Operazione non consentita");
                break;
            
        } 
        System.out.println();
        
        }    
  
        
    }
  
    public void ricarica() {
     System.out.println("Digita l'importo da ricaricare:");
     double ricarica = scanner.nextDouble();

     if (ricarica <= 0) {
        System.out.println("Errore, non puoi ricaricare un importo negativo");

     } else {
        credito += ricarica;
        System.out.println("La ricarica di " + ricarica + " euro è andata a buon fine");
     }
 
    }

    public void impostaTariffa() {
     System.out.println("\n Digita 1. per passare al piano tariffario di 0.20 euro/minuto. \n Digita 2. per tornare al menù principale");
     int scegli = scanner.nextInt();
     switch (scegli) {
        case 1:
            tariffa = 0.20;
            System.out.println("L'operazione è andata a buon fine. Il tuo piano tariffario ora è di " + tariffa + " euro/minuto");
            break;
        case 2:
            break;
        default:
            System.out.println("Operazione non consentita");
            impostaTariffa();
            break;
     }

    }

    public void chiama() { 
        //Serve un if a inizio chiama() per controllare il credito prima di procedere oltre.

        System.out.println("Digita il numero da chiamare:");
        String numero = scanner.next();
        System.out.println("Stai chiamando il numero " + numero);
        System.out.println("Quanti minuti durerà la tua chiamata?");
        minuti = scanner.nextInt();
        costoChiamata = tariffa * minuti;

        if (minuti < 0){
            System.out.println("La durata di una chiamata non può essere negativa");
        } else {
            if (costoChiamata > credito){
                credito = 0;
                chiamate++;
                System.out.println("Il tuo credito non è sufficiente per effettuare la chiamata");
                 
            } else {           
                credito -= costoChiamata;
                chiamate++;
                System.out.println("Il tuo credito residuo è di " + credito + " euro");
            
            }
        
        }
       
    }


    public void visualizzaCredito() {
        System.out.println("Il tuo credito residuo è di: " + credito + " euro");
    
    }

    public void registro() {
        System.out.println("Hai effettuato " + chiamate + " chiamate effettuate");
    
    }

    public void resettaChiamate() {
        System.out.println("Hai resettato le chiamate effettuate!");
        chiamate = 0;
        
    }

}