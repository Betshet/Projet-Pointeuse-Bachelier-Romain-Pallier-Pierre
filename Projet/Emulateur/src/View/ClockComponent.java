package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

 

 

public class ClockComponent extends JPanel implements ActionListener 
{

	private static final long serialVersionUID = 1L;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy    HH:mm:ss");
    private JLabel clock;

    public ClockComponent() 
    {
        clock = new JLabel();
        add(clock);
        updateClock();
        new Timer(1000, this).start();
    }
      
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        updateClock();
    }

    private void updateClock() 
    {
        clock.setText(dateFormat.format(Calendar.getInstance().getTime()));
    }

}
