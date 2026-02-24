import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nilai = new int[N];

        for (int i = 0; i < N; i++) {
            nilai[i] = sc.nextInt();
        }

        int kodeKelompok = sc.nextInt();

        int K = 4;

        int start = (kodeKelompok - 1) * K;
        int end = (kodeKelompok * K) - 1;

        int total = 0;
        for (int i = start; i <= end && i < N; i++) {
            total += nilai[i];
        }

        System.out.println(total);
        sc.close();
    }
}