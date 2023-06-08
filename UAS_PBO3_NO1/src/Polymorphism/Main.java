package Polymorphism;

//Polymorphism adalah kemampuan objek untuk memiliki banyak bentuk. Objek dapat digunakan sebagai instansi dari kelas
//induknya atau kelas lain yang mewarisi kelas tersebut.Polymorphism memungkinkan pemanggilan metode yang sama dengan
//argumen yang berbeda menghasilkan hasil yang berbeda.
// Contoh kelas induk (superclass)
class Kendaraan {
    protected String merek;

    public Kendaraan(String merek) {
        this.merek = merek;
    }

    public void info() {
        System.out.println("Ini adalah kendaraan " + merek);
    }

    public void berkendara() {
        System.out.println("Sedang berkendara dengan kendaraan " + merek);
    }
}

// subclass
class Mobil extends Kendaraan {
    public Mobil(String merek) {
        super(merek);
    }

    @Override
    public void info() {
        System.out.println("Ini adalah mobil " + merek);
    }
}

// subclass
class Motor extends Kendaraan {
    public Motor(String merek) {
        super(merek);
    }

    @Override
    public void info() {
        System.out.println("Ini adalah motor " + merek);
    }
}

// Penggunaan polymorphism
public class Main {
    public static void main(String[] args) {
        Kendaraan kendaraan1 = new Mobil("Toyota");
        Kendaraan kendaraan2 = new Motor("Honda");

        kendaraan1.info();      // Polymorphism pada metode info()
        kendaraan1.berkendara(); // Polymorphism pada metode berkendara()

        kendaraan2.info();      // Polymorphism pada metode info()
        kendaraan2.berkendara(); // Polymorphism pada metode berkendara()
    }
}

