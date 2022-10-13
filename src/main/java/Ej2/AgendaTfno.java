package Ej2;

import java.util.HashMap;
import java.util.Map;

public class AgendaTfno {

    private Map agenda = new HashMap();

    public void añadeTelefono(String nombre, String tfno) {
        agenda.put(nombre, tfno);
    }

    public String getTfno(String nombre) {
        return (String) agenda.get(nombre);
    }

    public boolean contieneNombre(String nombre){
        return this.agenda.containsKey(nombre);
    }
}
