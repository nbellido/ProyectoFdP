package ValesJuanita;

import java.util.Scanner;

public class proyectoVentaVales_v2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String Regiones[] = {"Amazonas", "Ancash", "Apurímac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cuzco",
                "Huancavelica", "Huánuco", "Ica", "Junín", "La Libertad", "Lambayeque", "Lima Metropolitana", "Lima Provincias",
                "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martín", "Tacna", "Tumbes", "Ucayali"};
        int precio[] = {25, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20};

        int kilos[] = {5, 6, 7, 8, 9, 10, 11, 12};
        int stock[] = {10, 500, 200, 10000, 9000, 3000, 3000, 3000};
        String clientes[] = {"San Lorenzo", "Menorca", "Viettel", "Patatas", "Schubert", "San Toribiano", "College", "Bertello", "Deutch", "Platanitos"};
        int antiguedad[] = {10, 21, 11, 21, 12, 12, 9, 8, 9, 10};

        int PrecioValepavo = 11;
        int PrecioValepack = 12;
        int producto=0;
        int producto2=0;
        int vales=0;
        int vales2=0;
        int Kilos=0;
        int Kilos2=0;
        String region="-";
        String cliente="-";

        double IGV = 0.18;
        double descuento8 = 0.025;
        double descuento9 = 0.02;
        double descuentoantiguedad = 0.04;
        double preciodelivery=0;


        String vale1 = "-";
        String vale3 = "-";

        while (true) {
            int eleccion = OPCIONES();

            switch (eleccion) {
                case 1:
                    System.out.println("####TIPO DE PRODUCTO####");
                    System.out.println("1.VALE PAVO");
                    System.out.println("2.VALE PACK");
                    System.out.println("Seleccione una opcion:");
                    producto = scan.nextInt();

                    System.out.println("Introduzca los kilos en el rango de 5k a 7k y de 10k 12k :");
                    Kilos = scan.nextInt();

                    while(Kilos == 8 || Kilos==9){
                        System.out.println("(*)Solo puedes elegir en el rango de 5 a 7 kilos y de 10 12 kilos.");
                        System.out.println("Introduzca los Kilos deacuerdo al rango:");
                        Kilos = scan.nextInt();
                    }

                    System.out.println("Introduzca la cantidad de vales :");
                    vales = scan.nextInt();
                    for (int j = 0; j < kilos.length; j++) {
                        while (Kilos == kilos[j] && vales > stock[j]) {
                            System.out.println("(*)Solo quedan " + stock[j] + " de pavos de " + kilos[j] + " kilos.");
                            System.out.println("Introduzca la cantidad de vales a compar:");
                            vales = scan.nextInt();
                        }
                    }
                    double precio3= preciocliente1(producto,PrecioValepavo,PrecioValepack,cliente,clientes,descuentoantiguedad,antiguedad);
                    System.out.println(" ");

                    System.out.println("(*) El importe es de S/"+TOTAL1(producto,vales,Kilos,PrecioValepavo,PrecioValepack,IGV,precio3,cliente,clientes));
                    System.out.println(" ");
                    System.out.println("!!! SE GUARDÓ EXITOSAMENTE !!!");
                    System.out.println(" ");


                    break;

                case 2:
                    System.out.println("####TIPO DE PRODUCTO####");
                    System.out.println("1.VALE PAVO");
                    System.out.println("2.VALE PACK");
                    System.out.println("Seleccione una opcion:");
                    producto2 = scan.nextInt();

                    System.out.println("Introduzca los kilos en el rango de 8 a 9 kilos :");
                    Kilos2 = scan.nextInt();

                    while(Kilos2 != 8 && Kilos2!=9){
                        System.out.println("(*)Solo puedes elegir en el rango de 8 a 9 kilos");
                        System.out.println("Introduzca los Kilos deacuerdo al rango:");
                        Kilos2 = scan.nextInt();
                    }

                    System.out.println("Introduzca la cantidad de vales :");
                    vales2 = scan.nextInt();
                    for (int j = 0; j < kilos.length; j++) {
                        while (Kilos2 == kilos[j] && vales2 > stock[j]) {
                            System.out.println("(*)Solo quedan " + stock[j] + " de pavos de " + kilos[j] + " kilos.");
                            System.out.println("Introduzca la cantidad de vales a compar:");
                            vales2 = scan.nextInt();
                        }
                    }

                    double precio4= preciocliente2(producto2,PrecioValepavo,PrecioValepack,cliente,clientes,descuentoantiguedad,antiguedad);

                    System.out.println(" ");
                    System.out.println("(*) El importe a pagar es S/" +TOTAL2(producto2,vales2,Kilos2,PrecioValepavo,PrecioValepack,IGV,precio4,cliente,clientes,descuento8,descuento9));

                    System.out.println(" ");
                    System.out.println("!!! SE GUARDÓ EXITOSAMENTE !!!");
                    System.out.println(" ");
                    break;

                case 3:
                    System.out.println("Introduzca el destino:");
                    region = scan.next();

                    System.out.println("(*) El importe a pagar es S/"+ Preciodelivery(Regiones,precio,region));

                    System.out.println(" ");
                    System.out.println("!!! SE GUARDÓ EXITOSAMENTE !!!");
                    System.out.println(" ");

                    break;

                case 4:
                    System.out.println("Nombre del cliente:");
                    cliente = scan.next();

                    System.out.println(" ");
                    System.out.println("!!! SE GUARDÓ EXITOSAMENTE !!!");
                    System.out.println(" ");
                    break;

                case 5:
                    System.out.println("#### INVENTARIO ####");
                    System.out.println("1.Buscar por Kilaje");
                    System.out.println("2.Inventario total");
                    System.out.println("Seleccione una opcion:");
                    int inv = scan.nextInt();

                    while(inv != 1 && inv !=2){
                        System.out.println("!!! Opcion incorrecta !!!");
                        System.out.println("Seleccione una opcion válida:");
                        inv = scan.nextInt();
                    }

                    if(inv == 1){
                        System.out.println("Introduzca los kilos: ");
                        int Kilos3 = scan.nextInt();

                        Kilaje(kilos,stock,Kilos3);

                    }else{
                        Inventario(kilos,stock);
                    }

                    break;

                case 6:
                    if (producto == 1) {
                        vale1 = "VALE PAVO";
                    } else {
                        vale1 = "VALE PACk";
                    }
                    if (producto2 == 1) {
                        vale3 = "VALE PAVO";
                    } else {
                        vale3 = "VALE PACk";
                    }


                    preciodelivery=Preciodelivery(Regiones,precio,region);



                    precio3= preciocliente1(producto,PrecioValepavo,PrecioValepack,cliente,clientes,descuentoantiguedad,antiguedad);
                    precio4= preciocliente2(producto2,PrecioValepavo,PrecioValepack,cliente,clientes,descuentoantiguedad,antiguedad);



                    double TOTAL1=TOTAL1(producto,vales,Kilos,PrecioValepavo,PrecioValepack,IGV,precio3,cliente,clientes);
                    double TOTAL2=TOTAL2(producto2,vales2,Kilos2,PrecioValepavo,PrecioValepack,IGV,precio4,cliente,clientes,descuento8,descuento9);
                    double TOTAL3=TOTAL1+TOTAL2+preciodelivery;





                    System.out.println("(*) PRODUCTO            : " + vale1 +" - "+ vale3);
                    System.out.println("(*) CANTIDAD            :     " + vales +"     -   "+ vales2);
                    System.out.println("(*) KILO POR VALE       :     " + Kilos+"K." +"   -   "+ Kilos2+"K.");
                    System.out.println("(*) DESTINO             : " + region);
                    System.out.println("(*) CLIENTE             : " + cliente);
                    System.out.printf("(*) TOTAL VALES SIN dto.: S/%.2f \n" ,TOTAL1);
                    System.out.printf("(*) TOTAL VALES CON dto.: S/%.2f \n" ,TOTAL2);
                    System.out.printf("(*) TOTAL A PAGAR       : S/%.2f \n" ,TOTAL3);
                    System.out.println("****el total incluye IGV****");
                    System.out.println("");


                    break;

                case 7:
                    return;

                default:
                    System.out.println("!!!!! Porfavor introduzca un numero válido !!!!!");
                    System.out.println(" ");
            }
        }
    }

    public static int OPCIONES() {

        System.out.println("------------- VENTA DE VALES ------------");
        System.out.println("1.Añadir vales sin descuento");
        System.out.println("2.Añadir vales con descuento");
        System.out.println("3.Añadir Delivery");
        System.out.println("4.Añadir Descuento por antiguedad");
        System.out.println("5.Stock");
        System.out.println("6.Realizar compra");
        System.out.println("7.Salir");
        System.out.println("### Seleccione una opcion:");
        Scanner ran = new Scanner(System.in);
        int number = ran.nextInt();
        return number;
    }

    public static double TOTAL1( int producto,int vales, int Kilos, int precio1, int precio2, double IGV, double precio3,String cliente, String clientes[]){
        double re =0;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].equals(cliente) && producto ==1) {
                double SinIGV=(vales*Kilos)*precio3;
                re=SinIGV+(SinIGV*IGV);
            }else if(clientes[i].equals(cliente) && producto ==2){
                double SinIGV=(vales*Kilos)*precio3;
                re=SinIGV+(SinIGV*IGV);
            }else if(cliente.equals("-") && producto ==1){
                double SinIGV=(vales*Kilos)*precio1;
                re=SinIGV+(SinIGV*IGV);
            }else if(cliente.equals("-") && producto ==2){
                double SinIGV=(vales*Kilos)*precio2;
                re=SinIGV+(SinIGV*IGV);
            }
        }


        return re;
    }

    public static double TOTAL2(int producto,int vales, int Kilos, int precio1, int precio2, double IGV, double precio4,String cliente, String clientes[],double descuento8,
                                double descuento9){
        double re =0;
        double nuevodesc1=precio1-(precio1*descuento8);
        double nuevodesc2=precio2-(precio2*descuento9);
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].equals(cliente) && producto ==1) {
                double SinIGV=(vales*Kilos)*(nuevodesc1-precio4);
                re=SinIGV+(SinIGV*IGV);
            }else if(clientes[i].equals(cliente) && producto ==2){
                double SinIGV=(vales*Kilos)*(nuevodesc2-precio4);
                re=SinIGV+(SinIGV*IGV);
            }else if(cliente.equals("-") && producto ==1){
                double SinIGV=(vales*Kilos)*nuevodesc1;
                re=SinIGV+(SinIGV*IGV);
            }else if(cliente.equals("-") && producto ==2){
                double SinIGV=(vales*Kilos)*nuevodesc2;
                re=SinIGV+(SinIGV*IGV);
            }
        }


        return re;
    }

    public static double preciocliente1(int producto,int precio1, int precio2,
                                        String cliente, String clientes[], double descuentoantiguedad, int antiguedad[]){

        double re =1;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].equals(cliente) && antiguedad[i] >= 10) {
                if (producto == 1) {
                    re = precio1 - (precio1 * descuentoantiguedad);

                } else {
                    re = precio2 - (precio2 * descuentoantiguedad);

                }
            }

        }return  re;
    }

    public static double preciocliente2(int producto,int precio1, int precio2,
                                        String cliente, String clientes[], double descuentoantiguedad, int antiguedad[]){

        double re =1;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].equals(cliente) && antiguedad[i] >= 10) {
                if (producto == 1) {
                    re = precio1 - (precio1 * descuentoantiguedad);

                } else {
                    re = precio2 - (precio2 * descuentoantiguedad);

                }
            }

        }return  re;
    }

    public static int Preciodelivery(String Regiones[], int precio[], String region) {
        int re = 0;
        for (int i = 0; i < Regiones.length; i++) {
            if (Regiones[i].equals(region)) {
                re = precio[i];
            }

        }
        return re;
    }







    public static void Kilaje(int kilos[],int stock[], int Kilos){

        for (int i = 0; i < kilos.length; i++) {
            if (Kilos == kilos[i]) {

                System.out.println("(*) hay solo "+ stock[i]+" unidades de " + kilos[i]+ " kilos.");
                System.out.println(" ");
            }
        }
    }

    public static void Inventario(int kilos[], int stock[]){
        int cantidad = 0;
        System.out.println(" ");
        System.out.println("###### lista de Productos ######");
        System.out.println("");
        System.out.println("    Kilos    Stock");
        System.out.println("    -----    -----");

        for (int i = 0; i < kilos.length; i++) {
            System.out.println("      " + kilos[i] + "       " + stock[i]);
            cantidad = cantidad + stock[i];

        }
        System.out.println("");
        System.out.println("--(*)" + cantidad + " pavos en total--");
        System.out.println(" ");
    }
}