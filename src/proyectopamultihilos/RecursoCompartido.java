package proyectopamultihilos;

import javax.swing.JLabel;
/**
* UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO
* CENTRO UNIVERSITARIO UAEM ZUMPANGO
* INGENIERIA EN COMPUTACION
* PROGRAMACION AVANZADA 2018-B

* DESCRIPCION: Tema, Programación multi hilos; Proyecto Labels Race

* ARCHIVO: RecursoCompartido.java

* FECHA: 02/Noviembre/2018
* ALUMNOS(S): Juan Manuel Manjarrez Palacios
* PROFESOR: ASDRUBAL LOPEZ CHAU
*/
public class RecursoCompartido {
    
    JLabel label;
    private boolean flagWinner = false; //True  = someone has arrived
    private String nameWinner = "";
    
/**
 * Creación de constructor que recibe como parametro label.
 * @param label 
 */
    public RecursoCompartido(JLabel label) {
        this.label = label;
    }

/**
 * Creación del get que obtendrá un calor verdadero cuando un label gane.
 * @return flagWinner
 */
    public synchronized boolean isFlagWinner() {
        return flagWinner;
    }
    
/**
 * Creación del set con exclusión mútua que cambiarña cuando gane un label.
 * @param flagWinner 
 */
    public synchronized void setFlagWinner(boolean flagWinner) {
        this.flagWinner = flagWinner;
    }
    
/**
 * Creación del get que obtendrá el nombre del label ganador.
 * @return nammeWinner
 */
    public String getNameWinner() {
        return nameWinner;
    }
    
/**
 * Creación del set que recibira y mostrará el nombre del label ganador.
 * @param nameWinner 
 */
    public synchronized void setNameWinner(String nameWinner) {
        if (!isFlagWinner()) {
            this.nameWinner = nameWinner;
            flagWinner = true;
            System.out.println("El ganador es: " + nameWinner);
            label.setText(nameWinner);
        } else {
            System.out.println("Soy " + nameWinner + ", ya gano otro.");
        }
        
    }
}
