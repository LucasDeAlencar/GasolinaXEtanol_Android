package devandroid.lucas.appgaseta.apoio;

import android.telephony.CarrierConfigManager;

public class UtilGasEta {

    public void metodoNaoEstatico(){

    }

    public static void metodoEstatico(){

    }

    public static String Mensagem(){
        return "Compare o preço de Gasolina e Etanol\n (O valor da equivalencia é de \"30%\") " ;
    }

    public static String calcularMelhorOpcao(double gasolina, double etanol){
        double precoIdeal = gasolina * 0.70;

        String MensagemDeRetorno;

        if (etanol <= precoIdeal){
            MensagemDeRetorno = "Abasteça com Etanol";
        }else {
            MensagemDeRetorno = "Abasteça com Gasolina";
        }

        return MensagemDeRetorno;
    }



}
