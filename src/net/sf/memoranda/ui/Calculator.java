package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The frame that houses the calculator panel.
 */
class CalculatorFrame extends JFrame
{
   public CalculatorFrame()
   {
      setTitle("Calculator");
      CalculatorPanel panel = new CalculatorPanel();
      add(panel);
      pack();
   }
}

/**
 * A panel with all the controls necessary to display 
 * the miniature calculator.
 */
class CalculatorPanel extends JPanel
{

   private JButton display;
   private JPanel panel;
   private double result;
   private String lastCommand;
   private boolean start;
   
   /**
    * Builds the panel that will display the calculator face.
    */
   public CalculatorPanel()
   {
      setLayout(new BorderLayout());

      result = 0;
      lastCommand = "=";
      start = true;

      display = new JButton("0");
      display.setEnabled(false);
      add(display, BorderLayout.NORTH);

      ActionListener insert = new InsertAction();
      ActionListener command = new CommandAction();

      panel = new JPanel();
      panel.setLayout(new GridLayout(4, 4));
      panel.setBackground(new Color(251, 197, 63));

      addButton("7", insert);
      addButton("8", insert);
      addButton("9", insert);
      addButton("/", command);

      addButton("4", insert);
      addButton("5", insert);
      addButton("6", insert);
      addButton("*", command);

      addButton("1", insert);
      addButton("2", insert);
      addButton("3", insert);
      addButton("-", command);

      addButton("0", insert);
      addButton(".", insert);
      addButton("=", command);
      addButton("+", command);

      add(panel, BorderLayout.CENTER);
   }

   /**
    * Adds buttons to the frame and classifies what type of button 
    * they are.
    * @param label - What the text on the button will read
    * @param listener - The listener that will be called when the 
    * button is pressed.
    */
   private void addButton(String label, ActionListener listener)
   {
      JButton button = new JButton(label);
      button.setBackground(new Color(251, 197, 63));
      button.addActionListener(listener);
      panel.add(button);
   }

   /**
    * Concatenates the selected number onto the end of the String
    * that represents the current value.
    */
   private class InsertAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         String input = event.getActionCommand();
         if (start)
         {
            display.setText("");
            start = false;
         }
         display.setText(display.getText() + input);
      }
   }

   /**
    * Check for a negative number, store the command to
    * be performed in the lastCommand variable and then
    * call the method to perform the calculation.
    */
   private class CommandAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         String command = event.getActionCommand();

         if (start)
         {
            if (command.equals("-"))
            {
               display.setText(command);
               start = false;
            }
            else lastCommand = command;
         }
         else
         {
            calculate(Double.parseDouble(display.getText()));
            lastCommand = command;
            start = true;
         }
      }
   }

   /**
    * Perform the required calculation.
    * @param newValue - The double that will be used along with the existing
    * result variable to perform the calculation for the selected button.
    */
   public void calculate(double newValue)
   {
      if (lastCommand.equals("+")) result += newValue;
      else if (lastCommand.equals("-")) result -= newValue;
      else if (lastCommand.equals("*")) result *= newValue;
      else if (lastCommand.equals("/")) result /= newValue;
      else if (lastCommand.equals("=")) result = newValue;
      display.setText("" + result);
   }

}