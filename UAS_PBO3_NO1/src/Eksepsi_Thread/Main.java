package Eksepsi_Thread;
//Eksepsi (exceptions) merujuk pada situasi saat program mengalami kondisi yang tidak biasa atau tidak diharapkan saat
//menjalankan suatu kode. Ketika sebuah eksepsi terjadi, program biasanya akan menghentikan eksekusi normal dan mencoba
//menemukan bagian kode yang dapat menangani eksepsi tersebut.

//Thread adalah unit eksekusi terkecil dalam sebuah program yang dapat berjalan secara independen. Thread digunakan untuk
//menjalankan tugas-tugas secara konkuren (paralel) dalam program. Dalam pemrograman multi-threading, kita dapat
//menjalankan beberapa thread secara bersamaan untuk meningkatkan efisiensi dan responsivitas program.
public class Main {
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(() -> {
                try {
                    // Menunggu 2 detik
                    Thread.sleep(3000);
                    System.out.println("Selamat datang dari thread!");
                } catch (InterruptedException e) {
                    System.out.println("Terjadi kesalahan saat tidur dalam thread.");
                }
            });

            thread.start();
            thread.join();
            System.out.println("Selamat datang dari program utama!");
        } catch (InterruptedException e) {
            System.out.println("Terjadi kesalahan saat menunggu thread selesai.");
        }
    }
}



