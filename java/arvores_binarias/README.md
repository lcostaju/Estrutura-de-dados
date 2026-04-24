# Arvores Binarias - In-order Iterativo vs Recursivo

Implementacao pedida na apostila de Estruturas Nao Lineares:
- percurso in-order iterativo usando pilha explicita (`Stack`), sem recursao
- comparacao com a versao recursiva

## Arquivos

- `src/No.java`: estrutura do no da arvore
- `src/ArvoreBinaria.java`: metodos `inOrderRecursivo()` e `inOrderIterativo()`
- `src/App.java`: monta a arvore de exemplo e compara as duas saidas

## Como executar

No PowerShell, dentro de `java/arvores_binarias`:

```powershell
javac -d bin src\*.java
java -cp bin App
```

Saida esperada (arvore de exemplo da apostila):

```text
In-order recursivo: [3, 5, 7, 10, 12, 15, 20]
In-order iterativo: [3, 5, 7, 10, 12, 15, 20]
Sao iguais? true
```

## Comparacao objetiva

- Tempo: `O(n)` nas duas abordagens
- Espaco: `O(h)` nas duas (h = altura da arvore)
- Recursiva: mais simples de ler
- Iterativa: evita depender da pilha de chamadas da JVM em arvores profundas
