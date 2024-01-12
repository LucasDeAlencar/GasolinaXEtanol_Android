package devandroid.lucas.appgaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import java.util.List;

import devandroid.lucas.appgaseta.Model.Combustivel;
import devandroid.lucas.appgaseta.View.GasEtaActivity;
import devandroid.lucas.appgaseta.database.GaseEtaDB;

public class CombustivelController extends GaseEtaDB {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(@NonNull GasEtaActivity activity){
        super(activity);

        preferences = activity.getSharedPreferences(NOME_PREFERENCES,0);

        dadosPreferences = preferences.edit();

    }

    public void salvar(Combustivel combustivel){

        ContentValues dados = new ContentValues();

        dadosPreferences.putString("combustivel",combustivel.getNomeDoCombustível());
        dadosPreferences.putFloat("precoDoCombustivel", (float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendacao", combustivel.getRecomendacao());
        dadosPreferences.apply();

        dados.put("nomeDoCombustível", combustivel.getNomeDoCombustível());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());


        SalvarObjeto("Combustivel", dados);

    }

    public List<Combustivel> getListaDeDados(){

        return listarDados();
    }

    public void alterar(Combustivel combustivel){

        ContentValues dados = new ContentValues();

        dados.put("id", combustivel.getId());
        dados.put("nomeDoCombustível", combustivel.getNomeDoCombustível());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        alterarObjeto("Combustivel",dados);

    }

    public void deletar(int id){
        deletarObjeto("Combustivel", id);
    }


    public void limpar(){

        dadosPreferences.clear();
        dadosPreferences.apply();
    }

}
