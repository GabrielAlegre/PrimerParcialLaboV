package com.example.pplabov;

import java.io.Serializable;

public class Usuario implements Serializable {

    public enum ETipoDeUser{
        Administrador,
        Usuario
    }
    private String userName;
    private String password;
    private ETipoDeUser tipoDeUsuario;

    public Usuario(){

    }
    public Usuario(String userName, String password, ETipoDeUser tipoDeUser) {
        this.userName = userName;
        this.password = password;
        this.tipoDeUsuario=tipoDeUser;
    }

    public ETipoDeUser getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(ETipoDeUser tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
