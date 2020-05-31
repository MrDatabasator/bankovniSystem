package cz.vse.bankovniSystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

public class BankovniSystemImpl implements BankovniSystem {

    private Hashtable<String, Ucet> seznamUctu = new Hashtable<String, Ucet>();
    private Hashtable<String, Collection<Operace>> colectionOperaceUctu = new Hashtable<String, Collection<Operace>>();

    @Override
    public boolean prevedPenize(long zdrojovyUcet, long cilovyUcet, int castka) {

        if (!existujeUcet(zdrojovyUcet) || !existujeUcet(cilovyUcet)) {
            return false;
        }

        Ucet zdrojovyUcetUcet = seznamUctu.get(Long.toString(zdrojovyUcet));
        Ucet cilovyUcetUcet = seznamUctu.get(Long.toString(cilovyUcet));

        if (zdrojovyUcetUcet.getCastka() <= Math.abs(castka)) {
            System.out.println("nemáš prachy");
            return false;
        }

        zdrojovyUcetUcet.setCastka(zdrojovyUcetUcet.getCastka() - Math.abs(castka));
        cilovyUcetUcet.setCastka(cilovyUcetUcet.getCastka() + Math.abs(castka));

        OperacePrevod operacePrevod = new OperacePrevod(zdrojovyUcetUcet, cilovyUcetUcet, castka);
        pridejOperaci(operacePrevod, zdrojovyUcet);
        pridejOperaci(operacePrevod, cilovyUcet);

        return true;
    }

    @Override
    public boolean vkladNaUcet(long ucet, int castka) {
        if (!existujeUcet(ucet)) {
            System.out.println("neexistuje učet");
            return false;
        }

        Ucet vkladovyUcetUcet = seznamUctu.get(Long.toString(ucet));
        vkladovyUcetUcet.setCastka(vkladovyUcetUcet.getCastka() + Math.abs(castka));

        OperaceVklad operaceVklad = new OperaceVklad(vkladovyUcetUcet, castka);
        pridejOperaci(operaceVklad, ucet);

        return true;
    }

    @Override
    public boolean vyberZUctu(long ucet, int castka) {
        if (!existujeUcet(ucet)) {
            System.out.println("neexistuje učet");
            return false;
        }

        Ucet vyberovyUcetUcet = seznamUctu.get(Long.toString(ucet));

        if (vyberovyUcetUcet.getCastka() <= Math.abs(castka)) {
            System.out.println("nemáš prachy");

            return false;
        }

        vyberovyUcetUcet.setCastka(vyberovyUcetUcet.getCastka() - Math.abs(castka));

        OperaceVyber operaceVyber = new OperaceVyber(vyberovyUcetUcet, castka);
        pridejOperaci(operaceVyber, ucet);

        return true;
    }

    @Override
    public Collection<Operace> operaceNaUctu(long ucet) {
        if (colectionOperaceUctu.get(Long.toString(ucet)) == null) {
            System.out.println("není operace na učtu");
            return null;
        }
        return colectionOperaceUctu.get(Long.toString(ucet));
    }

    @Override
    public Ucet vytvorUcet(long cisloUctu) {

        if (existujeUcet(cisloUctu)) {
            return null;
        }

        Ucet novyUcet = new Ucet(cisloUctu);
        seznamUctu.put(Long.toString(cisloUctu), novyUcet);
        return novyUcet;
    }

    public Collection<Operace> getOperaceProUcet(long cisloUctu) {
        return colectionOperaceUctu.get(Long.toString(cisloUctu));
    }

    private boolean existujeUcet(long cisloUctu) {
        return seznamUctu.containsKey(Long.toString(cisloUctu));
    }

    private void pridejOperaci(Operace operace, long cisloUctu) {
        Collection<Operace> operaces = colectionOperaceUctu.get(Long.toString(cisloUctu));

        if (operaces == null) {
            operaces = new ArrayList<Operace>();
        }

        operaces.add(operace);
        colectionOperaceUctu.put(Long.toString(cisloUctu), operaces);
    }
}
