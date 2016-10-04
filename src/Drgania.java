import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * <p>Title: Drgania harmoniczne wymuszone z sila oporu hydrodynamicznego</p>
 * @authors: 
 * Grzegorz Banaszek
 * @version 1.0
 */

class Drgania extends JFrame{

    DanePanel panelDane = new DanePanel();

    WykresXodT wyk0 = new WykresXodT();
    WykresVodT wyk1 = new WykresVodT();
    WykresVodX wyk2 = new WykresVodX();
    WykresAodT wyk3 = new WykresAodT();

    JTextArea text = new JTextArea("DRGANIA HARMONICZNE WYMUSZONE"+
                                 "\nZ SIL� OPORU HYDRODYNAMICZNEGO"+
                                 "\nWarsztaty komputerowe"+
                                 "\nGrzegorz Banaszek"+
                                 "\nOpiekun: prof R.Kutner");

    JPanel wykresy = new JPanel();
    JPanel p = new JPanel();//do tego panelu dodane sa: tytul, panelDane, przyciski
    JPanel pusty = new JPanel();
    JPanel tytul = new JPanel();
    JPanel przyciski = new JPanel();

    Button bRysuj = new Button("RYSUJ");

    public Drgania(){

        setBackground(Color.blue);
        setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        setVisible(true);

        pack();
        setTitle("Drgania harmoniczne wymuszone z sila oporu hydrodynamicznego");
        setSize(920,670);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wykresy.setLayout( new GridLayout(2,2,20,20));
        wykresy.setPreferredSize(new Dimension(620,620));
        wykresy.setBackground(Color.white);

	    wykresy.add(wyk0);
        wykresy.add(wyk1);
        wykresy.add(wyk2);
        wykresy.add(wyk3);

        add(wykresy);

        pusty.setPreferredSize(new Dimension(20 ,620));
        pusty.setBackground(Color.white);
        add(pusty);

        bRysuj.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                wyk0.ustawDane(panelDane.pobierzDane());
                wyk1.ustawDane(panelDane.pobierzDane());
                wyk2.ustawDane(panelDane.pobierzDane());
                wyk3.ustawDane(panelDane.pobierzDane());
            }
        });

        przyciski.add(bRysuj);

        przyciski.setBackground(Color.yellow);
        przyciski.setPreferredSize(new Dimension(300, 60));

        p.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        p.setPreferredSize(new Dimension(250,620));
        p.setBackground(Color.yellow);

        tytul.setPreferredSize(new Dimension(250,120));
        tytul.setBackground(Color.yellow);
        text.setPreferredSize(new Dimension(250,120));
        text.setBackground(Color.yellow);
        tytul.add(text);

        p.add(tytul);
        p.add(panelDane);
        p.add(przyciski);

        add(p);
    }
}