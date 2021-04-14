# Classes

- Quadro
    - Atributos
        - boolean[][] quadro;
        - int pontuacao;
        - static final int LARGURA_MINIMA = 6;
        - static final int ALTURA_MINIMA = 6;
    - Métodos
        - int reproduzir(int rodadas);
        - Bloco gerarBlocoAleatorio(); // de forma aleatória 
        
    - Classe, com tamanho definido no construtor
    - Método reproduzir, 
    
- Bloco
    - Atributos
        - int largura;
        - int altura;
    - Métodos
        - get largura();
        - get altura();
        
- Quadrado2x2 extends Bloco
    - Atributos
        - static final int ALTURA = 2;
        - static final int LARGURA = 2;
        
- Quadrado3x3 extends Bloco
    - Atributos
        - static final int ALTURA = 3;
        - static final int LARGURA = 3;

- Retangulo4x2 extends Bloco
    - Atributos
        - static final int ALTURA = 4;
        - static final int LARGURA = 2;

- Retangulo3x1 extends Bloco
    - Atributos
        - static final int ALTURA = 3;
        - static final int LARGURA = 1;
  
- Exceções: ReproducaoCanceladaPorOverflow

