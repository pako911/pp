package pp;

public class Osoba {
    private String imie;
    private String nazwisko;

    Osoba(String imie, String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Imie: " + imie + "\nNazwisko: " + nazwisko;
    }
}
