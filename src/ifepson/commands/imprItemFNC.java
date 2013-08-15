/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifepson.commands;

import ifepson.ifCommand;
import ifepson.doc.Parametro;
import myjob.func.general.GeneralFunc;

/**
 *
 * @author guillermot
 */
public class imprItemFNC extends ifCommand {

    public Double getMontoImpuestoInterno() {

        Double entero = Double.parseDouble(params.get(Parametro.IIFNC__MONTO_IMP_INT_FIJO).substring(0, 6));

        Double decimal = Double.parseDouble("0." + params.get(Parametro.IIFNC__MONTO_IMP_INT_FIJO).substring(7));

        return entero + decimal;
    }

    public void setMontoImpuestoInterno(Double montoImpuestoInterno) {
        String formated = this.formatNumber(montoImpuestoInterno, "0000000.00000000");
        this.params.put(Parametro.IIFNC__MONTO_IMP_INT_FIJO, formated.replace(".", ""));
    }

    public Integer getBultos() {
        return Integer.parseInt(this.params.get(Parametro.IIFNC__CANTIDAD_BULTOS));
    }

    public void setBultos(Integer bultos) {
        this.params.put(Parametro.IIFNC__CANTIDAD_BULTOS, this.formatNumber(bultos, "00000"));
    }

    public CalificadorItem getCalificadorItem() {
        return CalificadorItem.parseString(params.get(Parametro.IIFNC__CALIF_ITEM));
    }

    public void setCalificador(CalificadorItem calificadorItem) {
        params.put(Parametro.IIFNC__CALIF_ITEM, calificadorItem.getLetra());
    }

    public double getCantidad() {

        Double entero = Double.parseDouble(params.get(Parametro.IIFNC__CANT_UNIDADES).substring(0, 4));

        Double decimal = Double.parseDouble("0." + params.get(Parametro.IIFNC__CANT_UNIDADES).substring(5));

        return entero + decimal;
    }

    public void setCantidad(double cantidad) {
        String formated = this.formatNumber(cantidad, "00000.000");
        this.params.put(Parametro.IIFNC__CANT_UNIDADES, formated.replace(".", ""));
    }

    public String getDescripcionExtra1() {
        return params.get(Parametro.IIFNC__DESCRIP_EXTRA_1);
    }

    public void setDescripcionExtra1(String descripcionExtra1) {
        params.put(Parametro.IIFNC__DESCRIP_EXTRA_1, descripcionExtra1);
    }

    public String getDescripcionExtra2() {
        return params.get(Parametro.IIFNC__DESCRIP_EXTRA_2);
    }

    public void setDescripcionExtra2(String descripcionExtra2) {
        params.put(Parametro.IIFNC__DESCRIP_EXTRA_2, descripcionExtra2);
    }

    public String getDescripcionExtra3() {
        return params.get(Parametro.IIFNC__DESCRIP_EXTRA_3);
    }

    public void setDescripcionExtra3(String descripcionExtra3) {
        params.put(Parametro.IIFNC__DESCRIP_EXTRA_3, descripcionExtra3);
    }

    public String getDescripcionProducto() {
        return params.get(Parametro.IIFNC__DESCRIPCION_PROD);
    }

    public void setDescripcion(String descripcionProducto) {
        params.put(Parametro.IIFNC__DESCRIPCION_PROD, descripcionProducto);
    }

    public double getIva() {
        return Double.parseDouble(params.get(Parametro.IIFNC__TASA_IVA)) / 100;
    }

    public void setIva(double iva) {
        String formated = this.formatNumber(iva, "00.00");
        this.params.put(Parametro.IIFNC__TASA_IVA, formated.replace(".", ""));
    }

    public double getPrecioUnitario() {
        if (this.params.get(Parametro.IIFNC__PRECIO_UNITARIO).contains(".")) {
            return Double.parseDouble(this.params.get(Parametro.IIFNC__PRECIO_UNITARIO));
        }

        return Double.parseDouble(this.params.get(Parametro.IIFNC__PRECIO_UNITARIO));
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.params.put(Parametro.IIFNC__PRECIO_UNITARIO, this.formatNumber(precioUnitario, "0000000.0000"));
    }

    public Double getTasaAcresentamiento() {
        return Double.parseDouble(this.params.get(Parametro.IIFNC__TASA_ACRECENTAM)) / 100;
    }

    public void setTasaAcresentamiento(Double tasaAcresentamiento) {
        String formated = this.formatNumber(tasaAcresentamiento, "00.00");
        this.params.put(Parametro.IIFNC__TASA_ACRECENTAM, formated.replace(".", ""));
    }

    public double getTasaAjusteVariable() {
        return Double.parseDouble(this.params.get(Parametro.IIFNC__TASA_AJUSTE_VAR)) /  100000000;
    }

    public void setTasaAjusteVariable(double tasaAjusteVariable) {
        String formated = this.formatNumber(tasaAjusteVariable, "0.00000000");
        this.params.put(Parametro.IIFNC__TASA_AJUSTE_VAR, formated.replace("0.", ""));
    }

    public imprItemFNC() {
        this.commandId = 0x62;
        this.name = "ImprmirItemFactura_NotaCredito_TF_TNC";
        this.descripcionComando = "No se aceptará el comando si no hay un comprobante fiscal abierto. Se lo rechazará si no hay papel en la entrada para impresión o validación de hojas sueltas.";
        this.nombreA = "FACTITEM";

        Double val = 0d;

        this.params.put(Parametro.IIFNC__DESCRIPCION_PROD, "");

        this.params.put(Parametro.IIFNC__CANT_UNIDADES, GeneralFunc.stringFormat("{0:00000}", 0) + GeneralFunc.stringFormat("{0:000}", 0));

        this.params.put(Parametro.IIFNC__PRECIO_UNITARIO, GeneralFunc.stringFormat("{0:0000000}", 0) + "." + GeneralFunc.stringFormat("{0:0000}", 0));

        this.params.put(Parametro.IIFNC__TASA_IVA, GeneralFunc.stringFormat("{0:0000}", 2100d));

        this.params.put(Parametro.IIFNC__CALIF_ITEM, CalificadorItem.MONTO_AGREGADO_O_VENTA_SUMA.getLetra());

        this.params.put(Parametro.IIFNC__CANTIDAD_BULTOS, GeneralFunc.stringFormat("{0:00000}", 0));

        this.params.put(Parametro.IIFNC__TASA_AJUSTE_VAR, GeneralFunc.stringFormat("{0:00000000}", 0));

        this.params.put(Parametro.IIFNC__DESCRIP_EXTRA_1, "");

        this.params.put(Parametro.IIFNC__DESCRIP_EXTRA_2, "");

        this.params.put(Parametro.IIFNC__DESCRIP_EXTRA_3, "");

        this.params.put(Parametro.IIFNC__TASA_ACRECENTAM, GeneralFunc.stringFormat("{0:0000}", 0));

        this.params.put(Parametro.IIFNC__MONTO_IMP_INT_FIJO, GeneralFunc.stringFormat("{0:0000000}", 0) + GeneralFunc.stringFormat("{0:00000000}", 0));


    }

    @Override
    public boolean interpretaRespuesta(byte[] resp) {
        return true;
    }

    public static enum CalificadorItem {

        MONTO_AGREGADO_O_VENTA_SUMA("M"),
        ANULA_ITEM_RESTA("m"),
        BONIFICACION_RESTA("R"),
        ANULA_BONIFICACION("r");

        CalificadorItem(String letra) {
            this.letra = letra;
        }
        String letra = "";

        public String getLetra() {
            return letra;
        }

        public static CalificadorItem parseString(String letra) {

            switch (letra.charAt(0)) {
                case 'M':
                    return CalificadorItem.MONTO_AGREGADO_O_VENTA_SUMA;
                case 'm':
                    return CalificadorItem.ANULA_ITEM_RESTA;
                case 'R':
                    return CalificadorItem.BONIFICACION_RESTA;
                case 'r':
                    return CalificadorItem.ANULA_BONIFICACION;
            }

            return null;
        }
    }
}
