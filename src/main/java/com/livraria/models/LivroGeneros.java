package com.livraria.models;

public enum LivroGeneros {
    FICCAO,
    NAO_FICCAO,
    ROMANCE,
    FICCAO_CIENTIFICA,
    FANTASIA,
    MISTERIO,
    TERROR,
    BIOGRAFIA,
    HISTORIA,
    AUTOAJUDA,
    INFANTIL,
    JOVEM_ADULTO;

    @Override
    public String toString() {
        switch(this) {
            case NAO_FICCAO: return "Não-Ficção";
            case FICCAO_CIENTIFICA: return "Ficção Científica";
            case JOVEM_ADULTO: return "Jovem Adulto";
            default: return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        }
    }
}
