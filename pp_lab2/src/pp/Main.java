package pp;

public class Main {

    public static void main(String[] args){
	    Firma firma = new Firma();
	    Pracownik p1 = new Pracownik("Zbigniew", "Kowalski", 2000, Pracownik.Stanowisko.Asystent);
        Pracownik p2 = new Pracownik("Wojciech", "Mazur", 5000, Pracownik.Stanowisko.Kierownik);
        Pracownik p3 = new Pracownik("Karolina", "Bojar", 6000, Pracownik.Stanowisko.Kierownik);
        Pracownik p4 = new Pracownik("Paulina", "Kwiatkowska", 4000, Pracownik.Stanowisko.Kierownik);

        firma.add(p1);
        firma.add(p2);
        firma.add(p3);
        firma.add(p4);
        System.out.println("Lista pracowników: ");
        firma.display();
        System.out.print("\nLiczba pracownikow: ");
        firma.count();
        System.out.println("\nWypisywanie za pomocą iteratora: ");
        firma.iterator();
        System.out.print("\nSrednia pensja pracownikow: ");
        firma.salary();
        System.out.print("\nSrednia pensja pracownikow na stanowisku \"Kierownik\": ");
        firma.salaryByJob(Pracownik.Stanowisko.Kierownik);
        System.out.println("\nAsystenci: ");
        firma.itereator(Pracownik.Stanowisko.Kierownik);
    }
}
