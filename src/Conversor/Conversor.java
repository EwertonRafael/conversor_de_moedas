package Conversor;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    private int escolha = 0;
    private double quantidade = 0;

    public int getEscolha() { return escolha; }
    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }
    public double getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getMenu() {
        return  """
                ******************************************
                Seja bem vindo ao conversor de moedas
                
                1) Dólar ==> Peso argentino
                2) Peso argentino ==> Dólar
                3) Dólar ==> Real brasileiro
                4) Real brasileiro ==> Dólar
                5) Dólar ==> Peso colombiano
                6) Peso colombiano ==> Dólar
                7) Sair
                
                ******************************************""";
    }
    public double dolar_pesoArg(double quantidade) {
        return converterMoeda("USD","ARS", quantidade);
    }

    public double pesoArg_Dólar(double quantidade) {
        return converterMoeda("ARS","USD", quantidade);
    }

    public double dolar_real(double quantidade) {
        return converterMoeda("USD","BRL", quantidade);
    }

    public double real_dolar(double quantidade) {
        return converterMoeda("BRL","USD", quantidade);
    }

    public double dolar_pesoColomb(double quantidade) {
        return converterMoeda("USD","COP", quantidade);
    }

    public double pesoColomb_dolar(double quantidade) {
        return converterMoeda("COP","USD", quantidade);
    }
    private double converterMoeda(String moedaOrigem, String moedaDestino, double quantidade) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/b3389e6b2e457da71d0d7a78/latest/" + moedaOrigem))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonElement element = JsonParser.parseString(response.body());
            JsonObject obj = element.getAsJsonObject();
            JsonObject rates = obj.getAsJsonObject("conversion_rates");
            double taxa = rates.get(moedaDestino).getAsDouble();
            return quantidade * taxa;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao fazer a solicitação HTTP", e);
        }
    }
}



