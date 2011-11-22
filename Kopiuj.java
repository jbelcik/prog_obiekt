import java.io.*;

class Kopiuj
{
  public static void main(String[] args) throws Exception
    {
        if (args.length < 2)
          System.out.println("Poprawne Uzycie: Kopiuj PlikWejsciowy PlikWyjsciowy");
        else
        {
          FileReader we = new FileReader(args[0]);
          FileWriter wy = new FileWriter(args[1]);
                                
          int c;
          int l = 0;
          while ((c = we.read()) != -1)
          {
            if(c == '\n') l++;
            if(Character.isLowerCase(c))
            {
              wy.write(c); 
              wy.write(c);
            }
            else
            {
              c = Character.toLowerCase(c);
              wy.write(c);
            }
          }

        we.close();
        wy.close();
        System.out.println("skopiowano " + l + " wierszy");
        }
    }
}
