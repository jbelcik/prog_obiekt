class Ulamek2
{
  int licznik, mianownik;

  Ulamek2(int l, int m)
  {
    licznik = l;
    mianownik = m;
  }
	
  void mnozPrzez(Ulamek2 v)
  {
    licznik *= v.licznik;
    mianownik *= v.mianownik;
  }

  void mnozPrzez(int i)
  {
    licznik *= i;
  }

  static Ulamek2 razy(Ulamek2 u, Ulamek2 v)
  {
    return new Ulamek2(u.licznik * v.licznik, u.mianownik * v.mianownik);
  }

  public String toString()
  {
    return licznik + "/" + mianownik;
  }

  int getLicznik()
  {
    return licznik;
  }
  
  void setLicznik(int i)
  {
    licznik = i;
  }

  int getMianownik()
  {
    return mianownik;
  }

  void setMianownik(int i)
  {
    mianownik = i;
  }
}


class LiczbaU2
{
  private int calosc;
  private Ulamek2 czescU = new Ulamek2(1 ,1);

  LiczbaU2(Ulamek2 u)
  {
    calosc = u.getLicznik() / u.getMianownik();
    czescU.setLicznik(u.getLicznik() % u.getMianownik());
    czescU.setMianownik(u.getMianownik());
  }

  LiczbaU2(int c, Ulamek2 u)
  {
    calosc = c + u.getLicznik() / u.getMianownik();
    czescU.setLicznik(u.getLicznik() % u.getMianownik());
    czescU.setMianownik(u.getMianownik());
  }

  LiczbaU2(int c, int l, int m)
  {
    Ulamek2 u = new Ulamek2(l, m);
    calosc = c + u.getLicznik() / u.getMianownik();
    czescU.setLicznik(u.getLicznik() % u.getMianownik());
    czescU.setMianownik(u.getMianownik());
  }

  LiczbaU2()
  {
    this(0, 0, 0);
  }

  void mnozPrzez(LiczbaU2 l)
  {
    czescU.setLicznik((calosc * czescU.getMianownik() + czescU.getLicznik()) * (l.calosc * l.czescU.getMianownik() + l.czescU.getLicznik()));
    czescU.setMianownik(czescU.getMianownik() * l.czescU.getMianownik());
    calosc = czescU.getLicznik() / czescU.getMianownik();
    czescU.setLicznik(czescU.getLicznik() % czescU.getMianownik());
  }

  void mnozPrzez(int i)
  {
    czescU.setLicznik((calosc * czescU.getMianownik() + czescU.getLicznik()) * i);
    calosc = czescU.getLicznik() / czescU.getMianownik();
    czescU.setLicznik(czescU.getLicznik() % czescU.getMianownik());
  }

  void mnozPrzez(Ulamek2 u)
  {
    czescU.setLicznik((calosc * czescU.getMianownik() + czescU.getLicznik()) * u.getLicznik());
    czescU.setMianownik(czescU.getMianownik() * u.getMianownik());
    calosc = czescU.getLicznik() / czescU.getMianownik();
    czescU.setLicznik(czescU.getLicznik() % czescU.getMianownik());
  }

  public String toString()
  {
    if (calosc == 0)
    {
      if (czescU.getLicznik() == 0) return Integer.toString(0);
      else return czescU.toString();
    }
    else if (czescU.getLicznik() == 0) return Integer.toString(calosc);
    else return calosc + " " + czescU.toString();
  }
}


class LiczbaUD extends Ulamek2
{
  private int calosc;

  LiczbaUD(Ulamek2 u)
  {
    calosc = u.getLicznik() / u.getMianownik();
    super(u.getLicznik() % u.getMianownik(), u.getMianownik());
  }

  LiczbaUD(int c, Ulamek2 u)
  {
    calosc = c + u.getLicznik() / u.getMianownik();
    super(u.getLicznik() % u.getMianownik(), u.getMianownik());
  }

  LiczbaUD(int c, int l, int m)
  {
    calosc = c + l / m;
    super(l % m, m);
  }

  void mnozPrzez(LiczbaU2 l)
  {
    
  }

  void mnozPrzez(int i)
  {
    licznik = (calosc * mianownik + licznik) * i;
    calosc = licznik / mianownik;
    licznik %= mianownik;
  }

  void mnozPrzez(Ulamek2 u)
  {
    licznik = (calosc * mianownik + licznik) * u.getLicznik();
    mianownik *= u.getMianownik();
    calosc = licznik / mianownik;
    licznik %= mianownik;
  }

  public String toString()
  {
    if (calosc == 0)
    {
      if (licznik == 0) return Integer.toString(0);
      else return licznik + "/" + mianownik;
    }
    else if (licznik == 0) return Integer.toString(calosc);
    else return calosc + " " + licznik + "/" + mianownik;
  }
}


class TestUlamek2
{
  public static void main(String[] args)
  {
    Ulamek2 a = new Ulamek2(2, 2);
    Ulamek2 b = new Ulamek2(1, 3);

    a.mnozPrzez(b);
    b.mnozPrzez(2);

    Ulamek2 c = Ulamek2.razy(a, b);

    LiczbaUD d = new LiczbaUD(a);
    LiczbaUD e = new LiczbaUD(2, a);
    LiczbaUD f = new LiczbaUD(1, 4, 3);
    LiczbaUD g = new LiczbaUD(a);
    LiczbaUD h = new LiczbaUD(b);
    LiczbaUD i = new LiczbaUD(3, 2, 5);

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
