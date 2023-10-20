package com.example.pplabov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.pplabov.mvc.ControllerUsuario;
import com.example.pplabov.mvc.ModelUsuario;
import com.example.pplabov.mvc.ViewUsuario;

public class ActivityEditar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        ActionBar actionBar = super.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Modelo
        ModelUsuario usuarioModel = new ModelUsuario();
        //View
        ViewUsuario usuarioView = new ViewUsuario(this, usuarioModel);
        //Controler
        ControllerUsuario usuarioControler = new ControllerUsuario(usuarioView, usuarioModel);
        usuarioView.setControlador(usuarioControler);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void cerrarTeclado(){
        View view = this.getCurrentFocus();
        if(view!=null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

}