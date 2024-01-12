package devandroid.lucas.appgaseta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.lucas.appgaseta.View.GasEtaActivity;
import devandroid.lucas.appgaseta.View.MainActivity;
import devandroid.lucas.appgaseta.database.GaseEtaDB;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;/*Variavel guardara o tempo que ira iniciar (3s)*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        cumularTelaSplash();

    }

    private void cumularTelaSplash() {

        new Handler().postDelayed(new Runnable() /*Defini apôs quantos segundos irá iniciar*/{
            @Override
            public void run() /*O que ira fazer no processamento*/{

                GaseEtaDB db = new GaseEtaDB(SplashActivity.this);

                Intent/*Serve par mudar de tela*/ telaPrincipal =
                   new Intent(SplashActivity.this/*Aonde você está*/, GasEtaActivity.class/*Aonde vai*/);

                startActivity(telaPrincipal);/*Muda de tela*/
                finish();/* Fecha a tela atual */
            }
        },TIME_OUT_SPLASH/*O tempo que ira caregar*/);

    }
}