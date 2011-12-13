import java.util.*;


class Student //implements Comparable<Student>
{
  int nr;
  String imie;
  ArrayList<Integer> oceny;

  Student(int n, String i)
  {
    nr = n;
    imie = i;
    oceny = new ArrayList<Integer>();
  }

  public boolean equals(Object o)
  {
    if (!(o instanceof Student)) return false;
    Student s = (Student)o;
    if (s.nr == nr) return true;
    else return false;
  }

  public String ocenyToString()
  {
    int i;
    String o = "";

    for (i = 0; i < oceny.size(); i++) o += Integer.toString(oceny.get(i)) + "\n";
    return o;
  }

  public String toString()
  {
    return nr + " " + imie + "\n" + ocenyToString();
  }

  /*public int compareTo(Student s)
  {
    return this.imie.compareTo(s.imie);
  }*/
}


/*class Porownaj implements Comparator<Student>
{    
  public int compare(Student s1, Student s2)
  {
    int i,
        max1 = 0,
        max2 = 0;

    for (i = 0; i < s1.oceny.size(); i++) if (s1.oceny.get(i) > max1) max1 = s1.oceny.get(i);
    for (i = 0; i < s2.oceny.size(); i++) if (s2.oceny.get(i) > max2) max2 = s2.oceny.get(i);

    if (max1 >= max2) return -1;
    else return 1;
  }
}*/


class WykazS
{
  ArrayList<Student> wykaz = new ArrayList<Student>();

  void wstawStudenta(int n, String i)
  {
    wykaz.add(new Student(n, i));
  }

  void wstawOcene(int n, int o)
  {
    int i = wykaz.indexOf(new Student(n, ""));
    Student s = wykaz.get(i);
    s.oceny.add(o);
  }

  void wypisz(int n)
  {
    int i = wykaz.indexOf(new Student(n, ""));
    Student s = wykaz.get(i);
    System.out.println(s.toString());
  }

  void wypisz()
  {
    int i;
    for (i = 0; i < wykaz.size(); i++)
    {
      Student s = wykaz.get(i);
      System.out.println(s.toString()); 
    }
  }

  /*public void sortujA()
  {
    Collections.sort(wykaz);
  }

  public void sortujM()
  {
    Collections.sort(wykaz, new Porownaj());
  }*/
}


class TestWykazS
{
  public static void main(String[] a)
  {
    WykazS ws = new WykazS();

    ws.wstawStudenta(199200,"Kazik");
    ws.wstawStudenta(199201,"Kazik");
    ws.wstawStudenta(199204,"Nikodem");
    ws.wstawStudenta(199205,"Jan");
    ws.wstawStudenta(189557,"Wiesiek");
  
    ws.wstawOcene(199200,5);
    ws.wstawOcene(199200,4);
    ws.wstawOcene(199200,3);
    ws.wstawOcene(199200,5);
    ws.wstawOcene(199200,2);

    ws.wstawOcene(199201,5);
    ws.wstawOcene(199201,6);
 
    ws.wstawOcene(199204,4);
    ws.wstawOcene(199204,5);
    ws.wstawOcene(199201,4);

    ws.wstawOcene(199205,3);
    ws.wstawOcene(189557,5);

    ws.wypisz();
    //ws.wypisz(199200);
  }
}
