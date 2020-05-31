package cz.vse.bankovniSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ucet {

    private static final int DEFAULT_CASTKA = 500;

    private final long cisloUctu;
    private final List<Operace> operace;
    private int castka;

    public Ucet(long cisloUctu) {
        this(cisloUctu, DEFAULT_CASTKA);
    }

    public Ucet(long cisloUctu, int pocatecniCastka) {
        this.cisloUctu = cisloUctu;
        this.castka = pocatecniCastka;
        this.operace = new ArrayList<>();
    }

    public long getCisloUctu() {
        return cisloUctu;
    }

    public int getCastka() {
        return castka;
    }

    public void setCastka(int castka) {
        this.castka = castka;
    }

    public void pridejOperaci(Operace operace) {
        this.operace.add(operace);
    }

    public List<Operace> getOperace() {
        return List.copyOf(operace);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ucet ucet = (Ucet) o;
        return cisloUctu == ucet.cisloUctu &&
                castka == ucet.castka;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cisloUctu, castka);
    }
}
