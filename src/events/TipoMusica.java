/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package events;

/**
 *
 * @author hnleo
 */
public enum TipoMusica {
    POP(1), ROCK(2), RAP(3), CLASICA(4), REGGEATON(5), OTRO(6);
    
    private final int id;
    TipoMusica(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}
