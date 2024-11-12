/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Random;

/**
 *
 * @author huerd
 */
public class Ahorcado {

    private String[][] palabras = {{"POO", "TECLADO", "SOFWARE", "SERVIDOR", "JAVA"},
    {"PERRO", "GATO", "CAPIBARA", "FLAMENCO", "UNICORNIO", "BURRO", "OSO", "BALLENA"},
    {"ENCHILADAS", "TACOS", "BURRITOS", "CHILAQUILES", "ATUN", "MARUCHAN", "MILANESA"},
    {"MEXICO", "CANADA", "AUSTRALIA", "PERU", "BRAZIL", "RUSIA", "USA", "ITALIA"}};
    private String palabra;
    private char letra;     //entrada
    private int errores;
    private boolean[] acertadas;
    private int categoria;      //entrada 
    private String display;

    public void setLetra(char letra) {
        this.letra = letra;

    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;

    }

    public String getPalabra() {
        return palabra;
    }

    public char getLetra() {
        return letra;
    }

    public int getErrores() {
        return errores;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getDisplay() {
        return display;
    }

    public void seleccionarPalabra() {
        Random aleatorio = new Random();
        int x;
        x = aleatorio.nextInt(palabras[categoria].length);
        palabra = palabras[categoria][x];
        acertadas = new boolean[palabra.length()];
        for(int k=0;k<palabra.length();k++){
            if(palabra .charAt(k)==' '){
                acertadas[k]=true
            }
        }

    }

    public void generarDisplay() {
        //recorrer el arreglo "acertadas"
        display = "";
        for (int i = 0; i < acertadas.length; i++) {
            if (acertadas[i] == true) {
                display += palabra.charAt(i) + " ";
            } else {
                display += "_ ";
            }
        }
    }

    public boolean verificar() {
        char letra2;
        boolean banOk = false;
        for (int i = 0; i < palabra.length(); i++) {
            letra2 = palabra.charAt(i);
            if (letra == letra2) {
                acertadas[i] = true;
                banOk = true;
            }
        }
        if (!banOk) {
            errores++;

        }
        return banOk;
    }

    public boolean yaPerdio() {
        return(errores >= 8);
    }

    public boolean yaGano() {
        boolean banOk=true;
        for(int i=0;i<acertadas.length;i++){
            if(!acertadas[i]){
                banOk= false;
                break;
               
            }
        }
        return banOk;
    }
    
    }//Fin de la clase
