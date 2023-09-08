package ejercicio02;
import java.util.Scanner;
public class fecha {
	private int dia;
    private int mes;
    private int anio;

    //constructor_predeterminado
    public fecha() {
        this.dia = 1;
        this.mes = 1;
        this.anio = 1900;
    }

    //Constructor_parametrizado
    public fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        valida();
    }
    
    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese el dia (1 a 31): ");
        this.dia = sc.nextInt();
        System.out.print("ingrese el mes (1 a 12): ");
        this.mes = sc.nextInt();
        System.out.print("ingrese el anio (1900 a 2050): ");
        this.anio = sc.nextInt();
        valida();
    }

    public boolean bisiesto() {
        return (this.anio % 4 == 0 && this.anio % 100 != 0) || this.anio % 400 == 0;
    }

    public int dias_mes(int mes) {
    	int[] meses = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(mes == 2 && bisiesto()) {
            return 29;
        }
        return meses[mes];
    }

    //valida_para comprobar_mes/dia_/_año
    private void valida() {
        if (this.anio < 1900 || this.anio > 2050) {
            this.anio = 1900;
        }
        if (this.mes < 1 || this.mes > 12) {
            this.mes = 1;
        }
        if (this.dia < 1 || this.dia > dias_mes(this.mes)) {
            this.dia = 1;
        }
    }

    //metodos_get/set
    public int getdia() {
        return dia;
    }
    public void setdia(int dia) {
        this.dia = dia;
        valida();
    }
    public int getmes() {
        return mes;
    }
    public void setmes(int mes) {
        this.mes = mes;
        valida();
    }
    public int getanio() {
        return anio;
    }
    public void setanio(int anio) {
        this.anio = anio;
        valida();
    }

    // metodo_corta()
    public String corta() {
        return String.format("dia/mes/anio", this.dia, this.mes, this.anio);
    }

  //dias_transcurridos
    public int diastranscurridos() {
        int dias = 0;
        for (int i = 1900; i < this.anio; i++) {
            dias += bisiesto() ? 366 : 365;
        }
        for (int i = 1; i < this.mes; i++) {
            dias += dias_mes(i);
        }
        dias += this.dia - 1;
        return dias;
    }

    public int diasemana() {
        return diastranscurridos() % 7;
    }
    
    //mostrar_la fecha_en formato_largo
    public String larga() {
        String[] diasSemana = {"domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"};
        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        return String.format("%s %d de %s de %d", diasSemana[diasemana()], this.dia, meses[this.mes - 1], this.anio);
    }

  //para_actualizar la_fecha
    public void fechatras(long dias) {
        int diasTranscurridos = diastranscurridos() + (int) dias;
        int anio = 1900;
        while (diasTranscurridos > (bisiesto() ? 366 : 365)) {
            diasTranscurridos -= bisiesto() ? 366 : 365;
            anio++;
        }
        this.anio = anio;
        int mes = 1;
        while (diasTranscurridos > dias_mes(mes)) {
            diasTranscurridos -= dias_mes(mes);
            mes++;
        }
        this.mes = mes;
        this.dia = diasTranscurridos + 1;
    }

    //devuelve_el_numero de_dias entre_las_fecha
    public int dias_entre(fecha fecha) {
        int dias = 0;
        if (this.anio == fecha.getanio()) {
            if (this.mes == fecha.getmes()) {
                dias = this.dia - fecha.getdia();
            } else {
                for (int i = fecha.getmes(); i < this.mes; i++) {
                    dias += dias_mes(i);
                }
                dias += this.dia + (dias_mes(fecha.getmes()) - fecha.getdia());
            }
        } else {
            for (int i = fecha.getanio(); i < this.anio; i++) {
                dias += bisiesto() ? 366 : 365;
            }
            dias += diastranscurridos() - fecha.diastranscurridos();
        }
        return dias;
    }

  //codigo_para pasar_al dia_siguiente
    public void siguiente() {
        this.dia++;
        if (this.dia > dias_mes(this.mes)) {
            this.dia = 1;
            this.mes++;
            if (this.mes > 12) {
                this.mes = 1;
                this.anio++;
            }
        }
    }

  //pasara_al dia_anterior
    public void anterior() {
        this.dia--;
        if (this.dia < 1) {
            this.mes--;
            if (this.mes < 1) {
                this.mes = 12;
                this.anio--;
            }
            this.dia = dias_mes(this.mes);
        }
    }

  //actualiza_la_fecha
    public void fecha_futura(long dias) {
        if (dias > 0) {
            for (int i = 0; i < dias; i++) {
                siguiente();
            }
        } else {
            for (int i = 0; i > dias; i--) {
                anterior();
            }
        }
    }

    public fecha copia() {
        return new fecha(this.dia, this.mes, this.anio);
    }

  //devuelve_True si_ambas_fechas son iguales_ sino_False
    public static boolean igualQue(fecha fecha1, fecha fecha2) {
        return fecha1.getdia() == fecha2.getdia() && fecha1.getmes() == fecha2.getmes() && fecha1.getanio() == fecha2.getanio();
    }
    
  //codigo_para comparar_si fecha1_es anterior a fecha2
    public static boolean menorQue(fecha fecha1, fecha fecha2) {
    	if (fecha1.getanio() < fecha2.getanio()) {
            return true;
        } else if (fecha1.getanio() > fecha2.getanio()) {
            return false;
        } else {
            if (fecha1.getmes() < fecha2.getmes()) {
                return true;
            } else if (fecha1.getmes() > fecha2.getmes()) {
                return false;
            } else {
                if (fecha1.getdia() < fecha2.getdia()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    
    //comparar_si fecha1 es_posterior a fecha2
    public static boolean mayorQue(fecha fecha1, fecha fecha2) {
    	if (fecha1.anio > fecha2.anio) {
            return true;
        } else if (fecha1.anio == fecha2.anio && fecha1.mes > fecha2.mes) {
            return true;
        } else if (fecha1.anio == fecha2.anio && fecha1.mes == fecha2.mes && fecha1.dia > fecha2.dia) {
            return true;
        }
        return false;
    }
}
