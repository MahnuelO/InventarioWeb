/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Usuario
 */
public class AppException extends Exception{
    public AppException(String mensaje) {
        super(mensaje);
    }

    public AppException(Exception e) {
        super(e);
    }
}
