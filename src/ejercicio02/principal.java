package ejercicio02;

public class principal {
	public static void main(String[] args) {
        fecha fecha1 = new fecha();
        fecha fecha2 = new fecha(2, 9, 2003);

        System.out.println("fecha 1: " + fecha1.larga());
        System.out.println("fecha 2: " + fecha2.larga());

        fecha1.leer();
        System.out.println("fecha1 actualizada: " + fecha1.larga());

        System.out.println("es el anio de la Fecha1 bisiesto? " + fecha1.bisiesto());
        System.out.println("es el anio de la Fecha2 bisiesto? " + fecha2.bisiesto());

        System.out.println("dias del mes (fecha1): " + fecha1.dias_mes(fecha1.getmes()));
        System.out.println("dias del mes (fecha2): " + fecha2.dias_mes(fecha2.getmes()));

        System.out.println("dias transcurridos (fecha1): " + fecha1.diastranscurridos());
        System.out.println("dias transcurridos (fecha2): " + fecha2.diastranscurridos());

        System.out.println("dia de la semana (fecha1): " + fecha1.diasemana());
        System.out.println("dia de la semana (Fecha2): " + fecha2.diasemana());

        fecha1.fechatras(10000);
        System.out.println("fecha1 despues de 10000 dias: " + fecha1.larga());

        System.out.println("dias entre Fecha1 - fecha2: " + fecha1.dias_entre(fecha2));

        fecha1.siguiente();
        System.out.println("fecha1 al dia siguiente: " + fecha1.larga());

        fecha1.anterior();
        System.out.println("fecha1 al dia anterior: " + fecha1.larga());

        fecha1.fecha_futura(365);
        System.out.println("fecha1 despues de un anio: " + fecha1.larga());

        fecha fecha3 = fecha2.copia();
        System.out.println("copia (Fecha2): " + fecha3.larga());

        System.out.println("fecha1 es igual que fecha2 ?: " + fecha.igualQue(fecha1, fecha2));
        System.out.println("fecha1 es menor que fecha2 ?: " + fecha.menorQue(fecha1, fecha2));
        System.out.println("fecha1 es mayor que fecha2?: " + fecha.mayorQue(fecha1, fecha2));
    }
}
