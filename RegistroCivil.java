/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebal
 */
public class RegistroCivil {
    private List<HashMap> regiones; 
    private Map<String, Persona> mapaRegion;

    public RegistroCivil() {
        this.regiones = new ArrayList<>();
        inicializarRegiones();
    }

    private void inicializarRegiones() {
        for (int i = 0; i < 16; i++) {
            regiones.add(new HashMap<>());
        }
    }

    public void agregarPersona(int indiceRegion, Persona persona) {
        if (indiceRegion >= 0 && indiceRegion < regiones.size()) {
            regiones.get(indiceRegion).put(persona.getRut(), persona);
        } else {
            System.out.println("Índice de región inválido.");
        }
    }

    public Persona buscarPorRut(String rut) {
        for (Map<String, Persona> mapaRegion : regiones) {
            if (mapaRegion.containsKey(rut)) {
                return mapaRegion.get(rut);
            }
        }
    }

    public void cambiarDomicilio(int region, String rut, int regionNew, String comunaNew){
        // se busca el index, se cambia de mapa el rut y se actualiza su comuna
    }
}
