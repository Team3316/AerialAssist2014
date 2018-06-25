package org.usfirst.frc.team3316.config;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.usfirst.frc.team3316.config.util.Files;
import org.usfirst.frc.team3316.config.util.Network;

public class Main {
  public static void main(String[] args) {
    final JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    frame.setBounds(0, 0, 200, 200);

    JButton getlogsButton = new JButton("Transfer Logs");
    JButton uploadConfigButton = new JButton("Transfer Config");

    frame.add(panel);
    panel.add(getlogsButton);
    panel.add(uploadConfigButton);
    frame.setVisible(true);

    uploadConfigButton.addActionListener(arg0 -> {
      Files.writeConfig(true);
      Files.writeConfig(false);
      Network.transferConfig();
    });

    getlogsButton.addActionListener(arg0 -> Network.fetchLogs());
  }


}