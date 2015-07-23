
import java.io.*;
import java.util.StringTokenizer;

public class Card_game {

    static int no[] = new int[10000];
    static double t = 1;

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int i = 0, line, n, k;
        double ans = 0;
        String t, str;
        File f1 = new File("f:/FB Hacker_cup/input.txt");
        File f2 = new File("f:/FB Hacker_cup/output.txt");
        FileReader fr = new FileReader(f1);
        FileWriter fw = new FileWriter(f2);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        line = Integer.parseInt(br.readLine());
        for (int j = 0; j < line; j++) {

            t = br.readLine();

            StringTokenizer st = new StringTokenizer(t);
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            str = br.readLine();
            ans = answer(n, k, str);
            ans = ans % 1000000007;

            bw.write("Case #" + (j + 1) + ": " + (int) ans + "\n");
            System.out.println("Success" + j);
        }
        fr.close();
        bw.close();
    }

    public static double answer(int n, int k, String s) {
        int tot = 0, i = 0, count, j, swap;
        double ncr = 0, temp;
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        count = stringTokenizer.countTokens();
        while (stringTokenizer.hasMoreTokens()) {

            no[i] = Integer.parseInt(stringTokenizer.nextToken());
            i++;
        }
        for (i = 0; i < count; i++) {
            for (j = i + 1; j < count; j++) {
                if (no[i] < no[j]) {
                    swap = no[i];
                    no[i] = no[j];
                    no[j] = swap;
                }
            }
        }
        i = 0;
        n--;
        k--;
        if (n != k) {
            while (n > k) {
                t = 1;
                combi(n, k);
                ncr = ncr + t * no[i];
                System.out.println(ncr + " " + t + " " + no[i]);
                n--;
                i++;

            }
            ncr = ncr + no[i];
        } else {
            ncr = no[i];
        }
        System.out.println(ncr + " " + no[i]);
        return ncr;
    }

    public static double fact(int num) {
        double fact = 1, i;
        for (i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void combi(int n, int k) {
        t = 1;
        System.out.println(n + "c" + k);
        while (k > 0) {
            t *= (n / (k * 1.0));
            n--;
            k--;

        }
    }
}
