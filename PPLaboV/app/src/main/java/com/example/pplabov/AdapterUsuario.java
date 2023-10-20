package com.example.pplabov;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterUsuario extends RecyclerView.Adapter<ViewHolderUsuario> {

    List<Usuario> listaDeUsuarios;

    public AdapterUsuario(List<Usuario> usuarios) {
        this.listaDeUsuarios = usuarios;
    }

    @NonNull
    @Override
    public ViewHolderUsuario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = null;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario,parent,false);
        return new ViewHolderUsuario(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUsuario holder, int position) {
        Usuario user = this.listaDeUsuarios.get(position);
        holder.tvNombreDeUsuario.setText(user.getUserName());
        holder.tvTipoDeUsuario.setText(user.getTipoDeUsuario()==Usuario.ETipoDeUser.Administrador?R.string.rdbAdministradorText:R.string.rdbUsuarioText);
    }

    @Override
    public int getItemCount() {
        return this.listaDeUsuarios.size();
    }
}
