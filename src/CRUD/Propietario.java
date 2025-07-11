package CRUD;
import java.util.ArrayList;

public class Propietario {

    private String nombre;
    private String documento;
    private String telefono;

    private ArrayList<Mascota> mascotas = new ArrayList<>();

// Código del Taller 3
  //  public Propietario(String nombre, long documento, long telefono) {
    //    this.nombre = nombre;
      //  this.documento = documento;
       // this.telefono = telefono;
   // }


    // Uso de setters
    public Propietario(String nombre, String documento, String telefono) {
        setNombre(nombre);
        setDocumento(documento);
        setTelefono(telefono);
        this.mascotas = new ArrayList<>();
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }


    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        if (documento == null || documento.length() < 5) {
            throw new IllegalArgumentException("Documento inválido, debe tener mínimo 5 caracteres.");
        }
        this.documento = documento;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 7) {
            throw new IllegalArgumentException("Teléfono inválido, debe tener mínimo 7 caracteres.");
        }
        this.telefono = telefono;
}

    public void agregarMascota(Mascota m) {
        if (m != null) {
            mascotas.add(m);
 }}
        public void mostrarMascotas() {
            System.out.println("Propietario: " + nombre);
            System.out.println("Documento: " + documento);
            System.out.println("Numero de Telefono: " + telefono);
            System.out.println();

            for (Mascota m : mascotas) {
                m.mostrarHistorial();
 }
}


 }

