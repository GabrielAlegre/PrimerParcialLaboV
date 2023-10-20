package com.example.pplabov;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderUsuario extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView tvNombreDeUsuario;
    TextView tvTipoDeUsuario;
    ImageButton BtnImgButton;
    public ViewHolderUsuario(@NonNull View itemView) {
        super(itemView);
        this.tvNombreDeUsuario=this.itemView.findViewById(R.id.tvNombreUser);
        this.tvTipoDeUsuario=this.itemView.findViewById(R.id.tvTipoUser);
        this.BtnImgButton=this.itemView.findViewById(R.id.btnImgEditar);
        this.BtnImgButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int indiceDelUsuarioClickeado = super.getAdapterPosition();
        Log.d("Selecciono", "se hizo click en: "+ indiceDelUsuarioClickeado);
        Intent i = new Intent(view.getContext(), ActivityEditar.class);
        i.putExtra("usuarioQueSeModificara", MainActivity.listaDeUsuarios.get(indiceDelUsuarioClickeado));
        i.putExtra("indexDelElementoClickeado", indiceDelUsuarioClickeado);
        view.getContext().startActivity(i);
    }
}
