package Laboratorio_1_Collections;
/**
 * @author "Rolando Murillo Aguirre"
 * 
 * Clase de tipo estudiante, la cual determinará los datos requeridos para la 
 * lista
 */
public class EstudianteLab_1 {
    private String carne;
    private String correo;
    private String name;

    public EstudianteLab_1() {
        this.carne = "No inciado";
        this.correo = "No inciado" ;
        this.name = "No inciado";
    }
    
        public EstudianteLab_1(String nameP, String carneP, String correoP) {
        this.carne = carneP;
        this.correo = correoP;
        this.name = nameP;
    }

    /**
     * @return the carne
     */
    public String getCarne() {
        return carne;
    }

    /**
     * @param carne the carne to set
     */
    public void setCarne(String carne) {
        this.carne = carne;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
    return getCarne()+"\t\t"+getName()+"\t\t"+getCorreo();
    }
}
