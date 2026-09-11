package no.oslomet.cs.algdat;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    private Oblig1() {}

    // Oppgave 0
    public static int gruppeMedlemmer() {
        return 1;
    }

    // Oppgave 1
    public static int maks(int[] a) {

        if(a.length == 0){
            throw new NoSuchElementException("Tabellen er tom!");
        }

        for(int i = 1; i < a.length;i++){
                if(a[i-1]>a[i]) {
                    int temp = a[i-1];
                    a[i-1] = a[i];
                    a[i] = temp;

            }
        }
            int storstVerdi = a.length - 1;
            return a[storstVerdi];



    }

    //a) n - 1 sammenligninger
    //b) Det blir færrest ombyttninger dersom listen allerede er sortert (best case)
    //c) Worst case er n-1 ombyttninger, dersom tabeller er sortert synkende.
    //d) Gjennomsnittlig ombyttninger vil befinne seg mellom beste og verste tilfellet, i beste tilfellet vil vi ha 0 inversjoner
    // dersom listen allerede er sortert stigende, og i verste tilfellet vil vi ha n inversjoner.
    // Gjennomsnittet befinner seg mellom disse to ytterpunktene,
    // da ved en tilfeldig permutasjon er det 50 % sannsynlighet for ombyttninger,
    // vi kan legge sammen best og worst case og dele på 2,
    // det gir formelen for gjennomsnittet:
    // n - 1 / 2 sammenligninger.
    // For både worst og best case må vi likevel kjøre n-1 sammenligninger selv om vi ikke bytter så begge blir da 0(n),
    // det vil også gjennomsnittlig case ha, da denne algoritmen går alltid gjennom hele tabellen
    // en gang uavhengig av hvordan tallene er organisert
    // Tidligere har vi sett på algoritmer der worst case er O(n^2),
    // det vil si at forskjellen i kjøretid blir mye større dersom n er stor.
    // Vår løkke går i alle tilfeller bare gjennom n elementer
    // dermed er denne algoritmen generelt mer effektiv enn de forutgående


    public static int ombyttinger(int[] a) {
        int teller = 0;

        for(int i = 1; i < a.length;i++){
            if(a[i-1]>a[i]) {
                int temp = a[i-1];
                a[i-1] = a[i];
                a[i] = temp;
                teller++;
            }
        } return teller;
    }


    // Oppgave 2
    public static int antallUlikeSortert(int[] a) {

        int teller = 1;                     // Starter med 1, siden vi allerede har  et unikt tall
        if (a.length == 0) {
            return 0;

        } else {

            for (int i = 1; i < a.length; i++) {
                if (!(a[i - 1] <= a[i])) {
                    throw new IllegalStateException("Tabellen er ikke sortert stigende!");
                }
                if (a[i] != a[i - 1]) {
                    teller++;
                }
            }
            return teller;
        }
    }

    // Oppgave 3

    public static int antallUlikeUsortert(int[] a) {
        int teller = 0;

        for (int i = 0; i < a.length; i++) {
            boolean finnesFor = false;

            for (int j = 0; j < i; j++) {
                if(a[i] == a[j]){
                    finnesFor = true;
                    break;
                }
            }
        if(!finnesFor){
            teller++;
        }
        }
    return teller;
    }

    // Oppgave 4
    public static void sorter(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length) {
            throw new IndexOutOfBoundsException();
        }

        if (fra >= til) {
            return;
        }

        kvikksortering0(a, fra, til - 1);

    }


    // Hjelpemetoden for kvikksøk
    private static void kvikksortering0(int[] a, int v, int h) {
        if (v >= h) {
            return;
        }

        int k = sParter0(a, v, h, (v + h) / 2);

        kvikksortering0(a, v, k - 1);
        kvikksortering0(a, k + 1, h);
    }


    private static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);

        int pos = parter0(a, v, h - 1, a[h]);

        bytt(a, pos, h);

        return pos;
    }



    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true)       {


            while (v <= h && a[v] <= skilleverdi)

                v++;
            while (v <= h && a[h] >= skilleverdi)
                h--;

            if (v < h)
                bytt(a,v++,h--);
            else  return v;
        }
    }


    public static void bytt(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static boolean erParTall(int tall) {
        boolean erPar = false;
        if (tall % 2 == 0) {
            erPar = true;
        }
        return erPar;
    }

    public static boolean erOddeTall(int tall){
        return tall % 2 != 0;
    }

    public static void delsortering(int[] a) {

        int v = 0;
        int h = a.length - 1;

        while (v <= h) {

            while (v <= h && erOddeTall(a[v])) {
                v++;
            }

            while (v <= h && erParTall(a[h])) {
                h--;
            }

            if (v < h) {
                bytt(a, v, h);
                v++;
                h--;
            }
        }

        sorter(a, 0, v);
        sorter(a, v, a.length);
    }

    public static void rotasjon(char[] a) {

        if (a.length <= 1) {
            return;
        }

        char temp = a[a.length - 1];

        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }

        a[0] = temp;
    }

    // Oppgave 7
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();

    }

    // Oppgave 8
    public static String flett(String s, String t) {
        String resultat = "";                               // Vi starter med en tom streng

        int lengde = Math.min(s.length(), t.length());  // Bruker Javas innebygde Math klasse med min metoden for å finne det minste/minimum lengde på begge strengene

        for (int i = 0; i < lengde; i++) {
            resultat += s.charAt(i);                    // Her henter vi tegnet på plass [i], vi legger inn første tall fra  s og deretter fra t
            resultat += t.charAt(i);
        }

        if (s.length() > lengde) {                  // Legger til ev resterende tegn fra s
            resultat += s.substring(lengde);
        }

        if (t.length() > lengde) {                  // Legger til ev resterende tegn fra t
            resultat += t.substring(lengde);
        }

        return resultat;
    }


    public static String flett(String... s) {
        String resultat = "";
        int lengste = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > lengste) {
                lengste = s[i].length();
            }
        }

        for (int j = 0; j < lengste; j++) {
            for (int i = 0; i < s.length; i++) {
                if (j < s[i].length()) {
                    resultat += s[i].charAt(j);
                }
            }
        }

        return resultat;

    }

    // Oppgave 9
    public static int[] indeksSortering(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 10
    public static int[] tredjeMin(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 11
    public static boolean inneholdt(String a, String b) {throw new UnsupportedOperationException();}
}