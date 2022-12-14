package main.ui;

import javax.swing.*;
import java.awt.*;

public interface IUI {
    public JPanel getPanel();
    public void updatePane(IUI ui);
}