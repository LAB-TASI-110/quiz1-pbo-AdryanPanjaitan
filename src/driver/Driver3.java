import java.time.*;
import java.util.*;
import java.util.concurrent.*;

// Status laundry
enum StatusLaundry {
    DIJEMPUT, DIPROSES, DIANTAR, SELESAI
}

// Entitas laundry
class LaundryOrder {
    String id;
    String asrama;
    LocalDateTime waktuPickup;
    LocalDateTime waktuAntar;
    StatusLaundry status;

    public LaundryOrder(String id, String asrama,
                         LocalDateTime pickup,
                         LocalDateTime antar) {
        this.id = id;
        this.asrama = asrama;
        this.waktuPickup = pickup;
        this.waktuAntar = antar;
        this.status = StatusLaundry.DIJEMPUT;
    }
}

// Service notifikasi
class NotificationService {
    public static void kirimNotif(LaundryOrder order) {
        System.out.println("\n🔔 NOTIFIKASI 🔔");
        System.out.println("Laundry untuk asrama " + order.asrama +
                " sudah KEMBALI ke asrama!");
        System.out.println("Waktu antar: " + order.waktuAntar);
        System.out.println("Silakan diambil.");
    }
}

// Driver utama
public class Driver3 {
    public static void main(String[] args) {
        System.out.println("Program jalan!");
    
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama asrama: ");
        String asrama = sc.nextLine();

        // Jadwal tetap DEL
        LocalDateTime pickup =
                LocalDateTime.of(2026, 2, 27, 20, 0); // Jumat 20:00

        LocalDateTime antar =
                LocalDateTime.of(2026, 2, 28, 14, 0); // Sabtu 14:00

        LaundryOrder order =
                new LaundryOrder("LD001", asrama, pickup, antar);

        System.out.println("\n=== JADWAL LAUNDRY ===");
        System.out.println("Laundry dijemput : " + pickup);
        System.out.println("Laundry diantar  : " + antar);

        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();

        System.out.println("\n⏳ Laundry sedang diproses...");
        System.out.println("(Simulasi: 10 detik = 18 jam)");

        // Simulasi waktu → 10 detik = 18 jam
        scheduler.schedule(() -> {
            order.status = StatusLaundry.DIANTAR;
            NotificationService.kirimNotif(order);
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);

        sc.close();
    }
}