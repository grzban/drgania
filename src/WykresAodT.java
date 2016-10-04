import javax.swing.*;
import java.awt.*;

/**
 * Created by gb on 2016-10-04.
 */

class WykresAodT extends JPanel{

    Dane dane;

    public WykresAodT(){
        setBackground(Color.white);
        setBorder(BorderFactory.createTitledBorder(  "a(t)"));
    }

    void ustawDane(Dane dane){
        this.dane = dane;
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if (dane == null){
            return;
        }

        int w = getWidth();
        int h = getHeight();

        //osie
        g.drawLine(10,h/2,w-10,h/2);
        g.drawLine(10,20,10,h-10);

        int i;

        int N = 1000;

        double _x[] = new double[N];
        double _v[] = new double[N];
        double _a[] = new double[N];

        double x, y, v, f, u, a;

        double t;

        x = dane.x0;
        v = dane.v0;

        for(i=0; i<N; i++){
            t = i*dane.dt;

            _x[i] = x;
            _v[i] = v;


            y = x + v * dane.dt/2;
            f = - dane.k*x - dane.ro*v + dane.A * Math.sin(dane.omega * t);
            u = v + f * dane.dt/(2*dane.m);
            a =f/dane.m;
            x = x + u * dane.dt;
            f = - dane.k * y - dane.ro * u + dane.A * Math.sin(dane.omega * (t + dane.dt/2));
            v = v + f * dane.dt/dane.m;

            _a[i] = a;

            int xscr, yscr;

            xscr = (int)(w* t/20+10);
            yscr = (int)(h/2*(1.0 - _a[i]/1.5));

            g.setColor(Color.blue);
            g.drawOval(xscr, yscr, 1, 1);

        }
        //rysowanie punktu pocz�tkowego
        g.setColor(Color.red);

        int Apocz, tpocz = 10;

        Apocz = (int)(h/2*(1.0 - _a[0]/1.5));
        g.fillOval(tpocz,Apocz, 5,5);
    }
}
