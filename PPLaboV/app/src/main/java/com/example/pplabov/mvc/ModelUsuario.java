package com.example.pplabov.mvc;

import com.example.pplabov.Usuario;

public class ModelUsuario {
    public enum ETipoDeUser{
        Administrador,
        Usuario
    }
    private String userName;
    private String password;
    private Usuario.ETipoDeUser tipoDeUsuario;

    public ModelUsuario(){

    }
    public ModelUsuario(String userName, String password, Usuario.ETipoDeUser tipoDeUser) {
        this.userName = userName;
        this.password = password;
        this.tipoDeUsuario=tipoDeUser;
    }

    public Usuario.ETipoDeUser getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(Usuario.ETipoDeUser tipoDeUsuario) {
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
