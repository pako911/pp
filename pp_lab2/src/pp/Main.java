package pp;

public class Main {

    public static void main(String[] args){
	    Firma firma = new Firma();
	    Pracownik p1 = new Pracownik("Zbigniew", "Kowalski", 2000, Pracownik.Stanowisko.Asystent);
        Pracownik p2 = new Pracownik("Wojciech", "Mazur", 5000, Pracownik.Stanowisko.Kierownik);
        Pracownik p3 = new Pracownik("Wiktor", "Tracz", 6000, Pracownik.Stanowisko.Kierownik);
        Pracownik p4 = new Pracownik("Robert", "Kwiatkowski", 4000, Pracownik.Stanowisko.Kierownik);

        firma.add(p1);
        firma.add(p2);
        firma.add(p3);
        firma.add(p4);
        firma.display();
        System.out.print("Liczba pracownikow: ");
        firma.count();
        firma.iterator();
        System.out.print("Pensja pracownikow: ");
        firma.salary();
        System.out.print("Pensja pracownikow na stanowisku Kierownik: ");
        firma.salaryByJob(Pracownik.Stanowisko.Kierownik);
    }
}
