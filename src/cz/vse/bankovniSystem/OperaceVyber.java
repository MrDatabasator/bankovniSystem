package cz.vse.bankovniSystem;

public class OperaceVyber implements Operace {

    private final Ucet ucet;
    private final int castka;

    public OperaceVyber(Ucet ucet, int castka) {
        this.ucet = ucet;
        this.castka = castka;
    }
    @Override
    public TypOperace getTypOperace() {
        return TypOperace.VYBER;
    }

    @Override
    public int getCastka() {
        return castka;
    }

    @Override
    public Ucet getUcet() {
        return ucet;
    }

    @Override
    public String toString() {
        return "Vybrana castka " + castka + " z tohoto uctu.";
    }
}
