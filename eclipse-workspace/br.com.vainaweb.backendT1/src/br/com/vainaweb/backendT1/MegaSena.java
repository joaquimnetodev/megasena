//Desenvolvido por JOAQUIM BATISTA DA SILVA NETO

//A escolha do intervalo de 0 a 100 foi baseada na MEGA SENA atual que não permite os números 0 e 100

package br.com.vainaweb.backendT1;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class MegaSena {
	public static void main(String[] args) {
		System.out.println("MEGA-SENA");
		System.out.println("\nREGRAS:");
		System.out.println(". Escolher 7 números, individualmente, entre 0 e 100;");
		System.out.println(". Escolher somente números inteiros; ");
		System.out.println(". Não serão aceitos números repetidos.");
		System.out.println("\nPREMIAÇÃO: ");
		System.out.println(". 7 acertos: 200 mil reais;");
		System.out.println(". 6 acertos: 50 mil reais;");
		System.out.println(". 5 acertos: 10 mil reais.");
		System.out.println("\nVAMOS COMEÇAR!");

		int[] numerosEscolhidos = new int[7];
		int numeroDigitado = 0;
		int posicaoAtual = 0;
		boolean numeroCorreto = false;
		Scanner sc = new Scanner(System.in);

		// receber os números do usuários e efetuar as validações
		while (numeroCorreto == false && posicaoAtual < 7) {
			System.out.print("\nDigite um número para a " + (posicaoAtual + 1) + "ª posição: ");
			try {
				numeroDigitado = sc.nextInt();
				numeroCorreto = true;
			} catch (Exception e) {
				System.out.println("Esperava-se um número inteiro.");
				sc.next();
			}
			if (numeroCorreto == true) {
				if (numeroDigitado < 1 || numeroDigitado > 99) {
					System.out.println("Esperava-se um número entre 0 e 100.");
					numeroCorreto = false;
				} else {
					for (int i = 0; i < 7; i++) {
						if (numeroDigitado == numerosEscolhidos[i]) {
							System.out.println("Você escolheu um número repetido.");
							numeroCorreto = false;
							i = 7;
						} else {
							numeroCorreto = true;
						}
					}
				}
			}
			if (numeroCorreto == true) {
				numerosEscolhidos[posicaoAtual] = numeroDigitado;
				posicaoAtual++;
				numeroCorreto = false;
			}
		}
		sc.close();

		// ordenar em ordem crescente os números escolhidos e mostrar ao usuário
		Arrays.sort(numerosEscolhidos);
		System.out.println("Você escolheu os números: " + Arrays.toString(numerosEscolhidos));

		// sorteando os números
		int[] numerosSorteados = new int[7];
		int posicaoSorteio = 0;
		while(posicaoSorteio < 7) {
			boolean numeroRepetido = false;
			Random rdn = new Random();
			int numeroAleatorio = rdn.nextInt(99) + 1;
			for(int i = 0; i < 7; i++) {
				if(numeroAleatorio == numerosSorteados[i]) {
					numeroRepetido = true;
				}
			}
			if(numeroRepetido == false) {
				numerosSorteados[posicaoSorteio] = numeroAleatorio;
				posicaoSorteio++;
			}
		}

		// gerar um novo número aleatório a cada instância

		// ordenar números sorteados
		Arrays.sort(numerosSorteados);
		System.out.println("Números sorteados: " + Arrays.toString(numerosSorteados));
		
		//contabilizando pontos
		int acertos = 0;
		 for(int i = 0; i < 7; i++) {
			 for(int j = 0; i < 7; i++) {
				 if(numerosEscolhidos[i] == numerosSorteados[j]) {
					 acertos++;
				 }
			 }
		 }
		 
		 //divulgando a premiação
		 switch(acertos) {
		 case 7:
			 System.out.println("PARABÉNS! Você obteve 7 acertos e recebe 200 mil reais.");
			 break;
		 case 6:
			 System.out.println("PARABÉNS! Você obteve 6 acertos e recebe 50 mil reais.");
			 break;
		 case 5:
			 System.out.println("PARABÉNS! Você obteve 5 acertos e recebe 10 mil reais.");
			 break;
		default:
			System.out.println("Agradecemos a sua participação!");
			break;
		 }
	}
}
