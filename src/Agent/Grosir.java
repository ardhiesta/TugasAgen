/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.awt.Color;
import javax.swing.JOptionPane;


/**
 *
 * @author Dilukshan Mahendra
 */
public class Grosir extends Agent {

    private GrosirGUI grogui;
    static boolean status_permintaan;//This will be true after donating blood, to notify messages
    static String nama_barang;
    static int jml;
    ACLMessage msg;

    protected void setup() {

        grogui = new GrosirGUI();
        addBehaviour(new CampStatus());
        grogui.setVisible(true);
    }

    public class CampStatus extends CyclicBehaviour {

        @Override
        public void action() {
            //Messages to be received from Central Blood Bank
            msg = receive();
            if (msg != null) {
                GrosirGUI.lblGrosirStatus.setForeground(Color.BLUE);
                GrosirGUI.lblGrosirStatus.setText(msg.getContent());
                msg = null;         
            }
            if (Grosir.status_permintaan == true) {//Sending of the message saying blood was donated
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(new AID("Toko", AID.ISLOCALNAME));
                msg.setLanguage("English");
                msg.setOntology("send message-ontology");
                msg.setContent("Permintaan Telah Dikirim");
                send(msg);
                //  System.out.println("Sent");  
                Grosir.status_permintaan =false;
            }

        }

    }

}
