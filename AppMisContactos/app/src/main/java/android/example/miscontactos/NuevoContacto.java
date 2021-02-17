package android.example.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevoContacto extends AppCompatActivity {

    private EditText nombre;
    private EditText telefono;
    private EditText email;
    private Button btnAddContact;

    private String sNombre;
    private String sTelefono;
    private String sEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnAddContact = (Button)findViewById(R.id.btnAddContact);
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewContact();
            }
        });
    }

    private void addNewContact() {
        nombre = (EditText)findViewById(R.id.etvNombre);
        sNombre = nombre.getText().toString();
        telefono = (EditText)findViewById(R.id.etvTelefono);
        sTelefono = telefono.getText().toString();
        email = (EditText)findViewById(R.id.etvEmail);
        sEmail = email.getText().toString();
        Intent intent = new Intent(NuevoContacto.this, MainActivity.class);
        intent.putExtra(MainActivity.EXTRA_NAME,sNombre);
        intent.putExtra(MainActivity.EXTRA_TELEFONO,sTelefono);
        intent.putExtra(MainActivity.EXTRA_EMAIL,sEmail);
        setResult(MainActivity.RESULT_OK,intent);
        finish();
    }
}