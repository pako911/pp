package pp;

public class Main {

    public static void main(String[] args) {
	    Firma firma = new Firma();
	    Pracownik p1 = new Pracownik("Zbigniew", "Kowalski", 2000, Pracownik.Stanowisko.Asystent);
        Pracownik p2 = new Pracownik("Wojciech", "Mazur", 8000, Pracownik.Stanowisko.Dyrektor);

        firma.add(p1);
        firma.add(p2);
        firma.display();
        System.out.print("Liczba pracownikow: ");
        firma.count();
        firma.iterator();
        System.out.print("Pensja pracownikow: ");
        firma.salary();
        firma.salaryByJob(Pracownik.Stanowisko.Dyrektor);
    }
}
