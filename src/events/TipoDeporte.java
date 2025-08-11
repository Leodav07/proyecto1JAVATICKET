/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package events;

/**
 *
 * @author hnleo
 */
public enum TipoDeporte {
    FUTBOL(1), TENIS(2), RUGBY(3), BASEBALL(4);
    private final int id;
    TipoDeporte(int id){
    
    this.id = id;
    }
    
    public int getId(){
        return id;
    }

}
