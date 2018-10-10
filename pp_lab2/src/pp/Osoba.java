package pp;

public class Osoba {
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Imie: " + this.imie + "\nNazwisko: " + this.nazwisko;
    }
}
