import java.util.zip.*;
import java.io.*;

class UnGzip
{
  public static void main(String[] args) throws IOException
  {
    BufferedInputStream  we = new BufferedInputStream (new GZIPInputStream(new FileInputStream (args[0])));
    BufferedOutputStream wy = new BufferedOutputStream(new FileOutputStream((args[1])));

    int c;
    while ((c = we.read())!= -1) wy.write(c);
    we.close();
    wy.close();
  }
}
