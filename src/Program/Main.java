package Program;

import Conversor.Conversor;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Conversor conversor = new Conversor();

        try {
            while (conversor.getEscolha() != 7) {
                System.out.println(conversor.getMenu());
                System.out.print("Escolha um Número: ");
                conversor.setEscolha(sc.nextInt());

                if(conversor.getEscolha() == 7) {
                    System.out.println("Saindo do programa...\n");
                }else if(conversor.getEscolha() >= 7){
                    System.out.println("\nEscolha Inválida\n");
                }else{
                    System.out.print("entre com a quantia: ");
                    conversor.setQuantidade(sc.nextDouble());
                }

                switch (conversor.getEscolha()) {
                    case 1:
                        System.out.println("\nA quantia de " + conversor.getQuantidade() + " em Dólar corresponde ao valor final de " + conversor.dolar_pesoArg(conversor.getQuantidade()) + " em Peso argentino\n");
                        break;
                    case 2:
                        System.out.println("\nA quantia de " + conversor.getQuantidade() + " em Peso argentino corresponde ao valor final de " + conversor.pesoArg_Dólar(conversor.getQuantidade()) + " em Dólar\n");
                        break;
                    case 3:
                        System.out.println("\nA quantia de " + conversor.getQuantidade() + " em Dólar corresponde ao valor final de " + conversor.dolar_real(conversor.getQuantidade()) + " em Real brasileiro\n");
                        break;
                    case 4:
                        System.out.println("\nA quantia de " + conversor.getQuantidade() + " em Real brasileiro corresponde ao valor final de " + conversor.real_dolar(conversor.getQuantidade()) + " em Dólar\n");
                        break;
                    case 5:
                        System.out.println("\nA quantia de " + conversor.getQuantidade() + " em Dólar corresponde ao valor final de " + conversor.dolar_pesoColomb(conversor.getQuantidade()) + " em Peso colombiano\n");
                        break;
                    case 6:
                        System.out.println("\nA quantia de " + conversor.getQuantidade() + " em Peso colombiano corresponde ao valor final de " + conversor.pesoColomb_dolar(conversor.getQuantidade()) + " em Dólar\n");
                        break;
                    case 7:
                        break;
                    default:
                        break;
                }
            }
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
    }
}