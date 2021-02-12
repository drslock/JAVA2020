import java.awt.*;
import java.awt.event.*;
import OXOExceptions.*;

public class OXOView extends Canvas implements ActionListener
{
    int fontSize = 16;
    private final Font font = new Font("SansSerif", Font.PLAIN, fontSize);
    private final int margin = 40;
    private String message = "";
    TextField commandInputBox;
    OXOController controller;
    OXOModel model;

    public OXOView(OXOController control, OXOModel mod, TextField input)
    {
        super();
        controller = control;
        model = mod;
        commandInputBox = input;
        commandInputBox.addActionListener(this);
    }

    public void paint(Graphics g)
    {
        g.setFont(font);

        // Clear the whole board
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        float horiSpacing = (getWidth()-margin*2)/model.getNumberOfColumns();
        float vertSpacing = (getHeight()-margin*2)/model.getNumberOfRows();

        // Draw horizontal lines
        g.setColor(Color.BLACK);
        for(int i=0; i<model.getNumberOfRows()-1 ;i++) {
            g.drawLine((int)margin, (int)(margin+vertSpacing*(i+1)), (int)(getWidth() - margin), (int)(margin+vertSpacing*(i+1)));
        }
        // Draw vertical lines
        for(int i=0; i<model.getNumberOfColumns()-1 ;i++) {
            g.drawLine((int)(margin+horiSpacing*(i+1)), (int)margin, (int)(margin+horiSpacing*(i+1)), (int)(getHeight()-margin));
        }

        // Draw the row labels
        g.setColor(Color.LIGHT_GRAY);
        for(int i=0; i<model.getNumberOfRows() ;i++) {
            g.drawString(""+(char)('a'+i),(int)margin/2, (int)(margin-2+(fontSize/2.0f)+vertSpacing*(i+0.5)));
        }

        // Draw the column labels
        g.setColor(Color.LIGHT_GRAY);
        for(int i=0; i<model.getNumberOfColumns() ;i++) {
            g.drawString(""+(char)('1'+i),(int)(margin+2-(fontSize/2.0f)+horiSpacing*(i+0.5)), (int)margin/2);
        }

        // Draw the board state
        g.setColor(Color.BLACK);
        for(int colNumber=0; colNumber<model.getNumberOfColumns() ;colNumber++) {
            for(int rowNumber=0; rowNumber<model.getNumberOfRows() ;rowNumber++) {
                int xpos = (int)(((float)margin) + 2 - (fontSize/2) + (horiSpacing * (colNumber+0.5f)));
                int ypos = (int)(((float)margin) + (fontSize/2) + (vertSpacing * (rowNumber+0.5f)));
                OXOPlayer cellOwner = model.getCellOwner(rowNumber,colNumber);
                if(cellOwner != null) g.drawString(""+cellOwner.getPlayingLetter(), xpos, ypos);
            }
        }
        if(model.getWinner() != null) message = "Player " + model.getWinner().getPlayingLetter() + " is the winner !";
        else if(model.isGameDrawn()) message = "Stalemate - game is a draw !";
        else if (model.getCurrentPlayer() != null) message = "Player " + model.getCurrentPlayer().getPlayingLetter() + "'s turn";

        // Draw the message near the bottom of the screen
        g.setColor(Color.BLACK);
        g.drawString(message, 7, getHeight()-10);
    }

    public void actionPerformed(ActionEvent event)
    {
        try {
            String command = commandInputBox.getText();
            commandInputBox.setText("");
            controller.handleIncomingCommand(command);
            repaint();
        } catch(OXOMoveException exception) {
            System.out.println("Game move exception: " + exception);
        }
    }

}
