import java.awt.*;
import java.awt.event.*;

public class OXOGame extends Frame implements WindowListener
{
    private static final Font font = new Font("SansSerif", Font.PLAIN, 14);

    public static void main(String args[])
    {
        new OXOGame(250,300);
    }

    public OXOGame(int width, int height)
    {
        super("OXO Board");
        OXOModel model = new OXOModel(3,3,3);
        model.addPlayer(new OXOPlayer('X'));
        model.addPlayer(new OXOPlayer('O'));
        OXOController controller = new OXOController(model);
        TextField inputBox = new TextField("");
        inputBox.setFont(font);
        OXOView view = new OXOView(controller, model, inputBox);
        Panel contentPane = new Panel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputBox, BorderLayout.SOUTH);
        contentPane.add(view, BorderLayout.CENTER);
        this.setLayout(new GridLayout(1,1));
        this.add(contentPane);
        this.setSize(width, height);
        this.setVisible(true);
        this.addWindowListener(this);
    }

    public Insets getInsets()
    {
        return new Insets(30, 7, 7, 7);
    }

    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}

    public void windowClosing(WindowEvent e)
    {
        this.dispose();
        System.exit(0);
    }
}
