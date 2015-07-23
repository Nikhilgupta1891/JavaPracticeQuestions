import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AlphabetSoup 
{
   public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File f1 = new File("D:\\Aplhabet Soup\\input.txt");
        File f2 = new File("D:\\Aplhabet Soup\\output.txt");
        FileReader fr = new FileReader(f1);
        FileWriter fw = new FileWriter(f2,true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        int line;
        String t;
        char c;
        int min;
        int letter[] = {0, 0, 0, 0, 0, 0, 0, 0};
        int l ;
        line = Integer.parseInt(br.readLine());
        System.out.println("Total no output line will be: "+line);
        

        for (int i = 0; i < line; i++) 
        {
            t = br.readLine();
            l = t.length();
            t = t.toUpperCase();
            for(int j=0;j<8;j++)
                letter[j]=0;
            for (int j = 0; j < l; j++) 
            {
                c = t.charAt(j);
                switch (c) {
                    case 'H':
                        letter[0]++;
                        break;
                    case 'A':
                        letter[1]++;
                        break;
                    case 'C':
                        letter[2]++;
                        break;
                    case 'K':
                        letter[3]++;
                        break;
                    case 'E':
                        letter[4]++;
                        break;
                    case 'R':
                        letter[5]++;
                        break;
                    case 'U':
                        letter[6]++;
                        break;
                    case 'P':
                        letter[7]++;
                        break;
                    default:
                        break;
                }

            }
            letter[2] = (int) (letter[2] / 2);
            min = letter[0];

            for (int j = 1; j < 8; j++) 
            {
                if (letter[j] < min) 
                {
                    min = letter[j];
                }
            }
            
            bw.write("Case #"+(i+1)+": "+min);
            bw.newLine();
            System.out.println(t );
            System.out.println("Case #"+(i+1)+": "+min);
           
        }
        fr.close();
        bw.close();
    }
}
