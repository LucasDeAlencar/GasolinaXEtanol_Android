package devandroid.lucas.appgaseta.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.lucas.appgaseta.Model.CursoDesejado;

public class CursoController {

    private List listaCursos;

    public List getListadeCursos(){

        listaCursos = new ArrayList<CursoDesejado>();

        listaCursos.add(new CursoDesejado("Java"));
        listaCursos.add(new CursoDesejado("HTML"));
        listaCursos.add(new CursoDesejado("C#"));
        listaCursos.add(new CursoDesejado("Python"));
        listaCursos.add(new CursoDesejado("PHP"));
        listaCursos.add(new CursoDesejado("Java EE"));
        listaCursos.add(new CursoDesejado("Flutter"));
        listaCursos.add(new CursoDesejado("Dart"));

        return listaCursos;
    }

    public ArrayList<String> dadosParaSpiner(){
        ArrayList<String> dados = new ArrayList<>();

        for(int i = 0; i < getListadeCursos().size(); i++){

            CursoDesejado objeto = (CursoDesejado) getListadeCursos().get(i);
            dados.add(objeto.getNomeDoCursoDesejado());
        }
        return dados;
    }
}
