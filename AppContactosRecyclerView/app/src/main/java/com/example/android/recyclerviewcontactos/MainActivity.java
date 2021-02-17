package com.example.android.recyclerviewcontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListaContactos();
        listaContactos = (RecyclerView)findViewById(R.id.rvContactos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(linearLayoutManager);
        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        listaContactos.setLayoutManager(gridLayoutManager);*/
        ContactoAdapter adapter = new ContactoAdapter(contactos,this);
        listaContactos.setAdapter(adapter);
    }

    public void initListaContactos() {
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.pedro_sanchez,"Pedro Sanchez","123456789","direccion1@correo.es"));
        contactos.add(new Contacto(R.drawable.pablo_iglesias, "Pablo Iglesias","223456789", "direccion2@correo.es"));
        contactos.add(new Contacto(R.drawable.pablo_casado, "Pablo Casado", "323456789", "dirección3@correo.es"));
        contactos.add(new Contacto(R.drawable.santiago_abascal, "Santiago Abascal", "423456789", "direccion4@correo.es"));
        contactos.add(new Contacto(R.drawable.salvador_illa, "Salvador Illa", "523456789","dirección5@correo.es"));
        contactos.add(new Contacto(R.drawable.fernando_simon, "Fernando Simon", "623456789", "direccion6@correo.es"));
    }

}