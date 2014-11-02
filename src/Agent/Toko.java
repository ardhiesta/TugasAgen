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
public class Toko extends Agent {

    private TokoGUI tkogui;
    static boolean status_permintaan;//This will be true after donating blood, to notify messages

    static String nama_barang;
    static int jml;

    ACLMessage tokomsg;

    protected void setup() {

        tkogui = new TokoGUI();
        addBehaviour(new TokoStatus());
        tkogui.setVisible(true);

    }

    public class TokoStatus extends CyclicBehaviour {

        @Override
        public void action() {
            tokomsg = receive();
            if (tokomsg != null) {
                TokoGUI.lblPesan.setForeground(Color.BLUE);
                TokoGUI.lblPesan.setText(tokomsg.getContent());
                // System.out.println(msgtohos.getContent());
                tokomsg = null;
            }

            if (Toko.status_permintaan == true) {//Sending of the message saying blood was donated               
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(new AID("Grosir", AID.ISLOCALNAME));
                msg.setLanguage("English");
                msg.setOntology("send message-ontology");
                msg.setContent("Permintaan " + nama_barang + " sebanyak " + jml);
                send(msg);
            }

        }

    }

}
