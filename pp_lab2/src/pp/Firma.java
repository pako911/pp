package pp;

import java.util.ArrayList;
import java.util.List;


public class Firma {
    private final List<Pracownik> firma = new ArrayList<>();

    Firma(){};

    void add(Pracownik p){
        firma.add(p);
    }

    void display(){
        for(int i = 0; i < firma.size(); i++){
            System.out.println("Pracownik " + (i+1) + ":\n" + firma.get(i));
        }
    }

    void iterator(){
        for(Osoba o : firma){
            System.out.println(o);
        }
    }

    void itereator(Pracownik.Stanowisko s){
        // todo
    }

    void count(){
        System.out.println(firma.size());
    }

    void salary(){
        int suma = 0;
        for(Pracownik p : firma){
            suma+=p.getPensja();
        }
        suma/=firma.size();
        System.out.println(suma);
    }

    void salaryByJob(Pracownik.Stanowisko s){
        int suma = 0;
        int ilosc = 0;
        for(Pracownik p : firma){
            if(p.getStanowisko() == s) {
                suma += p.getPensja();
                ilosc++;
            }
        }
        suma/=ilosc;
        System.out.println(suma);
    }
}
