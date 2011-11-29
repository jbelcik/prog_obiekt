class Ulamek
{
  int licznik, mianownik;

  Ulamek(int l, int m)
  {
    licznik = l;
    mianownik = m;
  }
	
  void mnozPrzez(Ulamek v)
  {
    licznik *= v.licznik;
    mianownik *= v.mianownik;
  }

  void mnozPrzez(int i)
  {
    licznik *= i;
  }

  static Ulamek razy(Ulamek u, Ulamek v)
  {
    return new Ulamek(u.licznik * v.licznik, u.mianownik * v.mianownik);
  }

  public String toString()
  {
    return licznik + "/" + mianownik;
  }
}


class LiczbaU
{
  int calosc;
  Ulamek czescU = new Ulamek(1 ,1);

  LiczbaU(Ulamek u)
  {
    calosc = u.licznik / u.mianownik;
    czescU.licznik = u.licznik % u.mianownik;
    czescU.mianownik = u.mianownik;
  }

  LiczbaU(int c, Ulamek u)
  {
    calosc = c + u.licznik / u.mianownik;
    czescU.licznik = u.licznik % u.mianownik;
    czescU.mianownik = u.mianownik;
  }

  LiczbaU(int c, int l, int m)
  {
    Ulamek u = new Ulamek(l, m);
    calosc = c + u.licznik / u.mianownik;
    czescU.licznik = u.licznik % u.mianownik;
    czescU.mianownik = u.mianownik;
  }

  void mnozPrzez(LiczbaU l)
  {
    czescU.licznik = (calosc * czescU.mianownik + czescU.licznik) * (l.calosc * l.czescU.mianownik + l.czescU.licznik);
    czescU.mianownik *= l.czescU.mianownik;
    calosc = czescU.licznik / czescU.mianownik;
    czescU.licznik %= czescU.mianownik;
  }

  void mnozPrzez(int i)
  {
    czescU.licznik = (calosc * czescU.mianownik + czescU.licznik) * i;
    calosc = czescU.licznik / czescU.mianownik;
    czescU.licznik %= czescU.mianownik;

  }

  void mnozPrzez(Ulamek u)
  {
    czescU.licznik = (calosc * czescU.mianownik + czescU.licznik) * u.licznik;
    czescU.mianownik *= u.mianownik;
    calosc = czescU.licznik / czescU.mianownik;
    czescU.licznik %= czescU.mianownik;
  }

  public String toString()
  {
    if (calosc == 0)
    {
      if (czescU.licznik == 0) return Integer.toString(0);
      else return czescU.toString();
    }
    else if (czescU.licznik == 0) return Integer.toString(calosc);
    else return calosc + " " + czescU.toString();
  }
}


class TestUlamek
{
  public static void main(String[] args)
  {
    Ulamek a = new Ulamek(2, 2);
    Ulamek b = new Ulamek(1, 3);

    a.mnozPrzez(b);
    b.mnozPrzez(2);

    Ulamek c = Ulamek.razy(a, b);

    LiczbaU d = new LiczbaU(a);
    LiczbaU e = new LiczbaU(2, a);
    LiczbaU f = new LiczbaU(1, 4, 3);
    LiczbaU g = new LiczbaU(a);
    LiczbaU h = new LiczbaU(b);
    LiczbaU i = new LiczbaU(3, 2, 5);

    g.mnozPrzez(d);
    h.mnozPrzez(3);
    i.mnozPrzez(a);

    System.out.println(a.toString());
    System.out.println(b.toString());
    System.out.println(c.toString());
    System.out.println(d.toString());
    System.out.println(e.toString());
    System.out.println(f.toString());
    System.out.println(g.toString());
    System.out.println(h.toString());
    System.out.println(i.toString());
  }
}
