#  Sistema de Controle de Banho para Petshop (v1.0)

Este é um sistema de console desenvolvido em **Java** que simula o funcionamento automatizado de uma máquina de dar banho em pets. O projeto foi construído aplicando conceitos fundamentais de **Orientação a Objetos (OO)**.

##  Funcionalidades e Regras de Negócio
- **Gerenciamento de Insumos:** A máquina possui tanques com limites máximos (30L de água e 10L de shampoo) e valida se há recursos suficientes antes de iniciar qualquer operação.
- **Segurança e Higiene:** O sistema impede a entrada de um pet se a máquina já estiver ocupada ou se estiver suja (necessitando de autolimpeza).
- **Controle Financeiro:** O sistema contabiliza o total de banhos dados e calcula o faturamento bruto do dia.
- **Interface Segura:** O menu interativo via console possui validações contra entradas inválidas do usuário (letras no lugar de números).

##  Estrutura do Projeto
O projeto é dividido em 3 classes principais:
1. `Pet`: Classe de modelo que representa o animal (Nome e estado de limpeza).
2. `PetMachine`: Onde reside toda a inteligência, sensores de insumos e regras de negócio da máquina.
3. `Main`: A interface de menu que interage com o usuário via teclado (`Scanner`).

##  Como Executar
Basta clonar o repositório e executar a classe `Main` em qualquer IDE Java (como IntelliJ ou Eclipse):
```bash
javac Main.java
java Main