package main.ui;

import main.FormulaOne;

import javax.swing.*;

public abstract class AUI implements IUI {

    public AUI() { }

    public void updatePane(IUI ui) {
        FormulaOne.getPage().setContentPane(ui.getPanel());
        FormulaOne.getPage().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FormulaOne.getPage().pack();
        FormulaOne.getPage().setVisible(true);
    }

    public abstract JPanel getPanel();
}