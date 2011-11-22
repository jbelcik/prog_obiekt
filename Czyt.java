import java.io.*;

class Czyt
{
    final int ogr = 200;            // ograniczenie na ilosc danych
    String[] tab = new String[ogr]; // tablica napisow
    int ile;                        // ilosc danych

    // czytanie z pliku do tablicy tab
    void czytaj(String plikWe) throws IOException
    {
      BufferedReader br = new BufferedReader(new FileReader(plikWe));
      String linia; 
      ile = 0; 
      while ((linia = br.readLine()) != null)  
      {
        if (linia.length() > 0) tab[ile++] = linia;
      }
      br.close();
    }
    
    // drukowanie tablicy tab[]
    void pisz_bin()
    {
       int i;
       for (i = 0; i < ile; i++)
       {
         int x, pre, j, k;
         String bin;

         x = Integer.parseInt(tab[i]);
         pre = Integer.numberOfLeadingZeros(x) - 1;
         if (x == 0) pre--;
         bin = Integer.toBinaryString(x);
         for (j = 0; j <= pre; j++) 
         {
           if (j%8 == 0 && j != 0) System.out.print(" ");
           System.out.print("0");
         }
         char[] y = bin.toCharArray();
         for (k = 0; k < y.length; k++)
         {
           if ((k + j)%8 == 0) System.out.print(" ");
           System.out.print(y[k]);
         }
         System.out.print("\n");
       }
    }

    public static void main(String[] args) throws Exception
    {
      Czyt cz = new Czyt();
      if (args.length >= 1)
      {
        cz.czytaj(args[0]);
        cz.pisz_bin();
      }
      else System.err.println("Uzycie: Czyt plik_wejsciowy");
    }
}
