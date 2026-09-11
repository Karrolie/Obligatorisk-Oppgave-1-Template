package no.oslomet.cs.algdat;

import java.util.Arrays;
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
    //Lag metoden public static int antallUlikeUsortert(int[] a). Tabellen
    //a kan nå være en hvilken som helst heltallstabell, den trenger ikke være sortert, og
    //kan ha flere like verdier.
    //Metoden skal returnere hvor mange forskjellige verdier som er i a, og skal ikke
    //endre på tabellens innhold.
    //Metoden skal ikke bruke noen hjelpetabeller. Alt arbeid skal kun foregå innenfor
    //tabellen a. Du kan derfor eksempelvis ikke lage en sortert kopi av a, eller lage en
    //tabell over tidligere registrerte verdier. Du kan selvfølgelig lage hjelpevariabler
    public static int antallUlikeUsortert(int[] a) {
        int teller = 0;

        for (int i = 0; i < a.length; i++) {
            boolean finnesFor = false;           //boolean variabel som holder styr på om et tall finnes fra før eller ikke, satt til false

            for (int j = 0; j < i; j++) {
                if(a[i] == a[j]){
                    finnesFor = true;            // hvis to tall er like så finnes tallet fra før
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
    //Lag metoden public static void sorter(int[] a, int fra, int til),
    //som sorterer de elementene i en tabell som ligger på posisjoner mellom
    //fra og til, inklusivt fra men eksklusivt til. Det vil si at intervallet [fra, til⟩ er
    //intervallet som skal sorteres. Her er et eksempel:
    //int[] a = {6, 10, 9, 4, 1, 3, 8, 5, 2, 7};
    //sorter(a, 3, 8);
    // nå skal vi ha a = {6, 10, 9, 1, 3, 4, 5, 8, 2, 7}
    //Metoden skal ikke bruke hjelpetabeller og må være relativt effektiv. En av testene
    //vil måle effektivitet på store tabeller.
    //Metoden skal kaste en IndexOutOfBoundsException dersom fra er negativ
    //eller dersom til er større enn tabellens lengde. Den skal ikke kaste feilmelding
    //dersom fra er mindre enn til, men skal da ikke gjøre noe.

    //Jeg vet nå at det ikke er boblesortering, insettningssortering da de i verste fall kan ha en tidkompleksitet på O(n^2)
    // Jeg forsøker å lage en quicksort


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
        while (true)       {                            // Løkken fortsetter helt til vi selv stopper med return
                                                        // Vi har to "pekere", v og h som blir [fra, til⟩ i vår oppgave

            while (v <= h && a[v] <= skilleverdi)       //Løkken kjører så lenge v ikke har gått forbi h(h er stoppeverdi for v), og
                                                        //verdien på plass v/a[v] er mindre enn skilleverdien, flytt v ett hakk mot høyre.
                v++;
            while (v <= h && a[h] >= skilleverdi)       // Løkken kjører også så lenge v<=h, v er stoppeverdi for h (så vice versa)
                h--;                                    // og så lenge a[h]/verdien på plass h er større enn eller lik skillevrdien/pivoten

            if (v < h)
                bytt(a,v++,h--);                        // bytter om a[v] og a[h]
            else  return v;                             //Når vi har gjort ferdig partisjoneringen, avsluttes metoden
        }
    }


    public static void bytt(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    //Bruk metoden sorter til å lage metoden public static void delsortering(int[] a).
    //Den skal dele tabellen a i to sorterte deler. Venstre del skal inneholde alle oddetallene
    //sortert, og høyre del alle partallene sortert. Følgende eksempel viser bruksområdet:
    //int[] a = {6, 10, 9, 4, 1, 3, 8, 5, 2, 7};
    //delsortering(a);

    // Nå skal vi ha a = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10}.
    //Tabellen a kan være tom, kan inneholde både negative og positive tall, kan
    //bestå av kun oddetall, eller kun av kun partall. Ingen av disse mulighetene skal gi
    //feilmelding

    // Oppgave 5


    public static boolean erParTall(int tall) {
        boolean erPar = false;
        if (tall % 2 == 0) {        //   return tall % 2 == 0;
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


    // Oppgave 6
    //Lag metoden public static void rotasjon(char[] a). Metoden skal «rote-
    //re» elementene i en tabell. En rotasjon gjøres ved at det siste elementet settes
    //først, og alle andre element forskyves ett steg mot høyre. Følgende eksempel viser
    //et bruksområde:
    //char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    //rotasjon(a);

    // a er nå {'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'}
    //En rotasjon i en tom tabell eller tabell med nøyaktig ett element skal ikke gi
    //feilmelding, men rotasjonen vil da ikke gjøre noe.
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