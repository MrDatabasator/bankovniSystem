package cz.vse.bankovniSystem;

public class OperaceVklad implements Operace {

    private final Ucet ucet;
    private final int castka;

    public OperaceVklad(Ucet ucet, int castka) {
        this.ucet = ucet;
        this.castka = castka;
    }
    @Override
    public TypOperace getTypOperace() {
        return TypOperace.VKLAD;
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
        return "Vlozena castka " + castka + " na tento ucet.";
    }
}
