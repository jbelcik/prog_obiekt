import java.util.zip.*;
import java.io.*;

class Gzip
{
  public static void main(String[] args) throws IOException
  {
    BufferedInputStream  we = new BufferedInputStream (new FileInputStream (args[0]));
    BufferedOutputStream wy = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream((args[0]+".gz"))));

    int c;
    while ((c = we.read())!= -1) wy.write(c);
    we.close();
    wy.close();
  } 
}
