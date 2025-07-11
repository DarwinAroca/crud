package CRUD;

public class Mascota {
    private String nombre;
    private String especie;
    private int edad;
    private Historial historial;
    // Constructor
    public Mascota(String nombre, String especie, int edad) {
        //*this.nombre = nombre;
        //this.especie = especie;
        //this.edad = edad;
        //Usar setters y historial
        setNombre(nombre);
        setEspecie(especie);
        setEdad(edad);
        this.historial = new Historial();
    }
    public void agregarConsulta(Consulta consulta) {
        historial.agregarConsulta(consulta);
    }

    public void mostrarHistorial() {
        System.out.println("Mascota: " + nombre + " | Especie: " + especie + " | Edad: " + edad + " años");
        System.out.println("Historial:");
        historial.mostrarConsultas();
}
    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para especie
    public String getEspecie() {
        return especie;
    }

    // Setter para especie
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    // Getter para edad
    public int getEdad() {
        return edad;
    }

    // Setter para edad con validación
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("Edad no válida.");
        }
    }



    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad);
    }
    public void agregarconsulta(Consulta consulta){

    }
}

