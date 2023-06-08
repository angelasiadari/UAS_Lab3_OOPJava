package Interface;

//Interface adalah kontrak yang mendefinisikan metode yang harus diimplementasikan oleh kelas yang mengimplementasikannya.
//Interface menyediakan blueprint untuk kelas-kelas yang ingin menyediakan perilaku tertentu tanpa memperhatikan detail
//implementasinya. Dalam interface, semua metode secara default adalah public dan abstrak.

//Penggunaan Interface
public class Main {
    public static void main(String[] args) {
        Pesawat pesawat = new Pesawat();
        pesawat.terbang();
    }
}
// Kelas interface
interface Penerbang {
    void terbang();
}

// Kelas yang mengimplementasikan interface
class Pesawat implements Penerbang {
    @Override
    public void terbang() {
        System.out.println("Pesawat terbang di udara.");
    }
}
