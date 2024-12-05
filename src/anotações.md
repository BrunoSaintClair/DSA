## Big O

Métrica para calcular eficiência de um algoritmo: número de passos executados.

1. O crescimento é em relação ao input.
2. Desconsiderar constantes. (valores das constantes dependem da máquina)

1 loop = O(N), porque cresce linearmente de acordo com a quantidade de loops que será necessário fazer.

```
O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(n³) < O(2^n) < O(n!)
```

Exemplos:
* O(n²) == fazer um loop dentro de um loop
* O(n log n) == quicksort
* O(log n) == árvores de busca binária

Na notação de Big O, log == log na base 2

Quanto maior a entrada, maior é o domínio do fator de maior grau da função.

## Array x Linked List

### Array:
* Fica mais fácil de alterar/acessar valores por conta dos índices
* Operações de acesso em um array são O(1)
* Em arrays com tamanho fixo, a memória é alocada de uma vez para todos os itens (por exemplo, 
um array de comprimento 1000 aloca espaço para 1000 itens mesmo que nem todos sejam utilizados).

### Linkedlist:
* Inicia vazia
* O custo de memória é mais flexível por que cresce de acordo com a quantidade de nós adicionados
* Buscar itens é mais custoso pq é sempre uma busca linear, já a inserção e eliminação de itens é O(1)

## Quicksort

* Geralmente é O(n log n), mas em caso de array ordenado de maneira inversa ([10, 9, 8, 7...]) se torna O(n²) 