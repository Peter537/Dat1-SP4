package main.ui;

import javax.swing.*;

public interface IUI {

    JPanel getPanel();

    void updatePane(IUI ui);
}