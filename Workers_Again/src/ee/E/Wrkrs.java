package ee.E;

import java.util.*;

public class Wrkrs {
    public String name = "";
    public double salary = 0.0;
    public Date started = null;
    public Date left = null;

    public Wrkrs(String name, double salary, Date started, Date left) {
        this.name = name;
        this.salary = salary;
        this.started = started;
        this.left = left;
    }

    public String toString() {
        return String.format("%s palk: %8.2f töötab alates %td.%<tB.%<tY", name, salary, started) +
                (left == null ? "" : String.format(" ja on lahkunud %td.%<tB.%<tY", left));

    }

}


/*
package ee.Henn;

import java.util.Date;

public class Worker {
    public String name = "";
    public double salary = 0.0; // mis andmetüüp siia sobiks
    public Date started = null;
    public Date ended = null;

    public Worker(String name, double salary, Date started, Date ended) {
        this.name = name;
        this.salary = salary;
        this.started = started;
        this.ended = ended;
        System.out.println(this);
    }

    public String toString() {
        return String.format("%s palk: %8.2f töötab alates %td.%<tB.%<tY", name, salary, started) +
                (ended == null ? "" : String.format(" ja on lahkunud %td.%<tB.%<tY", ended));
    }
}



 */