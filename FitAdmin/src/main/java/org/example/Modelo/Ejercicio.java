package org.example.Modelo;

import java.io.Serializable;
import java.util.Objects;

public class Ejercicio implements Serializable {
    //atributos

    private int idEjercicio;
    private String tipoDeEjercicio; //cardio, empuje, traccion
    private String nombreEjercicio; //ej: curl de bicep
    private String grupoMuscular; //hombros,piernas,core,brazos,espalda,pecho
    private String complejidad; //facil,medio,dificil
    private String materialDeTrabajo; //barra,mancuerna,peso libre,maquina,kettlebell,polea,bandas
    private int repeticiones;
    private int series;
    //constructores



    public Ejercicio()
    {
        tipoDeEjercicio="Sin tipo de ejercicio";
        nombreEjercicio="Sin nombre ejercicio";
        grupoMuscular="Sin grupo muscular";
        complejidad="Sin complejidad";
        materialDeTrabajo="Sin material de trabajo";
        repeticiones=-1;
        series=-1;
        idEjercicio=-1;
    }

    public Ejercicio(String tipoDeEjercicio, String nombreEjercicio, String grupoMuscular, String complejidad, String materialDeTrabajo, int repeticiones, int series,int idEjercicio) {
        this.tipoDeEjercicio = tipoDeEjercicio;
        this.nombreEjercicio = nombreEjercicio;
        this.grupoMuscular = grupoMuscular;
        this.complejidad = complejidad;
        this.materialDeTrabajo = materialDeTrabajo;
        this.repeticiones = repeticiones;
        this.series = series;
        this.idEjercicio=idEjercicio; //todo: VER SI EL ID VIENE DESDE EL JSON O LO AUTOINCREMENTAMOS NOSOTROS
    }
    public Ejercicio(String tipoDeEjercicio, String nombreEjercicio, String grupoMuscular, String complejidad, String materialDeTrabajo,int idEjercicio) {//ESTE CONSTRUCTOR ME SIRVE PARA CONSUMIR EL JSON
        this.tipoDeEjercicio = tipoDeEjercicio;
        this.nombreEjercicio = nombreEjercicio;
        this.grupoMuscular = grupoMuscular;
        this.complejidad = complejidad;
        this.materialDeTrabajo = materialDeTrabajo;
        this.repeticiones = 0;
        this.series = 0;
        this.idEjercicio=idEjercicio; //todo: VER SI EL ID VIENE DESDE EL JSON O LO AUTOINCREMENTAMOS NOSOTROS
    }

    public Ejercicio(String nombreEjercicio, String complejidad, String materialDeTrabajo) {
        this.nombreEjercicio = nombreEjercicio;
        this.complejidad = complejidad;
        this.materialDeTrabajo = materialDeTrabajo;
    }



    //get y set

    public String getTipoDeEjercicio() {
        return tipoDeEjercicio;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public String getComplejidad() {
        return complejidad;
    }

    public String getMaterialDeTrabajo() {
        return materialDeTrabajo;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public int getSeries() {
        return series;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setTipoDeEjercicio(String tipoDeEjercicio) {
        this.tipoDeEjercicio = tipoDeEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public void setComplejidad(String complejidad) {
        this.complejidad = complejidad;
    }

    public void setMaterialDeTrabajo(String materialDeTrabajo) {
        this.materialDeTrabajo = materialDeTrabajo;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public void setSeries(int series) {
        this.series = series;
    }


    //metodos


    @Override
    public boolean equals(Object o) {
        boolean rta = false;

        if(o != null)
        {
            if(o instanceof Ejercicio aComparar)
            {

                if (this.idEjercicio == aComparar.idEjercicio){
                    rta=true;
                }

//                if(this.getTipoDeEjercicio().equalsIgnoreCase(aComparar.getTipoDeEjercicio()) && this.getNombreEjercicio().equalsIgnoreCase(aComparar.getNombreEjercicio()))
//                {
//                    //si el tipo de ejercicio y el nombre son iguales retorno true
//                    rta = true;
//                }
            }
        }

        return rta;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Ejercicio{" +
                "idEjercicio=" + idEjercicio +
                ", tipoDeEjercicio='" + tipoDeEjercicio + '\'' +
                ", nombreEjercicio='" + nombreEjercicio + '\'' +
                ", grupoMuscular='" + grupoMuscular + '\'' +
                ", complejidad='" + complejidad + '\'' +
                ", materialDeTrabajo='" + materialDeTrabajo + '\'' +
                ", repeticiones=" + repeticiones +
                ", series=" + series +
                '}' + "\n";
    }
}
