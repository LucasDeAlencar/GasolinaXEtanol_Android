package devandroid.lucas.appgaseta.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.lucas.appgaseta.Model.Pessoa;
import devandroid.lucas.appgaseta.R;
import devandroid.lucas.appgaseta.controller.CursoController;
import devandroid.lucas.appgaseta.controller.PessoaController;

public class MainActivity extends AppCompatActivity {


    PessoaController controller;
    CursoController cursoController;
    Pessoa pessoa;
    List<String> nomesDosCursos;
//    Pessoa outraPessoa;
//
//    String dadosPessoa;
//    String dadosOutraPessoa;

    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editNomeCurso;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    Spinner spinner;

    /*Instancia o lanyout(TELA)*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        pessoa = new Pessoa();

        controller = new PessoaController(MainActivity.this);

        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosParaSpiner();

        /* Redefinição para a variavel "pessoa" usando o que está contido em "sharedPreferences"*/
        controller.buscar(pessoa);


        /*Associação ao XML pro JAVA*/
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editEtanol);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

       // Criação do Spinner e associação do Adapter
        spinner = findViewById(R.id.spinner);
        //Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this/* Qual classe está referenciando*/, android.R.layout.simple_list_item_1/* Layout do "Spinner" */,
                cursoController.dadosParaSpiner()/* Conteudo */);
        adapter.setDropDownViewResource/* Quando clicar */(android.R.layout.simple_list_item_1/* Mostrara o "Spinner" */);
        spinner.setAdapter/*define qual adapter está associado ao "Spinner"*/(adapter);

        /*Para ocupar o campo(Serve para o EditText)*/
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        /*Associar um comando ao click deste botão*/
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText(null);
                editSobreNome.setText(null);
                editNomeCurso.setText(null);
                editTelefoneContato.setText(null);

                controller.limpar();

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*E parecido com o JOptionPane*/
                Toast.makeText(MainActivity.this/*Está referenciando a propria classe */,
                        "Volte Sempre",
                        Toast.LENGTH_LONG/*Pede para demorar um tempo antes de execultar*/).show();
                finish();/*Fecha a aplicação*/
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa NovaPessoa = new Pessoa(
                        editPrimeiroNome.getText().toString(),
                        editSobreNome.getText().toString(),
                        editNomeCurso.getText().toString(),
                        editTelefoneContato.getText().toString()
                );

                    Toast.makeText(
                            MainActivity.this,
                            "Foi criado com sucesso o usuario: \n\" " + NovaPessoa.getPrimeiroNome() + " " + NovaPessoa.getSobreNome() + " \" ",
                            Toast.LENGTH_LONG
                    ).show();

                    controller.salvar(NovaPessoa);
            }
        });

    }
}