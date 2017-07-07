package com.canh.healthcare;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JInternalFrame;

/*
 * This JCheckBoxMenuItem descendant is used to track the child frame that
 * corresponds to a give menu.
 */
class ChildMenuItem extends JCheckBoxMenuItem {
  private JInternalFrame frame;

  public ChildMenuItem(JInternalFrame frame) {
    super(frame.getTitle());
    this.frame = frame;
  }

  public JInternalFrame getFrame() {
    return frame;
  }
}
