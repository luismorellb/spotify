/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.spotify.entities;

/**
 *
 * @author Luis Morell
 */
public class Artista {

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
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the followers
     */
    public int getFollowers() {
        return followers;
    }

    /**
     * @param followers the followers to set
     */
    public void setFollowers(int followers) {
        this.followers = followers;
    }

    /**
     * @return the oyentesMensuales
     */
    public int getOyentesMensuales() {
        return oyentesMensuales;
    }

    /**
     * @param oyentesMensuales the oyentesMensuales to set
     */
    public void setOyentesMensuales(int oyentesMensuales) {
        this.oyentesMensuales = oyentesMensuales;
    }
    
    private String nombre;
    private String perfil;
    private int followers;
    private int oyentesMensuales;
}
