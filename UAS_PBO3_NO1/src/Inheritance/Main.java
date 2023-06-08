package Inheritance;

//Inheritance adalah mekanisme di mana sebuah kelas dapat mewarisi properti dan metode dari kelas lain.
//Kelas yang mewarisi disebut kelas anak atau subclass, sedangkan kelas yang memberikan warisan disebut kelas
//induk atau superclass. Inheritance dapat mengorganisir dan menerapkan hierarki kelas, di mana kelas anak dapat
//mewarisi karakteristik dan perilaku dari kelas induknya.

// superclass
class Makanan {
    protected String nama;

    public Makanan(String nama) {
        this.nama = nama;
    }

    public void makan() {
        System.out.println("Saya sedang makan " + nama);
    }
}

// subclass
class MakananRingan extends Makanan {
    public MakananRingan(String nama) {
        super(nama);
    }

    @Override
    public void makan() {
        System.out.println(nama + " merupakan makanan ringan.");
    }
}

// subclass
class MakananBerat extends Makanan {
    public MakananBerat(String nama) {
        super(nama);
    }

    @Override
    public void makan() {
        System.out.println( nama + " merupakan makanan berat.");
    }
}

public class Main {
    public static void main(String[] args) {
        MakananRingan snack = new MakananRingan("Keripik");
        MakananBerat meal = new MakananBerat("Nasi Goreng");

        snack.makan();
        meal.makan();
    }
}

