public class PetMachine {
    private final int MAX_WATER = 30;
    private final int MAX_SHAMPOO = 10;

    private int waterLevel;
    private int shampooLevel;
    private boolean cleanMachine;
    private Pet currentPet;

    // Novas variáveis de gerência
    private int totalBanhos = 0;
    private double faturamento = 0.0;
    private final double VALOR_BANHO = 50.00;

    public PetMachine() {
        this.waterLevel = 0;
        this.shampooLevel = 0;
        this.cleanMachine = true;
        this.currentPet = null;
    }

    public void putPet(Pet pet) {
        if (currentPet != null) {
            System.out.println(" Erro: Já existe um pet na máquina (" + currentPet.getName() + ").");
            return;
        }
        if (!cleanMachine) {
            System.out.println(" Erro: A máquina está suja! Higienize-a antes de colocar outro pet.");
            return;
        }
        this.currentPet = pet;
        System.out.println(" " + pet.getName() + " entrou na máquina de banho.");
    }

    public void takeShower() {
        if (currentPet == null) {
            System.out.println(" Erro: Não há nenhum pet na máquina para dar banho.");
            return;
        }
        if (currentPet.isClean()) {
            System.out.println(" " + currentPet.getName() + " já está limpo!");
            return;
        }
        if (waterLevel < 10 || shampooLevel < 2) {
            System.out.println(" Recursos insuficientes! O banho consome 10L de Água e 2L de Shampoo.");
            return;
        }

        waterLevel -= 10;
        shampooLevel -= 2;
        currentPet.setClean(true);
        cleanMachine = false; // Máquina fica suja após o banho
        totalBanhos++;
        faturamento += VALOR_BANHO;
        System.out.println(" Banho tomado com sucesso! " + currentPet.getName() + " está limpo e cheiroso.");
    }

    public void removePet() {
        if (currentPet == null) {
            System.out.println(" Erro: Não há nenhum pet na máquina.");
            return;
        }

        System.out.println(" " + currentPet.getName() + " foi retirado(a) da máquina.");
        if (!currentPet.isClean()) {
            System.out.println("⚠️ Atenção: O pet saiu sujo. A máquina ficou contaminada e precisa de limpeza.");
            cleanMachine = false;
        }
        this.currentPet = null;
    }

    // Abastece 2L por vez, respeitando o limite máximo
    public void refillWater() {
        if (waterLevel >= MAX_WATER) {
            System.out.println(" A água já está em sua capacidade máxima (" + MAX_WATER + "L).");
            return;
        }
        int quantidadeAdicionada = Math.min(2, MAX_WATER - waterLevel);
        waterLevel += quantidadeAdicionada;
        System.out.println(" + " + quantidadeAdicionada + "L de água adicionados. Nível atual: " + waterLevel + "L.");
    }

    // Abastece 2L por vez, respeitando o limite máximo
    public void refillShampoo() {
        if (shampooLevel >= MAX_SHAMPOO) {
            System.out.println(" O shampoo já está em sua capacidade máxima (" + MAX_SHAMPOO + "L).");
            return;
        }
        int quantidadeAdicionada = Math.min(2, MAX_SHAMPOO - shampooLevel);
        shampooLevel += quantidadeAdicionada;
        System.out.println(" + " + quantidadeAdicionada + "L de shampoo adicionados. Nível atual: " + shampooLevel + "L.");
    }

    public void cleanMachine() {
        if (cleanMachine) {
            System.out.println(" A máquina já está limpa e higienizada.");
            return;
        }
        if (currentPet != null) {
            System.out.println(" Erro: Retire o pet antes de iniciar a autolimpeza!");
            return;
        }
        if (waterLevel < 3 || shampooLevel < 1) {
            System.out.println(" Recursos insuficientes para limpeza (Requer: 3L água / 1L shampoo).");
            return;
        }

        waterLevel -= 3;
        shampooLevel -= 1;
        cleanMachine = true;
        System.out.println(" Máquina limpa e esterilizada com sucesso!");
    }

    public void checkWaterLevel() {
        System.out.println(" Nível de água: " + waterLevel + "/" + MAX_WATER + "L.");
    }

    public void checkShampooLevel() {
        System.out.println(" Nível de shampoo: " + shampooLevel + "/" + MAX_SHAMPOO + "L.");
    }

    public void checkPetInMachine() {
        if (currentPet != null) {
            System.out.println(" Pet atual na máquina: " + currentPet.getName() + " | Status: " + (currentPet.isClean() ? "Limpo" : "Sujo"));
        } else {
            System.out.println(" Máquina vazia no momento.");
        }
    }

    public void exibirRelatorioGeral() {
        System.out.println("\n ===== RELATÓRIO DO DIA =====");
        System.out.println(" Total de banhos finalizados: " + totalBanhos);
        System.out.println(" Faturamento bruto: R$ " + String.format("%.2f", faturamento));
        System.out.println(" Estado da Máquina: " + (cleanMachine ? "Limpa" : "SUJA"));
        checkWaterLevel();
        checkShampooLevel();
        System.out.println("=================================");
    }
}