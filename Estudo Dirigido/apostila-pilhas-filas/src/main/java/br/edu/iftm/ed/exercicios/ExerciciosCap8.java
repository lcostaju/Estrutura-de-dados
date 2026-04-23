package br.edu.iftm.ed.exercicios;

import br.edu.iftm.ed.estrutura.Pilha;
import br.edu.iftm.ed.estrutura.PilhaArray;

import java.util.Objects;

public final class ExerciciosCap8 {
    private ExerciciosCap8() {
    }

    public static String inverter(String texto) {
        Objects.requireNonNull(texto, "texto nao pode ser nulo");

        Pilha<Character> pilha = new PilhaArray<>();
        for (char c : texto.toCharArray()) {
            pilha.push(c);
        }

        StringBuilder invertido = new StringBuilder(texto.length());
        while (!pilha.isEmpty()) {
            invertido.append(pilha.pop());
        }

        // Resposta pedida no enunciado (Exercicio 1):
        // Complexidade temporal: O(n), pois cada caractere e empilhado e desempilhado uma vez.
        // Complexidade espacial: O(n), pois a pilha armazena ate n caracteres.
        return invertido.toString();
    }

    public static double avaliarPosFixa(String expressao) {
        Objects.requireNonNull(expressao, "expressao nao pode ser nula");

        String texto = expressao.trim();
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("expressao vazia");
        }

        Pilha<Double> pilha = new PilhaArray<>();

        for (String token : texto.split("\\s+")) {
            switch (token) {
                case "+" -> pilha.push(aplicarBinario(pilha, token));
                case "-" -> pilha.push(aplicarBinario(pilha, token));
                case "*" -> pilha.push(aplicarBinario(pilha, token));
                case "/" -> pilha.push(aplicarBinario(pilha, token));
                case "%" -> pilha.push(aplicarBinario(pilha, token));
                default -> pilha.push(Double.parseDouble(token));
            }
        }

        if (pilha.size() != 1) {
            throw new IllegalArgumentException("expressao pos-fixa invalida");
        }

        // Resposta pedida no enunciado (Exercicio 2):
        // O operador % e binario, logo consome 2 operandos (a % b).
        // Um operador de negacao unaria consumiria 1 operando (-a).
        return pilha.pop();
    }

    private static double aplicarBinario(Pilha<Double> pilha, String operador) {
        if (pilha.size() < 2) {
            throw new IllegalArgumentException("faltam operandos para operador " + operador);
        }

        double b = pilha.pop();
        double a = pilha.pop();

        return switch (operador) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0.0) {
                    throw new ArithmeticException("divisao por zero");
                }
                yield a / b;
            }
            case "%" -> {
                if (b == 0.0) {
                    throw new ArithmeticException("modulo por zero");
                }
                yield a % b;
            }
            default -> throw new IllegalArgumentException("operador invalido: " + operador);
        };
    }
}
