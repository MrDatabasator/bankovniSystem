package cz.vse.bankovniSystem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankovniSystemImplTest {

    BankovniSystem bankovniSystem = new BankovniSystemImpl();

    @Test
    void prevedPenizeUcetNeexistuje() {
        assertFalse(bankovniSystem.prevedPenize(1654984, 649849, 150));
    }

    @Test
    void prevedPenizeUcetExistuje() {
        bankovniSystem.vytvorUcet(1654984);
        bankovniSystem.vytvorUcet(649849);
        assertTrue(bankovniSystem.prevedPenize(1654984, 649849, 150));
    }

    @Test
    void prevedPenizeUcetExistujePenizeNedostatecne() {
        bankovniSystem.vytvorUcet(1654984);
        bankovniSystem.vytvorUcet(649849);
        assertFalse(bankovniSystem.prevedPenize(1654984, 649849, 200000));
    }

    @Test
    void vkladNaUcetUcetNeexistuje() {
        assertFalse(bankovniSystem.vkladNaUcet(69, 5000));
    }

    @Test
    void vkladNaUcetUcetExistuje() {
        bankovniSystem.vytvorUcet(69);
        assertTrue(bankovniSystem.vkladNaUcet(69, 5000));
    }

    @Test
    void vyberZUctuUcetNeexistuje() {
        assertFalse(bankovniSystem.vyberZUctu(6969, 10));
    }

    @Test
    void vyberZUctuUcetExistuje() {
        bankovniSystem.vytvorUcet(70);
        assertTrue(bankovniSystem.vyberZUctu(70, 200));
    }

    @Test
    void vyberZUctuUcetExistujePenizeNeexistuji() {
        bankovniSystem.vytvorUcet(70);
        assertFalse(bankovniSystem.vyberZUctu(70, 60000));
    }

    @Test
    void vyberZUctuUcetExistujePenizeExistuji() {
        bankovniSystem.vytvorUcet(75);
        assertTrue(bankovniSystem.vyberZUctu(75, 200));
    }

    @Test
    void operaceNaUctu() {
        bankovniSystem.vytvorUcet(1654984);
        bankovniSystem.vytvorUcet(649849);
        bankovniSystem.prevedPenize(1654984, 649849, 150);
        assertNotNull(((BankovniSystemImpl) bankovniSystem).getOperaceProUcet(1654984));
    }

    @Test
    void operaceNaUctuNeexistuji() {
        bankovniSystem.vytvorUcet(1654984);
        bankovniSystem.vytvorUcet(649849);
        assertNull(((BankovniSystemImpl) bankovniSystem).getOperaceProUcet(1654984));
    }

    @Test
    void vytvorUcetUcetNevytvoren() {
        bankovniSystem.vytvorUcet(6969);
        assertNull(bankovniSystem.vytvorUcet(6969));
    }

    @Test
    void vytvorUcetUcetVytvoren() {
        assertNotNull(bankovniSystem.vytvorUcet(6969));
    }
}