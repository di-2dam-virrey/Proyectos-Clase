package android.example.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Declaramos las variables miembro necesarias
    private ArrayList<Contacto> listContactos;
    private Agenda agenda = new Agenda();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Llenamos la agenda con los elementos por defecto
        agenda.filledAgenda();
        //Instanciamos el arrayList de contactos para trabajar con el
        listContactos=agenda.getContactos();
        //Construimos el listView
        showList();
        //Dotamos de comportamiento al listViewm
        onClicklistView();
    }
    //método que nos construye el listView
    //mediante el uso de un adaptador
    public void showList(){
        listView = (ListView)findViewById(R.id.lstContactos);
        ArrayAdapter <Contacto> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listContactos
        );
        listView.setAdapter(adapter);
    }
    //método que añade el listener al listView
    //envia un intent con parámetros a la activity DetalleContacto
    public void onClicklistView(){
        AdapterView.OnItemClickListener itemClickListener=
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listView,
                                            View view,
                                            int position,
                                            long id) {
                        Intent intent = new Intent(MainActivity.this,DetalleContacto.class);
                        intent.putExtra(DetalleContacto.EXTRA_NAME,listContactos.get(position).getNombre());
                        intent.putExtra(DetalleContacto.EXTRA_PHONE,listContactos.get(position).getTelefono());
                        intent.putExtra(DetalleContacto.EXTRA_EMAIL,listContactos.get(position).getEmail());
                        startActivity(intent);
                        finish();
                    }
                };
        listView.setOnItemClickListener(itemClickListener);
    }
}