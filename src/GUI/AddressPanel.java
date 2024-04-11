package GUI;

import GUI.Eingabe.Adresseingabe;
import Klassen.Address;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressPanel extends Panel {
    JPanel panel = new JPanel();
    JLabel streetLabel = new JLabel();
    JLabel hnrLabel = new JLabel();
    JLabel plzLabel = new JLabel();
    JLabel cityLabel = new JLabel();
    JLabel countryLabel = new JLabel();

    Address address;

    JButton updateAddress = new JButton("Ändern");

    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.X_AXIS);

    public AddressPanel(){}

    public AddressPanel(Address address){
        this.address = address;

        this.streetLabel.setText(address.getStreet());
        this.hnrLabel.setText(address.getHnr());
        this.plzLabel.setText(address.getPlz());
        this.cityLabel.setText(address.getCity());
        this.countryLabel.setText(address.getCountry());

        panel.add(this.streetLabel);
        panel.add(this.hnrLabel);
        panel.add(this.plzLabel);
        panel.add(this.cityLabel);
        panel.add(this.countryLabel);
        panel.add(this.updateAddress);

        setButtonListener();

        this.add(panel);
    }

    private void setButtonListener(){
        ActionListener updateListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Adresseingabe adresseingabe = new Adresseingabe(address);
                adresseingabe.main();
            }
        };
        updateAddress.addActionListener(updateListener);
    }

}
