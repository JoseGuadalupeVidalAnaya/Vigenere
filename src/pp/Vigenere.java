package pp;

public class Vigenere
{
    String[][] alfa;
    String mensaje, clave;

    public Vigenere()
    {
        String s = "ABCDEFGHIJKLMNÑOPQRSTUVWXZ";
        setAlfa(s);
    }

    void setAlfa(String s)
    {
        alfa = new String[s.length()][s.length()];
        for (int i = 0; i < alfa.length; i++)
        {
            for (int j = 0, k = i; j < alfa[i].length; j++, k++)
            {
                if (k == s.length())
                {
                    k = 0;
                }
                alfa[i][j] = s.charAt(k) + "";
            }
        }
        for (int i = 0; i < alfa.length; i++)
        {
            for (int j = 0; j < alfa[i].length; j++)
            {
                System.out.print(alfa[i][j]);
            }
            System.out.println();
        }
    }

    void setClave(String c)
    {
        clave = c;
    }

    void setMensaje(String m)
    {
        mensaje = m;
    }

    String cifrar()
    {
        String s = "";
        for (int i = 0, j = 0; i < mensaje.length(); i++, j++)
        {
            if (j == clave.length())
                j = 0;
            if (mensaje.charAt(i) == ' ')
            {
                s = s + " ";
                j--;
            }
            else
                s = s + buscar(clave.charAt(j) + "", mensaje.charAt(i) + "");
        }
        mensaje = s;
        return s;
    }

    String decifrar()
    {
        String s = "";
        for (int i = 0, j = 0; i < mensaje.length(); i++, j++)
        {
            if (j == clave.length())
                j = 0;
            if (mensaje.charAt(i) == ' ')
            {
                s = s + " ";
                j--;
            }
            else
                s = s + buscar2(clave.charAt(j) + "", mensaje.charAt(i) + "");
        }
        return s;
    }

    String buscar(String c, String l)
    {
        String s = "";
        for (int i = 0; i < alfa.length; i++)
        {
            for (int j = 0; j < alfa[i].length; j++)
            {
                if (alfa[i][0].equals(c) && alfa[0][j].equals(l))
                {
                    s = alfa[i][j];
                }
            }
        }
        return s;
    }

    String buscar2(String c, String l)
    {
        String s = "";
        for (int i = 0; i < alfa.length; i++)
        {
            for (int j = 0; j < alfa[i].length; j++)
            {
                if (alfa[i][0].equals(c) && alfa[i][j].equals(l))
                {
                    s = alfa[0][j];
                }
            }
        }
        return s;
    }
}
