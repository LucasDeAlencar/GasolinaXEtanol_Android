package devandroid.lucas.appgaseta.controller;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import devandroid.lucas.appgaseta.Model.Pessoa;
import devandroid.lucas.appgaseta.View.MainActivity;

public class PessoaController {

    SharedPreferences sharedPreferences;/*Salvara um determinado na forma de pares de valores-chave semelhantes a um Mapa*/
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){
        sharedPreferences = mainActivity.getSharedPreferences(NOME_PREFERENCES/*Nome do arquivo*/,0/*Modo de execulção*/);
        listaVip = sharedPreferences.edit();/*Aplicação da edição*/

    }


    @NonNull
    @Override
    public String toString() {

        return super.toString();
    }

    public void criarSharedPreferences(){

    }

    public void salvar(Pessoa pessoa) {
        listaVip.putString/*Envia*/("PrimeiroNome"/* A variavel*/,pessoa.getPrimeiroNome()/*O que ira adicionar*/);
        listaVip.putString/*Envia*/("sobreNome",pessoa.getSobreNome());
        listaVip.putString/*Envia*/("nomeCurso",pessoa.getCursoDesejado());
        listaVip.putString/*Envia*/("telefoneContato",pessoa.getTelefoneContato());
        listaVip.apply();/*Salvamento*/
    }

    public Pessoa buscar(Pessoa pessoa){

        /* Redefinição para a variavel "pessoa" usando o que está contido em "sharedPreferences"*/
        pessoa.setPrimeiroNome(sharedPreferences.getString("PrimeiroNome"/* A variavel */,null/* caso contrario retorna null */)/* Verifica se no sharedPreferences possui a variavel "PrimeiroNome" e retorna o valor da variavel caso não tenha retornara "NULL" */);
        pessoa.setSobreNome(sharedPreferences.getString("sobreNome"/* A variavel */,null/* caso contrario retorna null */)/* Verifica se no sharedPreferences possui a variavel "PrimeiroNome" e retorna o valor da variavel caso não tenha retornara "NULL" */);
        pessoa.setCursoDesejado(sharedPreferences.getString("nomeCurso"/* A variavel */,null/* caso contrario retorna null */)/* Verifica se no sharedPreferences possui a variavel "PrimeiroNome" e retorna o valor da variavel caso não tenha retornara "NULL" */);
        pessoa.setTelefoneContato(sharedPreferences.getString("telefoneContato"/* A variavel */,null/* caso contrario retorna null */)/* Verifica se no sharedPreferences possui a variavel "PrimeiroNome" e retorna o valor da variavel caso não tenha retornara "NULL" */);

        return pessoa;
    }

    public void limpar(){

        listaVip.clear();/* Limpa os valores associados no "sharedPreferences" */
        listaVip.apply();/* Aplica as aplicações associadas a "listaVip"*/

    }


}
