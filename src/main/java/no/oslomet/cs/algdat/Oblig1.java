package no.oslomet.cs.algdat;

import java.util.NoSuchElementException;

public class Oblig1 {

    private Oblig1() {}

    // Oppgave 0
    public static int gruppeMedlemmer() {
        return 1;

        // Skal returne hvor mange som er i gruppa deres.
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
       // throw new UnsupportedOperationException();}

    // Oppgave 2
    public static int antallUlikeSortert(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 3
    public static int antallUlikeUsortert(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 4
    public static void sorter(int[] a, int fra, int til) {throw new UnsupportedOperationException();}

    // Oppgave 5
    public static void delsortering(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 6
    public static void rotasjon(char[] a) {throw new UnsupportedOperationException();}

    // Oppgave 7
    public static void rotasjon(char[] a, int k) {throw new UnsupportedOperationException();}

    // Oppgave 8
    public static String flett(String s, String t) {throw new UnsupportedOperationException();}

    public static String flett(String... s) {throw new UnsupportedOperationException();}

    // Oppgave 9
    public static int[] indeksSortering(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 10
    public static int[] tredjeMin(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 11
    public static boolean inneholdt(String a, String b) {throw new UnsupportedOperationException();}
}