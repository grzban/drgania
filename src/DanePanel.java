import javax.swing.*;
import java.awt.*;

class DanePanel  extends JPanel{

    JTextField tDt = new JTextField("0.1");
    JTextField tM = new JTextField("1");
    JTextField tK = new JTextField("1");
    JTextField tX0 = new JTextField("0");
    JTextField tV0 = new JTextField("1");
    JTextField tRo = new JTextField("0.5");
    JTextField tA = new JTextField("0");
    JTextField tOmega = new JTextField("0");

    public DanePanel(){
        setPreferredSize(new Dimension(250, 250));
        setBackground(Color.yellow);

        tDt.setPreferredSize(new Dimension(100,40));
        tDt.setBorder(BorderFactory.createTitledBorder("0.02<=dt<=0.11"));

        add(tDt);

        tM.setPreferredSize(new Dimension(100,40));
        tM.setBorder(BorderFactory.createTitledBorder("m"));
        add(tM);

        tK.setPreferredSize(new Dimension(100,40));
        tK.setBorder(BorderFactory.createTitledBorder("k"));
        add(tK);

        tX0.setPreferredSize(new Dimension(100,40));
        tX0.setBorder(BorderFactory.createTitledBorder("x0"));
        add(tX0);

        tV0.setPreferredSize(new Dimension(100,40));
        tV0.setBorder(BorderFactory.createTitledBorder("v0"));
        add(tV0);

        tRo.setPreferredSize(new Dimension(100,40));
        tRo.setBorder(BorderFactory.createTitledBorder("0<=ro<=10"));
        add(tRo);

        tA.setPreferredSize(new Dimension(100,40));
        tA.setBorder(BorderFactory.createTitledBorder("-0.1<=A<=0.1"));
        add(tA);

        tOmega.setPreferredSize(new Dimension(100,40));
        tOmega.setBorder(BorderFactory.createTitledBorder("0<=omega<=3omega0"));
        add(tOmega);
    }

    Dane pobierzDane(){
        double k, m, ro, A, omega, dt, x0, v0;
        try{
            k = Double.parseDouble(tK.getText());
            m =Double.parseDouble(tM.getText());
            ro =Double.parseDouble(tRo.getText());
            A =Double.parseDouble(tA.getText());
            omega =Double.parseDouble(tOmega.getText());
            dt =Double.parseDouble(tDt.getText());
            x0 =Double.parseDouble(tX0.getText());
            v0 =Double.parseDouble(tV0.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,
                    "Wprowad� poprawne dane!!!",
                    " B��D",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Dane nowe_dane = new Dane(k, m, ro, A, omega, dt, x0, v0);

        return nowe_dane;
    }
}