package com.example.pplabov.mvc;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.pplabov.ActivityEditar;
import com.example.pplabov.R;

public class ViewUsuario {
    Button btnGuardar;
    ModelUsuario usuarioModel;
    ActivityEditar ac;
    EditText editNombreDeUsuario;
    EditText editContra;
    EditText editContraRepetida;
    ControllerUsuario controllerUser;
    RadioGroup rdbGroup;
    public ViewUsuario(ActivityEditar ac, ModelUsuario userModel){
        this.ac=ac;
        this.usuarioModel=userModel;
    }
    public void setControlador(ControllerUsuario controladorUser){
        this.controllerUser=controladorUser;
        this.cargarElementos();
    }
    public void cargarElementos(){
        if(this.editNombreDeUsuario==null){
            this.editNombreDeUsuario=this.ac.findViewById(R.id.edNombreUser);
        }
        if(this.editContra==null){
            this.editContra=this.ac.findViewById(R.id.edContra);
        }
        if(this.editContraRepetida==null){
            this.editContraRepetida=this.ac.findViewById(R.id.edContraRepetida);
        }
        if(this.rdbGroup==null){
            this.rdbGroup=this.ac.findViewById(R.id.rdbGroup);
        }
        this.btnGuardar = ac.findViewById(R.id.btnGuardar);
        this.btnGuardar.setOnClickListener(controllerUser);
        this.controllerUser.recuperarDatosDelUsuarioClickeado();
    }
    public void llenarModelo(){
        this.usuarioModel.setUserName(this.editNombreDeUsuario.getText().toString());
        this.usuarioModel.setPassword(this.editContra.getText().toString());
        this.usuarioModel.setTipoDeUsuario(this.controllerUser.tipoDeUsuarioSeleccionado());
    }

    public void mostrarModel(){
        this.editNombreDeUsuario.setText(this.usuarioModel.getUserName());
        //this.editContra.setText(this.usuarioModel.getPassword().toString());
        //this.editContraRepetida.setText(this.usuarioModel.getPassword().toString());
        this.rdbGroup.check(this.controllerUser.idDelRadioQueSeDeberaSeleccionar());
    }
}
