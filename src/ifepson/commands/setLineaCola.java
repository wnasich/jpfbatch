package ifepson.commands;

import ifepson.ifCommand;
import ifepson.doc.Parametro;

/**
 *
 * @author wnasich
 */
public class setLineaCola extends ifCommand {

    public String getLineaCola() {
        return params.get(Parametro.ELC__LINEA_COLA);
    }

    public setLineaCola(String lineaCola) {
        this.params.put(Parametro.ELC__LINEA_COLA, lineaCola);
    }

    public int getNroLinea() {
        return Integer.parseInt(this.params.get(Parametro.ELC__NRO_LINEA));
    }

    public void setNroLinea(int nroLinea) {
        this.params.put(Parametro.ELC__NRO_LINEA, this.formatNumber(nroLinea, "000"));
    }
    
    public setLineaCola() {
        this.commandId = 0x5A;
        this.name = "setLineaCola";
        this.nombreA = "LINEACOLA";
        this.descripcionComando = "Configura el valor de las líneas de cola que se almacenan en la memoria de trabajo del equipo.";

        this.params.put(Parametro.ELC__NRO_LINEA, "001");
        this.params.put(Parametro.ELC__LINEA_COLA, "");

    }

    @Override
    public boolean interpretaRespuesta(byte[] resp) {
        return true;
    }
}
