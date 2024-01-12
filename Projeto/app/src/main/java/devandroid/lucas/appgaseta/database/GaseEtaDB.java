package devandroid.lucas.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import devandroid.lucas.appgaseta.Model.Combustivel;

public class GaseEtaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public GaseEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabelaVeiculo = "CREATE TABLE Veiculo (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoCarro TEXT, " +
                "placaDoCarro TEXT)";

        String sqlTabelaCombustivel = "CREATE TABLE Combustivel (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoCombustível TEXT, " +
                "precoDoCombustivel REAL," +
                "recomendacao TEXT)";

        db.execSQL(sqlTabelaCombustivel);
        db.execSQL(sqlTabelaVeiculo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void SalvarObjeto(String tabela,
                             ContentValues dados){

        db.insert(tabela,null, dados);

    }
    // Criar métodos para implementar um CRUD

    public List<Combustivel> listarDados(){
        List<Combustivel> lista = new ArrayList<>();

        /* Representa os registros no Banco de Dados*/
        Combustivel registro;

        String querySQL = "select * from Combustivel";

        cursor/*gera as informações apartir de um comando SQL*/ =
                db.rawQuery(querySQL/*A query SQL*/,null/*O WHERE*/);

        if (cursor.moveToFirst()/*Faz começar no primeiro registro retornando TRUE caso tenha*/){

            do {

                registro = new Combustivel();

                registro.setId(cursor.getInt(0/*A coluna que ira pegar o valor*/));

                registro.setNomeDoCombustível(cursor.getString(1));

                registro.setPrecoDoCombustivel(cursor.getDouble(2));

                registro.setRecomendacao(cursor.getString(3));

                lista.add(registro);

            }while (cursor.moveToNext()/*Vai para o proximo registro caso tenha retorna TRUE*/);

        }else{

        }


        return lista;
    }

    public void alterarObjeto(String tabela,ContentValues dados){

        int id = dados.getAsInteger("id");

        db.update(tabela, dados, "id=?",new String[]{Integer.toString(id)});

    }
    public void deletarObjeto(String tabela,int id){

        db.delete(tabela, "id=?",
                new String[]{Integer.toString(id)/*predominara o ?*/});

    }

}
