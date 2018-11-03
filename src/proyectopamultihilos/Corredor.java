package proyectopamultihilos;

import java.util.Random;
import javax.swing.JLabel;
/**
* UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO
* CENTRO UNIVERSITARIO UAEM ZUMPANGO
* INGENIERIA EN COMPUTACION
* PROGRAMACION AVANZADA 2018-B

* DESCRIPCION: Tema, Programación multi hilos; Proyecto Labels Race

* ARCHIVO: Corredor.java

* FECHA: 02/Noviembre/2018
* ALUMNOS(S): Juan Manuel Manjarrez Palacios
* PROFESOR: ASDRUBAL LOPEZ CHAU
*/
public class Corredor implements Runnable {
    
    JLabel label;
    private RecursoCompartido recursoCompartido;
    private int ancho = 0;
    
/**
 * Implementacion del método run para la programación multi hilos.
 */
    @Override
    public void run() {
        Random r = new Random(System.nanoTime());
        int avance = 0;
        while (avance < ancho) {
            if (r.nextInt(100) < 50) {
                avance++;
            } else {
                avance += 0;
            }
            label.setLocation(avance, label.getY());
            try {
                Thread.sleep(10 + r.nextInt(10));
            } catch (InterruptedException ex) {
            }
        }
        recursoCompartido.setNameWinner(label.getText());
    }

/**
 * Creación del constructor
 * @param label como parametro para iniciar la carrera.
 */
    public Corredor(JLabel label) {
        this.label = label;
    }
 
/**
 * Creación del constructor que recibe parametros específicos de la interfaz para la carrera.
 * @param label
 * @param recursoCompartido
 * @param ancho 
 */
    public Corredor(JLabel label, RecursoCompartido recursoCompartido, int ancho) {
        this(label);
        this.ancho = ancho;
        this.recursoCompartido = recursoCompartido;
    }

/**
 * Creación del get que obtendrá lo establecido en el archivo de RecursoCompartido.
 * @return recursoCompartido
 */
    public RecursoCompartido getRecursoCompartido() {
        return recursoCompartido;
    }

/**
 * Creación del set que usara el recurso compartido para cada hilo en ejecución.
 * @param recursoCompartido 
 */
    public void setRecursoCompartido(RecursoCompartido recursoCompartido) {
        this.recursoCompartido = recursoCompartido;
    }

/**
 * Creación del get que obtendrá el ancho de la ventana de interfaz.
 * @return ancho
 */
    public int getAncho() {
        return ancho;
    }

/**
 * Creación del set que ocupara el ancho de la ventana para hacer correr a los labels.
 * @param ancho 
 */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
}
