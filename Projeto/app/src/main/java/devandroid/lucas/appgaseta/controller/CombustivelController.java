package devandroid.lucas.appgaseta.controller;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import devandroid.lucas.appgaseta.Model.Combustivel;
import devandroid.lucas.appgaseta.View.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(@NonNull GasEtaActivity activity){

        preferences = activity.getSharedPreferences(NOME_PREFERENCES,0);

        dadosPreferences = preferences.edit();

    }

    public void salvar(Combustivel combustivel){

        dadosPreferences.putString("combustivel",combustivel.getNomeDoCombustível());
        dadosPreferences.putFloat("precoDoCombustivel", (float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendacao", combustivel.getRecomendacao());
        dadosPreferences.apply();

    }

    public void limpar(){

        dadosPreferences.clear();
        dadosPreferences.apply();
    }

}
