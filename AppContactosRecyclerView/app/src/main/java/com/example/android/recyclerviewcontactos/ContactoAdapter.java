package com.example.android.recyclerviewcontactos;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdapter(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }
    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private TextView tvEmailCV;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView)itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = (TextView)itemView.findViewById(R.id.tvTelefonoCV);
            tvEmailCV = (TextView) itemView.findViewById(R.id.tvEmailCV);
        }
    }
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
        Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        contactoViewHolder.tvEmailCV.setText(contacto.getEmail());

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,contacto.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }
}
