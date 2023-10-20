package com.example.pplabov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Usuario> listaDeUsuarios;
    public static AdapterUsuario adapterUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeUsuarios = new ArrayList<>();
        listaDeUsuarios.add(new Usuario("gabyAlegre0", "000000", Usuario.ETipoDeUser.Administrador));
        listaDeUsuarios.add(new Usuario("gabyAlegre1", "111111", Usuario.ETipoDeUser.Usuario));
        listaDeUsuarios.add(new Usuario("gabyAlegre2", "222222", Usuario.ETipoDeUser.Administrador));
        listaDeUsuarios.add(new Usuario("gabyAlegre3", "333333", Usuario.ETipoDeUser.Administrador));
        listaDeUsuarios.add(new Usuario("gabyAlegre4", "444444", Usuario.ETipoDeUser.Usuario));
        listaDeUsuarios.add(new Usuario("gabyAlegre5", "555555", Usuario.ETipoDeUser.Usuario));
        listaDeUsuarios.add(new Usuario("gabyAlegre6", "666666", Usuario.ETipoDeUser.Administrador));
        listaDeUsuarios.add(new Usuario("gabyAlegre7", "777777", Usuario.ETipoDeUser.Administrador));
        listaDeUsuarios.add(new Usuario("gabyAlegre8", "888888", Usuario.ETipoDeUser.Usuario));
        listaDeUsuarios.add(new Usuario("gabyAlegre9", "999999", Usuario.ETipoDeUser.Administrador));

        //Generamos nuestro objeto adapter y le pasamos la lista de usuarios
        adapterUsuario = new AdapterUsuario(listaDeUsuarios);

        //recuperamos el RecyclerView (el que esta en el activity_main.xml) de nuestra pantalla
        RecyclerView recyclerView = findViewById(R.id.rvUsuario);

        //Una vez que tenemos el RecyclerView y tenemos generado el adapter, al RecyclerView le decimos quien es el adapter
        recyclerView.setAdapter(adapterUsuario);

        //Cuando el RecyclerView ya tiene su adapter le tenemos que decir de que manera tiene que representar estos items
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}