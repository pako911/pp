package pp;

public class Pracownik extends Osoba {
    public enum Stanowisko {
        Dyrektor("dyrektor", 1),
        Kierownik("kierownik", 2),
        Ksiegowy("ksiegowy", 2),
        Asystent("asystent", 3),
        Recepcjonistka("recepcjonistka", 3);

        private final String opis;
        private final  int hiererhia;

        Stanowisko(String opis, int hiererhia){
            this.opis = opis;
            this.hiererhia = hiererhia;
        }
    }

    private int pensja;
    private Stanowisko stanowisko;

    Pracownik(String imie, String nazwisko, int pensja, Stanowisko stanowisko) {
        super(imie, nazwisko);
        this.pensja = pensja;
        this.stanowisko = stanowisko;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPensja: " + pensja + "\nStanowisko: " + stanowisko;
    }

    int getPensja() {
        return pensja;
    }

    Stanowisko getStanowisko() {
        return stanowisko;
    }
}
