package android.example.miscontactos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_TELEFONO = "telefono" ;
    public static final String EXTRA_EMAIL = "email" ;
    private static final int ASK_QUESTION_REQUEST = 1;
    //Declaramos las variables miembro necesarias
    private ArrayList<Contacto> listContactos;
    private Agenda agenda = new Agenda();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Llenamos la agenda con los elementos por defecto
        agenda.filledAgenda();
        //Instanciamos el arrayList de contactos para trabajar con el
        listContactos=agenda.getContactos();
        //Construimos el listView
        showList();
        //Dotamos de comportamiento al listViewm
        onClicklistView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_create_contact:
                Intent intent = new Intent(MainActivity.this, NuevoContacto.class);
                startActivityForResult(intent, ASK_QUESTION_REQUEST);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ASK_QUESTION_REQUEST){
            if(resultCode == RESULT_OK){
                String nombre = data.getStringExtra("name");
                String telefono = data.getStringExtra("telefono");
                String email = data.getStringExtra("email");
                listContactos.add(new Contacto(nombre,telefono,email));
            }
        }
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