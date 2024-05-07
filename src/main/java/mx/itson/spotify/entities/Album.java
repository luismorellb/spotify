/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.spotify.entities;

import com.google.gson.Gson;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Morell
 */
public class Album {

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the artista
     */
    public Artista getArtista() {
        return artista;
    }

    /**
     * @param atista the atista to set
     */
    public void setArtista(Artista atista) {
        this.artista = artista;
    }

    /**
     * @return the fechaLanzamiento
     */
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    /**
     * @param fechaLanzamiento the fechaLanzamiento to set
     */
    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    /**
     * @return the canciones
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    private String nombre;
    private Artista artista;
    private Date fechaLanzamiento;
    private List<Cancion> canciones;
    private String genero;
    
    public Album deserializar(String json){
        Album album = new Album();
        try{
            album = new Gson().fromJson(json, Album.class);
        } catch(Exception ex){
            System.err.println("Ocurrió un error al deserializar" + ex.getMessage());
        }
        return album;
    }
}