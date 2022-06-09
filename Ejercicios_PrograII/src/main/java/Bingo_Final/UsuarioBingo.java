package Bingo_Final;

/**
 *
 * @author "Rolando Murillo Aguirre"
 */
public class UsuarioBingo {

    private FlujoBingo flujoBingo;
    private String nombre;

    public UsuarioBingo(FlujoBingo flujoBingoP, String nombreP) {
        flujoBingo = flujoBingoP;
        nombre = nombreP;
    }

    /**
     * @return the flujoBingo
     */
    public FlujoBingo getFlujoBingo() {
        return flujoBingo;
    }

    /**
     * @param flujoBingo the flujoBingo to set
     */
    public void setFlujoBingo(FlujoBingo flujoBingo) {
        this.flujoBingo = flujoBingo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
