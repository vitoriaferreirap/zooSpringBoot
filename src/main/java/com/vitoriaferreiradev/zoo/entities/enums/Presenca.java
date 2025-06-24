package com.vitoriaferreiradev.zoo.entities.enums;

public enum Presenca {
    PRESENTE(1),
    AUSENTE(2);

    private int codigo;

    private Presenca(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    // Método estático para converter um código inteiro em um enum Habitat
    public static Presenca toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (Presenca p : Presenca.values()) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + codigo);
    }

}
