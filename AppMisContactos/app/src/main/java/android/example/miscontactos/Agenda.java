package android.example.miscontactos;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contacto> listContactos = new ArrayList<Contacto>();
    public void filledAgenda(){
        listContactos.add(new Contacto("Pedro Sanchez","123456789","contacto1@email.com"));
        listContactos.add(new Contacto("Pablo Iglesias","223456789","contacto2@email.com"));
        listContactos.add(new Contacto("Pablo Casado","323456789","contacto3@email.com"));
        listContactos.add(new Contacto("Santiago Abascal","423456789", "contacto4@email.com"));
        listContactos.add(new Contacto("Salvador Illa","523456789","contacto5@email.com"));
        listContactos.add(new Contacto("Fernando Simón","623456789","contacto6@email.com"));
    }
    public ArrayList getContactos(){
        return listContactos;
    }
}
