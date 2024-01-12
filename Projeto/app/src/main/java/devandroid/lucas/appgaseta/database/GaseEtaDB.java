package devandroid.lucas.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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

}
