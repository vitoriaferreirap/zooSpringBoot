package com.vitoriaferreiradev.zoo.entities.enums;

public enum Habitat {
    SAVANA(1),
    AQUÁTICO(2),
    AÉREO(3),
    FLORESTA(4);

    private int codigo;

    private Habitat(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    // Método estático para converter um código inteiro em um enum Habitat
    public static Habitat toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (Habitat habitat : Habitat.values()) {
            if (habitat.getCodigo() == codigo) {
                return habitat;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + codigo);
    }

}
