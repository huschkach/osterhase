package GUI.Eingabe;

import GUI.PresentPanel;
import Klassen.Presents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PresentEingabe {
    JFrame frame = new JFrame("Geschenkeingabe");
    JLabel descriptionLabel = new JLabel("Beschreibung: ");
    JTextField descriptionTF = new JTextField();
    JLabel colorLabel = new JLabel("Farbe: ");
    JTextField colorTF = new JTextField();

    JPanel enterPanel = new JPanel();
    JPanel newEntryPanel = new JPanel();
    JPanel eingabePanel = new JPanel();

    ArrayList<Presents> presents = new ArrayList<>();

    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    BoxLayout entryBoxLayout = new BoxLayout(enterPanel, BoxLayout.Y_AXIS);
    BoxLayout eingabeLayout = new BoxLayout(eingabePanel, BoxLayout.Y_AXIS);

    JScrollPane scrollPane = new JScrollPane();

    JButton execute = new JButton("Liste übertragen");
    JButton addEntry = new JButton("Eintrag hinzufügen");
    JButton abort = new JButton("Abbrechen");

    private void createFrame(){
        newEntryPanel.setLayout(gbl);
        gbl.setConstraints(newEntryPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        newEntryPanel.add(descriptionLabel, gbc);

        gbc.gridx = 1;
        descriptionTF.setPreferredSize(new Dimension(70, 20));
        newEntryPanel.add(descriptionTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        newEntryPanel.add(colorLabel, gbc);

        gbc.gridx = 1;
        colorTF.setPreferredSize(new Dimension(70, 20));
        newEntryPanel.add(colorTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        newEntryPanel.add(execute, gbc);

        gbc.gridx = 1;
        newEntryPanel.add(addEntry, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        newEntryPanel.add(abort, gbc);

        eingabePanel.setLayout(eingabeLayout);
        eingabePanel.add(newEntryPanel);

        enterPanel.setLayout(entryBoxLayout);
        //scrollPane.add(enterPanel);
        //scrollPane.setSize(400, 300);
        eingabePanel.add(enterPanel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(eingabePanel);

        frame.setSize(200, 300);
        frame.setVisible(true);
    }

    public void main(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createFrame();
                setButtonListener();
            }
        });
    }

    private void addPresent(){
        String description = this.descriptionTF.getText();
        String color = this.colorTF.getText();

        if (color.isEmpty()){
            color = null;
        }

        if (description.isEmpty()){
            System.out.println("Missing description");
        }
        else {
            Presents present = new Presents(description, color);
            presents.add(present);
            System.out.println(presents);
            addEntries();
        }
    }

    private void setButtonListener(){
        ActionListener addEntryListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPresent();
            }
        };
        addEntry.addActionListener(addEntryListener);
    }

    private void addEntries(){
        for(int i = 0; i < presents.size(); i++){
            PresentPanel pPanel = new PresentPanel(presents.get(i));
            System.out.println(presents.get(i));

            enterPanel.add(pPanel);
            enterPanel.revalidate();
            enterPanel.repaint();

        }
    }

}
