package cz.vse.bankovniSystem;

public class OperacePrevod implements Operace {

    private final Ucet zdrojovyUcet;
    private final Ucet cilovyUcet;
    private final int castka;

    public OperacePrevod(Ucet zdrojovyUcet, Ucet cilovyUcet, int castka) {
        this.zdrojovyUcet = zdrojovyUcet;
        this.cilovyUcet = cilovyUcet;
        this.castka = castka;
    }

    @Override
    public TypOperace getTypOperace() {
        return TypOperace.PREVOD;
    }

    @Override
    public int getCastka() {
        return castka;
    }

    @Override
    public Ucet getUcet() {
        return zdrojovyUcet;
    }

    @Override
    public String toString() {
        return "Prevedeno " + castka + " z uctu " + zdrojovyUcet.getCisloUctu() + " na ucet " + cilovyUcet.getCisloUctu();
    }


}
