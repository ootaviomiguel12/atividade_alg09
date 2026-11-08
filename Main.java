import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    calculoTemperatura();
    matrizTriangulos();
    }

    public static void calculoTemperatura (){
        var scan = new Scanner(System.in);

        final int MINIMA = 0, MAXIMA = 1, MEDIA = 2;
        double matriz [][] = new double[10][3];

        for (int i = 0; i < matriz.length; i++){
            System.out.println("Digite a temperatura mínima do dia: " + (i + 1));
            matriz[i][MINIMA] = scan.nextDouble();

            System.out.println("Digite a temperatura máxima do dia: " + (i + 1));
            matriz[i][MAXIMA] = scan.nextDouble();

            matriz[i][MEDIA] = (matriz[i][MAXIMA] + matriz[i][MINIMA]) / 2.0;
        }

        int escolha;

        do {
            System.out.println("MENU");
            System.out.println("1. Temperatura mínima de todos os dias.");
            System.out.println("2. Temperatura máxima de todos os dias.");
            System.out.println("3. Maior variação de temperatura de todos os dias.");
            System.out.println("4. Sair do programa.");

            System.out.println("Digite a sua escolha: ");
            escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    double menorTemp = matriz[0][MINIMA];

                    for (int i = 0; i < matriz.length; i++){
                        if (matriz[i][MINIMA] < menorTemp){
                            menorTemp = matriz[i][MINIMA];
                        }
                    }
                    System.out.println("A menor temperatura registrada entre todos os dias foi: " + menorTemp);
                    break;

                case 2:
                    double maiorTemp = matriz[0][MAXIMA];

                    for (int i = 0; i < matriz.length; i++){
                        if (matriz[i][MAXIMA] > maiorTemp){
                            maiorTemp = matriz[i][MAXIMA];
                        }
                    }
                    System.out.println("A maior temperatura registrada entre todos os dias foi: " + maiorTemp);
                    break;

                case 3:
                    double maiorVariacao = matriz[0][MAXIMA] - matriz[0][MINIMA];
                    int diaMaiorVariacao = 1;

                    for (int i = 1; i < matriz.length; i++){
                        double variacaoAtual = matriz[i][MAXIMA] - matriz[i][MINIMA];

                        if (variacaoAtual > maiorVariacao){
                            maiorVariacao = matriz[i][MAXIMA] - matriz[i][MINIMA];
                            diaMaiorVariacao = i + 1;
                        }
                    }
                    System.out.println("A maior variação de temperatura registrada entre todos os dias foi: " + maiorVariacao);
                    System.out.println("O dia de maior variação de temperatura foi: " + diaMaiorVariacao);
                    break;

                case 4:
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Número inválido!");
                    System.out.println("Digite um numero de 1 a 4.");
            }

        } while (escolha != 4);

        scan.close();
    }

    public static void matrizTriangulos(){
        var scan = new Scanner(System.in);

        final int PRIMEIRAARESTA = 0, SEGUNDAARESTA = 1, TERCEIRAARESTA = 2;
        int equilatero = 0, isosceles = 0, escaleno = 0;
        double percentualEquilatero, percentualIsosceles, percentualEscaleno;

        double [][] matrizDeTriangulos = new double[10][3];

        for (int i = 0; i < matrizDeTriangulos.length; i++){
            System.out.println("Digite o tamanho da primeira aresta: ");
            matrizDeTriangulos[i][PRIMEIRAARESTA] = scan.nextDouble();

            System.out.println("Digite o tamanho da segunda aresta: ");
            matrizDeTriangulos[i][SEGUNDAARESTA] = scan.nextDouble();

            System.out.println("Digite o tamanho da terceira aresta: " );
            matrizDeTriangulos[i][TERCEIRAARESTA] = scan.nextDouble();

            double a = matrizDeTriangulos[i][PRIMEIRAARESTA];
            double b = matrizDeTriangulos[i][SEGUNDAARESTA];
            double c = matrizDeTriangulos[i][TERCEIRAARESTA];


            if (a == b && b == c) {
                equilatero++;
            }
            else if (a != b && a != c && b != c){
                escaleno++;
            }
            else {
                isosceles++;
            }
        }
        percentualEquilatero = (equilatero / 10.0) * 100.0;
        percentualIsosceles = (isosceles / 10.0) * 100.0;
        percentualEscaleno = (escaleno / 10.0) * 100.0;


        System.out.println("O percentual de triângulos equiláteros é: " + percentualEquilatero + "%");
        System.out.println("O percentual de triângulos isosceles é: " + percentualIsosceles + "%");
        System.out.println("O percentual de triângulos escalenos é: " + percentualEscaleno + "%");

        scan.close();
    }
}
