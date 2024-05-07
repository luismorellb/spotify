/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.spotify.entities;

/**
 *
 * @author Luis Morell
 */
public class Cancion {

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion Duracion de la canción expresada en segundos
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    private String titulo;
    private int duracion;
    
}
