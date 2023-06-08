package Nomor2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BoekoeKoe {
    private static Map<String, String> users = new HashMap<>();
    static {
        users.put("Dita", "002");
        users.put("Iput", "008");
        users.put("Jela", "030");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat datang di aplikasi Boekoe! Login untuk menggunakan Aplikasi.");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            User user1 = new User("Putri Andriyani");
            System.out.println("Login berhasil. Selamat datang, " + user1.getUsername() + "!");
            System.out.println("Menu: ");
            System.out.println("1. Tambah Pengeluaran");
            System.out.println("2. Tambah Pemasukan");
            System.out.println("3. Ingin Dibeli");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Scanner keluar = new Scanner(System.in);
                    System.out.print("Tanggal          : ");
                    String tglkeluar = keluar.nextLine();
                    System.out.print("Jenis Pengeluaran: ");
                    String ktgrkeluar = keluar.nextLine();
                    System.out.print("Besar Pengeluaran: ");
                    double hrgkeluar = keluar.nextDouble();
                    Pengeluaran pengeluaran = new Pengeluaran();
                    pengeluaran.saveToFile(tglkeluar, ktgrkeluar, hrgkeluar);
                    System.out.println("Daftar pengeluaran telah disimpan.");
                    keluar.close();
                    break;
                case 2:
                    Scanner masuk = new Scanner(System.in);
                    System.out.print("Tanggal          : ");
                    String tglmasuk = masuk.nextLine();
                    System.out.print("Jenis Pemasukan  : ");
                    String ktgrmasuk = masuk.nextLine();
                    System.out.print("Besar Pemasukan  : ");
                    double hrgmasuk = masuk.nextDouble();
                    Pemasukan pemasukan = new Pemasukan();
                    pemasukan.saveToFile(tglmasuk, ktgrmasuk, hrgmasuk);
                    System.out.println("Daftar pemasukan telah disimpan.");
                    masuk.close();
                    break;
                case 3:
                    Scanner ingin = new Scanner(System.in);
                    System.out.print("Jenis Keinginan  : ");
                    String wish = ingin.nextLine();
                    System.out.print("Biaya            : ");
                    double harga = ingin.nextDouble();
                    saveToFile(wish, harga);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } else {
            System.out.println("Username atau password salah. Login gagal.");
        }
        scanner.close();
        System.out.println("\n\nCatatan - Boekoe\n");
        DisplayInput.displayInputFromFile();
        Hitung.hitungTotal();
    }

    private static void saveToFile(String tgl, String kategori, double harga, String jenis) {
        try {
            FileWriter writer = new FileWriter("Boekoe.txt",
                    true);
            writer.write("Tanggal          : " + tgl + "\n");
            writer.write("Jenis " + jenis + "  : " + kategori + "\n");
            writer.write("Besar " + jenis + "  : " + harga + "\n");
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveToFile(String wish, double harga) {
        saveToFile("Keinginan", wish, harga, "Harga");
    }
    private static boolean authenticateUser(String username, String password) {
        if (users.containsKey(username)) {
            String storedPassword = users.get(username);
            return password.equals(storedPassword);
        }
        return false;
    }

    static class DisplayInput {
        static void displayInputFromFile() {
            try {
                File file = new File("Boekoe.txt");
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File 'Boekoe.txt' tidak ditemukan.");
            }
        }
    }

    static class User {
        private String username;

        public User(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    static class Hitung {
        static void hitungTotal() {
            try {
                File file = new File("Boekoe.txt");
                Scanner scanner = new Scanner(file);

                double totalPengeluaran = 0;
                double totalPemasukan = 0;
                double totalKeinginan = 0;

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains("Besar Pengeluaran  :")) {
                        double pengeluaran = Double.parseDouble(line.substring(line.lastIndexOf(":") + 1).trim());
                        totalPengeluaran += pengeluaran;
                    } else if (line.contains("Besar Pemasukan  :")) {
                        double pemasukan = Double.parseDouble(line.substring(line.lastIndexOf(":") + 1).trim());
                        totalPemasukan += pemasukan;
                    } else if (line.contains("Besar Harga  :")) {
                        double keinginan = Double.parseDouble(line.substring(line.lastIndexOf(":") + 1).trim());
                        totalKeinginan += keinginan;
                    }
                }
                scanner.close();
                System.out.println("Total Pengeluaran: " + totalPengeluaran);
                System.out.println("Total Pemasukan  : " + totalPemasukan);
                System.out.println("Total Saldo      : " + (totalPemasukan - totalPengeluaran));
                System.out.println("Total Keinginan  : " + totalKeinginan);

                if (totalKeinginan == 0) {
                    System.out.println("Wah, kamu tidak memiliki wishlist.");
                } else if (totalKeinginan >= (totalPemasukan - totalPengeluaran)) {
                    System.out.println("Kamu belum bisa memenuhi wishlistmu. Ayo berhemat!");
                } else {
                    System.out.println("Uangmu masih cukup untuk memenuhi wishlistmu. Tolong jangan terlalu boros.");
                }

            } catch (FileNotFoundException e) {
                System.out.println("File 'Boekoe.txt' tidak ditemukan.");
            }
        }
    }

    static class Pengeluaran extends BoekoeKoe {
        private void saveToFile(String tgl

                , String kategori, double harga) {
            super.saveToFile(tgl, kategori, harga, "Pengeluaran");
        }
    }

    static class Pemasukan extends BoekoeKoe {
        private void saveToFile(String tgl, String kategori, double harga) {
            super.saveToFile(tgl, kategori, harga, "Pemasukan");
        }
    }
}