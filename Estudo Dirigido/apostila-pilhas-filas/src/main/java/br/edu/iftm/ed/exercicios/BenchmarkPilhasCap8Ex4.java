package br.edu.iftm.ed.exercicios;

import br.edu.iftm.ed.estrutura.PilhaArray;
import br.edu.iftm.ed.estrutura.PilhaLista;

import java.util.ArrayDeque;

public class BenchmarkPilhasCap8Ex4 {
    public record Resultado(double mediaPilhaArrayMs, double mediaPilhaListaMs, double mediaArrayDequeMs) {
    }

    public Resultado executar(int repeticoes, int operacoes) {
        if (repeticoes <= 0 || operacoes <= 0) {
            throw new IllegalArgumentException("repeticoes e operacoes devem ser > 0");
        }

        double somaArray = 0;
        double somaLista = 0;
        double somaDeque = 0;

        for (int i = 0; i < repeticoes; i++) {
            somaArray += medir(() -> {
                PilhaArray<Integer> p = new PilhaArray<>();
                for (int j = 0; j < operacoes; j++) {
                    p.push(j);
                    p.pop();
                }
            });

            somaLista += medir(() -> {
                PilhaLista<Integer> p = new PilhaLista<>();
                for (int j = 0; j < operacoes; j++) {
                    p.push(j);
                    p.pop();
                }
            });

            somaDeque += medir(() -> {
                ArrayDeque<Integer> p = new ArrayDeque<>();
                for (int j = 0; j < operacoes; j++) {
                    p.push(j);
                    p.pop();
                }
            });
        }

        // Resposta teorica pedida no enunciado (Exercicio 4):
        // Em geral PilhaArray e ArrayDeque tendem a ser mais rapidas que PilhaLista
        // por melhor localidade de cache (dados contiguos em memoria).
        return new Resultado(somaArray / repeticoes, somaLista / repeticoes, somaDeque / repeticoes);
    }

    private static double medir(Runnable tarefa) {
        tarefa.run();
        long inicio = System.nanoTime();
        tarefa.run();
        return (System.nanoTime() - inicio) / 1_000_000.0;
    }

    public static void main(String[] args) {
        BenchmarkPilhasCap8Ex4 benchmark = new BenchmarkPilhasCap8Ex4();
        Resultado resultado = benchmark.executar(3, 1_000_000);

        System.out.printf("PilhaArray: %.2f ms%n", resultado.mediaPilhaArrayMs());
        System.out.printf("PilhaLista: %.2f ms%n", resultado.mediaPilhaListaMs());
        System.out.printf("ArrayDeque: %.2f ms%n", resultado.mediaArrayDequeMs());
    }
}
