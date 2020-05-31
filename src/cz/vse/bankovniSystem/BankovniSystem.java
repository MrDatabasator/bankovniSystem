package cz.vse.bankovniSystem;

import java.util.Collection;

/**
 * Toto je interface předepisující jednolitvé operace, které musí umět váš bankovní systém.
 *
 * Pro každou bankovní operaci {@link #prevedPenize(long, long, int)}, {@link #vkladNaUcet(long, int)} a
 * {@link #vyberZUctu(long, int)} uložit patřičnou operaci k zdrojovému i cílovému účtu, pokud byla operace úspěšná.
 * Jednolivé záznamy oprací implementují interface {@link Operace}.
 *
 * Dejte pozor na zaporná čísla při prevodech, výberech a pod.
 *
 */
public interface BankovniSystem {

    /**
     * Převod peněz mezi dvěma účty.
     *
     * Pokud některý z účtů neexistuje, vyhodit chybovou hlášku (Exception či výpis chyby na konzoli) a převod neuskutečnit.
     *
     * Dále zkontrolovat částku na zdrojovém účtu a pokud nemá dostatečné množství peněz, opět převod neuskutečnit a
     * vyhodit chybovou hlášku.
     *
     * @param zdrojovyUcet ucet odkud posilame penize
     * @param cilovyUcet ucet kam posilame penize
     * @param castka kolik prevadime
     * @return zda se prevod uskutecnil
     */
    boolean prevedPenize(long zdrojovyUcet, long cilovyUcet, int castka);

    /**
     * Vložení určité částky na cílový účet.
     *
     * Pokud účet neexistuje, vyhodit chybovou hlášku (Exception či výpis chyby na konzoli) a vklad neuskutečnit.
     *
     * @param ucet ucet kam vkladame
     * @param castka kolik vkladame
     * @return zda se vklad uskutecnil
     */
    boolean vkladNaUcet(long ucet, int castka);

    /**
     * Výběr určité částky z cílového účetu.
     *
     * Pokud účet neexistuje, vyhodit chybovou hlášku (Exception či výpis chyby na konzoli) a výběr neuskutečnit.
     *
     * @param ucet ucet odkud vybíráme
     * @param castka kolik vybíráme
     * @return zda se výběr uskutecnil
     */
    boolean vyberZUctu(long ucet, int castka);

    /**
     * Přehled všech provedených operací na konkrétním účtě.
     *
     * @param ucet číslo účtu
     * @return všechny uskutečněné operace na účtu
     */
    Collection<Operace> operaceNaUctu(long ucet);

    /**
     * Metoda pro vytvareni uctu. Tuto jedinou v tomto interfacu můžete změnit a přidávat do ní parametry dle libosti.
     *
     * Nesmí existovat více než jeden účet se stejným číslem.
     *
     * @param cisloUctu cislo noveho uctu (primarne kvuli testum)
     * @return nove vytvoreny a zaregistrovany ucet
     */
    Ucet vytvorUcet(long cisloUctu);

}
