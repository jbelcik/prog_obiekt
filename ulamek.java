class ulamek
{
  int licznik, mianownik;

  ulamek(int l, int m)
  {
    licznik = l;
    mianownik = m;
  }
	
  void mnozPrzez(ulamek v)
  {
    licznik *= v.licznik;
    mianownik *= v.mianownik;
  }

  void mnozPrzez(int i)
  {
    licznik *= i;
  }

  static ulamek razy(ulamek u, ulamek v)
  {
    return new ulamek(u.licznik * v.licznik, u.mianownik * v.mianownik);
  }

  public String toString()
  {
    return licznik + "/" + mianownik;
  }
}


class liczbaU
{
  int calosc;
  ulamek czescU = new ulamek(1 ,1);

  liczbaU(ulamek u)
  {
    calosc = u.licznik / u.mianownik;
    czescU.licznik = u.licznik % u.mianownik;
    czescU.mianownik = u.mianownik;
  }

  liczbaU(int c, ulamek u)
  {
    calosc = c + u.licznik / u.mianownik;
    czescU.licznik = u.licznik % u.mianownik;
    czescU.mianownik = u.mianownik;
  }

  liczbaU(int c, int l, int m)
  {
    ulamek u = new ulamek(l, m);
    calosc = c + u.licznik / u.mianownik;
    czescU.licznik = u.licznik % u.mianownik;
    czescU.mianownik = u.mianownik;
  }

  void mnozPrzez(liczbaU l)
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

  void mnozPrzez(ulamek u)
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


class testUlamek
{
  public static void main(String[] args)
  {
    ulamek a = new ulamek(2, 2);
    ulamek b = new ulamek(1, 3);

    a.mnozPrzez(b);
    b.mnozPrzez(2);

    ulamek c = ulamek.razy(a, b);

    liczbaU d = new liczbaU(a);
    liczbaU e = new liczbaU(2, a);
    liczbaU f = new liczbaU(1, 4, 3);
    liczbaU g = new liczbaU(a);
    liczbaU h = new liczbaU(b);
    liczbaU i = new liczbaU(3, 2, 5);

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
