
import java.io.*;

public class Beautiful_string {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {  
        int line;
        String t;
        int len, temp, swap, tot = 0, count;
        int ans[] = new int[26];
        int extra[] = new int[26];
        char c;
        File f1 = new File("f:/Hacker_cup/input.txt");
        File f2 = new File("f:/Hacker_cup/output.txt");
        FileReader fr = new FileReader(f1);
        FileWriter fw = new FileWriter(f2);
        BufferedWriter bw = new BufferedWriter(fw);

        BufferedReader br = new BufferedReader(fr);

        line = Integer.parseInt(br.readLine());
        System.out.println(line);
   //   line=1;

        for (int i = 0; i < line; i++) {
            tot = 0;
            t = br.readLine();
            count = 26;
            for (int j = 0; j < 26; j++) {
                ans[j] = 0;
            }
            // t="So I just go consult Professor Dalves.";
            len = t.length();
            t = t.toUpperCase();
            for (int j = 0; j < len; j++) {
                c = t.charAt(j);
                if (Character.isLetter(c)) {
                    temp = (int) c;
                    temp -= 65;
                    ans[temp]++;
                }
            }
            extra = ans;
            for (int j = 0; j < 26; j++) {
                for (int k = j + 1; k < 26; k++) {
                    if (extra[j] < extra[k]) {
                        swap = extra[j];
                        extra[j] = extra[k];
                        extra[k] = swap;
                    }
                }
            }
            for (int j = 0; j < 26; j++) {
                if (extra[j] != 0) {
                    tot += extra[j] * count;
                    count--;
                }
                //System.out.println((char)(j+65) +" " + ans[j]);
            }
            // System.out.println(tot);
            bw.write("Case #" + (i + 1) + ": " + tot + "\n");
        }
        fr.close();
        bw.close();
    }
}
