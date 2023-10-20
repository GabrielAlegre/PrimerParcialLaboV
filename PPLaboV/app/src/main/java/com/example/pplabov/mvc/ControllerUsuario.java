package com.example.pplabov.mvc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.pplabov.MainActivity;
import com.example.pplabov.Usuario;
import com.example.pplabov.R;

public class ControllerUsuario implements View.OnClickListener {
    private ViewUsuario viewUser;
    private ModelUsuario modelUser;
    private  int indexDelUserQueSeModificara;
    public ControllerUsuario(ViewUsuario view, ModelUsuario model) {
        this.viewUser = view;
        this.modelUser = model;
    }

    @Override
    public void onClick(View v) {
        this.viewUser.llenarModelo();
        if(this.validarDatos() && this.verificarQueModificoAlgunCampo())
        {
            MainActivity.listaDeUsuarios.get(this.indexDelUserQueSeModificara).setUserName(modelUser.getUserName());
            MainActivity.listaDeUsuarios.get(this.indexDelUserQueSeModificara).setPassword(modelUser.getPassword());
            MainActivity.listaDeUsuarios.get(this.indexDelUserQueSeModificara).setTipoDeUsuario(modelUser.getTipoDeUsuario());
            MainActivity.adapterUsuario.notifyItemChanged(this.indexDelUserQueSeModificara);
            this.viewUser.ac.finish();
            Log.d("seModifico", "Modificacion correcta ahora el usuario quedo:\n"+modelUser.toString());
            Toast.makeText(v.getContext(), "Modificacion realizada correctamente al usuario en la posicion "+this.indexDelUserQueSeModificara, Toast.LENGTH_LONG).show();
        }
        else{
            Log.d("noModifico", "Verifique los datos ingresados!");
            viewUser.ac.cerrarTeclado();
        }
    }

    public void recuperarDatosDelUsuarioClickeado(){
        Bundle bundle = this.viewUser.ac.getIntent().getExtras();

        Usuario usuarioQueSeModificara = (Usuario) bundle.getSerializable("usuarioQueSeModificara");

        this.modelUser.setUserName(usuarioQueSeModificara.getUserName());
        this.modelUser.setPassword(usuarioQueSeModificara.getPassword());
        this.modelUser.setTipoDeUsuario(usuarioQueSeModificara.getTipoDeUsuario());
        this.indexDelUserQueSeModificara = bundle.getInt("indexDelElementoClickeado");
        this.viewUser.mostrarModel();
    }
    private boolean validarDatos(){
        return this.verificarQueIngresoDosContrasIguales() && this.verificarQueIngresoUnUserNameValido();
    }
    private boolean verificarQueIngresoUnUserNameValido(){
        if(this.modelUser.getUserName().length()>2 && this.modelUser.getUserName()!=null)
        {
            return true;
        }
        else{
            Toast.makeText(this.viewUser.ac.getApplicationContext(), "No se pudo modificar, el userName debe tener 3 o más caracteres", Toast.LENGTH_LONG).show();
            return false;
        }
    }
    private boolean verificarQueIngresoDosContrasIguales(){
        if(this.modelUser.getPassword().toString().isEmpty()==false && this.modelUser.getPassword()!=null)
        {
            if(this.modelUser.getPassword().equals(this.viewUser.editContraRepetida.getText().toString()))
            {
                return true;
            }
            else
            {
                Toast.makeText(this.viewUser.ac.getApplicationContext(), "No se pudo modificar, las contraseñas deben ser iguales", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this.viewUser.ac.getApplicationContext(), "Debe ingresar contraseña", Toast.LENGTH_LONG).show();
        }
        return false;
    }
    private boolean verificarQueModificoAlgunCampo(){
        Usuario usuarioQueSeModificaria = MainActivity.listaDeUsuarios.get(this.indexDelUserQueSeModificara);
        if(usuarioQueSeModificaria.getUserName().equals(modelUser.getUserName())
                && usuarioQueSeModificaria.getPassword().equals(modelUser.getPassword())
                && usuarioQueSeModificaria.getTipoDeUsuario().toString().equals(modelUser.getTipoDeUsuario().toString()))
        {
            Toast.makeText(this.viewUser.ac.getApplicationContext(), "No se aplico la modificacion ya que no modifico ningun campo", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    public Usuario.ETipoDeUser tipoDeUsuarioSeleccionado() {
        if (this.viewUser.rdbGroup.getCheckedRadioButtonId() == R.id.rdbAdministrador) {
            return Usuario.ETipoDeUser.Administrador;
        } else {
            return Usuario.ETipoDeUser.Usuario;
        }
    }
    public int idDelRadioQueSeDeberaSeleccionar() {
        if (this.modelUser.getTipoDeUsuario().toString().equals(ModelUsuario.ETipoDeUser.Administrador.toString())) {
            return R.id.rdbAdministrador;
        } else {
            return R.id.rdbUsuario;
        }
    }
}
