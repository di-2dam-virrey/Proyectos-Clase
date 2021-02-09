package android.example.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;


public class DetalleContacto extends AppCompatActivity {

    //Declaramos las constantes para el paso de los putExtra.
    public static final String EXTRA_NAME = "Name" ;
    public static final String EXTRA_PHONE = "Phone";
    public static final String EXTRA_EMAIL = "Email";

    //Declaramos los elementos visuales que vamos a usar en el layout
    private TextView name;
    private TextView phone;
    private TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        //Recuperamos el Bundle con los extras del Intent
        Bundle data = getIntent().getExtras();

        //Rellenamos el textView nombre
        name = findViewById(R.id.tvNombre);
        name.setText(data.getString("Name"));

        //Rellenamos el textView phone
        phone = findViewById(R.id.tvTelefono);
        phone.setText(data.getString("Phone"));

        //Rellenamos el textView email
        email = findViewById(R.id.tvEmail);
        email.setText(data.getString("Email"));
    }
    //Definimos los métodos que son llamados en los linearLayout
    //Metodo llamada telefónica
    public void llamar(View v){
        String telefono = phone.getText().toString();
        Uri call = Uri.parse("tel:" + telefono);
        Intent intent = new Intent(Intent.ACTION_DIAL, call);
        startActivity(intent);

    }
    //Metodo enviar email
    public void enviarMail(View v){
        String address = email.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        // solo email apps deben manejar esto
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, address);
        startActivity(Intent.createChooser(intent, "Email"));
    }
    //Metodo para controlar la pulsación de la tecla hacia atras.
   public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
          Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
          startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}