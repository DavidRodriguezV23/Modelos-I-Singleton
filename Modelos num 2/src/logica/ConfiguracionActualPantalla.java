/*
 * Descripción: Clase singleton correspondiente a la configuración actual de la pantalla
 * Fecha: 24/08/2019    
 * Versión: 1.0
 */
package logica;

import javax.swing.JOptionPane;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sanchez Tabares
 */

public class ConfiguracionActualPantalla {

    //Atributos
    private int porcentajeBrillo;
    private int porcentajeContraste;
    private int porcentajeNitidez;
    private boolean modoLectura;

    private static ConfiguracionActualPantalla configuracion = null;
    
    private ConfiguracionActualPantalla(int porcentajeBrillo, int porcentajeContraste,
            int porcentajeNitidez, boolean modoLectura){
            this.porcentajeBrillo = porcentajeBrillo;
            this.porcentajeContraste = porcentajeContraste;
            this.porcentajeNitidez = porcentajeNitidez;
            this.modoLectura = modoLectura;

    }

    static public ConfiguracionActualPantalla getConfiguracion(int porcentajeBrillo, int porcentajeContraste,
            int porcentajeNitidez, boolean modoLectura) {
        if(configuracion==null){
            configuracion= new ConfiguracionActualPantalla(porcentajeBrillo, 
                    porcentajeContraste, porcentajeNitidez, modoLectura);
        }
        return configuracion;
    }

    //Getters and setters
    public int getPorcentajeBrillo() {
        return porcentajeBrillo;
    }

    public void setPorcentajeBrillo(int porcentajeBrillo) {
        this.porcentajeBrillo = porcentajeBrillo;
    }

    public int getPorcentajeContraste() {
        return porcentajeContraste;
    }

    public void setPorcentajeContraste(int porcentajeContraste) {
        this.porcentajeContraste = porcentajeContraste;
    }

    public int getPorcentajeNitidez() {
        return porcentajeNitidez;
    }

    public void setPorcentajeNitidez(int porcentajeNitidez) {
        this.porcentajeNitidez = porcentajeNitidez;
    }

    public boolean isModoLectura() {
        return modoLectura;
    }

    public void setModoLectura(boolean modoLectura) {
        this.modoLectura = modoLectura;
    }
    
}
