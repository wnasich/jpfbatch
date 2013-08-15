/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ifepson.commands;

import ifepson.ifCommand;

/**
 *
 * @author guillermot
 */
public class abrirCajon1 extends ifCommand {

    public abrirCajon1() {
        this.commandId = 0x7B;
        this.name = "abrirCajon1";
        this.nombreA = "ABRIRCAJON1";
        this.descripcionComando = "Abrir cajón 1 de efectivo";
    }

    @Override
    public boolean interpretaRespuesta(byte[] resp) {
        return true;
    }

}
