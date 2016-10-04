import javax.swing.*;
import java.awt.*;

class WykresXodT extends JPanel{
    Dane dane;

    public WykresXodT(){
        setBackground(Color.white);
        setBorder(BorderFactory.createTitledBorder(  "x(t)"));

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

        int N = 1000;
        double _x[] = new double[N];
        double _v[] = new double[N];

        double x, y, v, f, u;

        x = dane.x0;
        v = dane.v0;

        double t;

        int i;

        for(i=0; i<N; i++){
            t = i*dane.dt;

            _x[i] = x;
            _v[i] = v;

            y = x + v * dane.dt/2;
            f = - dane.k*x - dane.ro*v + dane.A * Math.sin(dane.omega * t);
            u = v + f * dane.dt/(2*dane.m);
            x = x + u * dane.dt;
            f = - dane.k * y - dane.ro * u + dane.A* Math.sin(dane.omega *(t +   dane.dt/2));
            v = v + f * dane.dt/dane.m;

            int xscr, yscr;

            xscr = (int)(w * t/20+10);
            yscr = (int)((h/2) * (1.0 -_x[i]/1.5 ));

            g.setColor(Color.red);
            g.drawOval(xscr, yscr, 1, 1);
        }
        //rysowanie punktu pocz�tkowego
        g.setColor(Color.blue);
        int Xpocz, tpocz = 10;

        Xpocz = (int)(h/2*(1.0 - _x[0]/1.5 ));
        g.fillOval(tpocz,Xpocz, 5,5);
    }
}