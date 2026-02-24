
import java.util.*;

public class Driver1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== DATA MENU =====
        Map<String, String> namaMenu = new HashMap<>();
        Map<String, Integer> hargaMenu = new HashMap<>();

        namaMenu.put("NGS", "Nasi Padang");
        hargaMenu.put("NGS", 25000);

        namaMenu.put("RDG", "Rendang");
        hargaMenu.put("RDG", 30000);

        namaMenu.put("AG", "Ayam Goreng");
        hargaMenu.put("AG", 22000);

        namaMenu.put("AP", "Air Putih");
        hargaMenu.put("AP", 5000);

        namaMenu.put("GG", "Es Teh");
        hargaMenu.put("GG", 10000);

        // ===== PENYIMPANAN PESANAN =====
        List<String> listKode = new ArrayList<>();
        List<Integer> listPorsi = new ArrayList<>();
        List<Integer> listTotal = new ArrayList<>();

        int totalBayar = 0;

        // ===== INPUT =====
        while (true) {
            String kode = sc.nextLine().trim();
            if (kode.equals("END")) {
                break;
            }

            int porsi = Integer.parseInt(sc.nextLine().trim());
            int harga = hargaMenu.get(kode);
            int total = harga * porsi;

            listKode.add(kode);
            listPorsi.add(porsi);
            listTotal.add(total);

            totalBayar += total;
        }

        // ===== DISKON (KUPON) =====
        double diskon = 0;
        String kupon = "Tidak Ada";

        if (totalBayar >= 200000) {
            diskon = 0.20;
            kupon = "Kuning (20%)";
        } else if (totalBayar >= 100000) {
            diskon = 0.10;
            kupon = "Biru (10%)";
        }

        int potongan = (int)(totalBayar * diskon);
        int totalAkhir = totalBayar - potongan;

        // ===== OUTPUT STRUK =====
        System.out.printf("%-15s %5s %8s %10s\n", 
            "Menu", "Porsi", "Harga", "Total");
        System.out.println("==============================================");

        for (int i = 0; i < listKode.size(); i++) {
            String kode = listKode.get(i);
            System.out.printf("%-15s %5d %8d %10d\n",
                namaMenu.get(kode),
                listPorsi.get(i),
                hargaMenu.get(kode),
                listTotal.get(i));
        }

        System.out.println("==============================================");
        System.out.printf("%-25s : %10d\n", "Subtotal", totalBayar);
        System.out.printf("%-25s : %10s\n", "Kupon", kupon);
        System.out.printf("%-25s : %10d\n", "Diskon", potongan);
        System.out.println("==============================================");
        System.out.printf("%-25s : %10d\n", "Total Pembayaran", totalAkhir);
    }
}