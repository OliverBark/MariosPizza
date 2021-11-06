package OliverBark;

public class Bestilling {
    double tid;
    int pizzaNr;
    String navn;
    int tlf;
    int id;

    public Bestilling(double tid, int pizzaNr, String navn, int tlf, int id) {
        this.tid = tid;
        this.pizzaNr = pizzaNr;
        this.navn = navn;
        this.tlf = tlf;
        this.id = id;
    }


    public double getTid() {
        return tid;
    }

    public void setTid(double tid) {
        this.tid = tid;
    }


    public int getPizzanr() {
        return pizzaNr;
    }

    public void setPizzanr(int pizzanr) {
        this.pizzaNr = pizzanr;
    }


    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Bestilling: " + " id: " + id + " Tid: " + tid + " Pizza nummer: " + pizzaNr +
                " Navn: " + navn + " Telefon: " + tlf;
    }
}

