import javax.swing.*;
import java.awt.*;

/**
 * Created by gb on 2016-10-04.
 */
class WykresVodX extends JPanel{
    Dane dane;

    public WykresVodX(){
        setBackground(Color.white);
        setBorder(BorderFactory.createTitledBorder(  "V(x)"));
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
        g.drawLine(10,h/2,w-10,h/2);//os x
        g.drawLine(w/2,20,w/2,h-10);//os y

        int N = 500;

        double _x[] = new double[N];
        double _v[] = new double[N];


        double x, y, v, f, u;

        x = dane.x0;
        v = dane.v0;

        double t, t2 = dane.dt/2;

        int i;

        for(i=0; i<N; i++){
            t = i*dane.dt;
            t2 += dane.dt;

            _x[i] = x;
            _v[i] = v;

            y = x + v * dane.dt/2;
            f = - dane.k*x - dane.ro*v + dane.A * Math.sin(dane.omega * t);
            u = v + f * dane.dt/(2*dane.m);
            x = x + u * dane.dt;
            f = - dane.k * y - dane.ro * u + dane.A * Math.sin(dane.omega * t2);
            v = v + f * dane.dt/dane.m;

            int yscr2, xscr2;

            yscr2 = (int)((h/2) *(1.0 - _v[i]/1.5));
            xscr2 = (int)(w/2*(1.0 - _x[i]/1.5));

            g.setColor(Color.green);
            g.drawOval(xscr2, yscr2, 1,1);
        }

        //rysowanie punktu pocz�tkowego
        g.setColor(Color.red);
        int Vpocz, Xpocz;
        Vpocz = (int)(h/2*(1.0 -_v[0]/1.5));
        Xpocz = (int)(h/2*(1.0 -_x[0]/1.5));

        g.fillOval(Xpocz,Vpocz, 5,5);
    }
}