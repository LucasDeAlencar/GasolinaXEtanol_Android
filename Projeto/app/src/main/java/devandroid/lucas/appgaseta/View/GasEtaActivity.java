package devandroid.lucas.appgaseta.View;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.lucas.appgaseta.Model.Combustivel;
import devandroid.lucas.appgaseta.R;
import devandroid.lucas.appgaseta.apoio.UtilGasEta;
import devandroid.lucas.appgaseta.controller.CombustivelController;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController combustivelController;
    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    EditText editEtanol;
    EditText editGasolina;
    TextView txtResultado;
    Button btnLimpar;
    Button btnCalcular;
    Button btnFinalizar;
    Button btnSalvar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        Toast.makeText(GasEtaActivity.this,UtilGasEta.Mensagem(),Toast.LENGTH_LONG).show();

        /*Associação ao XML*/
        btnCalcular = findViewById(R.id.btnCalcular);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        editEtanol = findViewById(R.id.editEtanol);
        editGasolina = findViewById(R.id.editGasolina);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosok = true;

                if (TextUtils.isEmpty(editGasolina.getText()) ) {
                    editGasolina.setError("* Obrigatorio");/*Mostra uma mensagem de erro*/
                    editGasolina.requestFocus();/*Foca no campo*/
                    isDadosok = false;
                }if (TextUtils.isEmpty(editEtanol.getText())) {
                    editEtanol.setError("* Obrigatorio");/*Mostra uma mensagem de erro*/
                    editEtanol.requestFocus();/*Foca no campo*/
                    isDadosok = false;
                }

                if(isDadosok){
                    txtResultado.setText(UtilGasEta.calcularMelhorOpcao(
                            Double.parseDouble(editGasolina.getText().toString()),
                            Double.parseDouble(editEtanol.getText().toString())
                    ));

                    btnSalvar.setEnabled(true);


                }else {
                    Toast.makeText(GasEtaActivity.this,
                            " Por favor, digite os dados obrigatorios",Toast.LENGTH_LONG).show();
                    btnSalvar.setEnabled(false);
                }


            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                combustivelController = new CombustivelController(GasEtaActivity.this);

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeDoCombustível("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(Double.parseDouble(editGasolina.getText().toString()));

                combustivelEtanol.setNomeDoCombustível("Etanol");
                combustivelGasolina.setPrecoDoCombustivel(Double.parseDouble(editGasolina.getText().toString()));

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(
                        Double.parseDouble(editGasolina.getText().toString()),
                        Double.parseDouble(editEtanol.getText().toString())
                ));

                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(
                        Double.parseDouble(editGasolina.getText().toString()),
                        Double.parseDouble(editEtanol.getText().toString())
                ));

                combustivelController.salvar(combustivelGasolina);
                combustivelController.salvar(combustivelEtanol);

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*E parecido com o JOptionPane*/
                Toast.makeText(GasEtaActivity.this/*Está referenciando a propria classe */,
                        "Volte Sempre",
                        Toast.LENGTH_LONG/*Pede para demorar um tempo antes de execultar*/).show();
                finish();/*Fecha a aplicação*/
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editEtanol.setText(null);
                editGasolina.setText(null);
                txtResultado.setText("RESULTADO");

                btnSalvar.setEnabled(false);

                combustivelController.limpar();
            }
        });
    }
}
