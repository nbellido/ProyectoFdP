package ValesJuanita;

import java.util.Scanner;

public class ProyectoJuanita {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String Regiones[] = {"Amazonas", "Ancash", "Apurímac", "Arequipa", "Ayacucho", "Cajamarca", "Callao","Cuzco",
                "Huancavelica", "Huánuco", "Ica", "Junín", "La Libertad", "Lambayeque", "Lima Metropolitana", "Lima Provincias",
                "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martín", "Tacna", "Tumbes", "Ucayali"};
        int precio[] = {25,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20};

        int kilos[]= {5,6,7,8,9,10,11,12};
        int stock[]= {10,500,200,10000,9000,3000,3000,3000};
        //int pavo[]={7,8,9,10};
        //int cerdo[]={3,4,5,6};

        int PrecioValepavo = 11;
        int PrecioValepack = 12;

        double IGV = 0.18;
        double descuento8 = 0.025;
        double descuento9 = 0.02;

        char delivery = 'S';
        //char canje ='N';

        String vale1 ="";



        while(true){
            int eleccion = OPCIONES();

            switch(eleccion){
                case 1:
                    System.out.println("####TIPO DE PRODUCTO####");
                    System.out.println("1.VALE PAVO");
                    System.out.println("2.VALE PACK");
                    System.out.println("Seleccione una opcion:");
                    int  producto = scan.nextInt();

                    System.out.println("Introduzca los kilos en el rango de 5k a 12k :");
                    int Kilos = scan.nextInt();

                    System.out.println("Introduzca la cantidad de vales a compar:");
                    int vales = scan.nextInt();

                    for(int j=0; j<kilos.length; j++){
                        while(Kilos == kilos[j] && vales> stock[j]){
                            System.out.println("(*)Solo quedan "+ stock[j] +" de pavos de "+kilos[j]+" kilos.");
                            System.out.println("Introduzca la cantidad de vales a compar:");
                            vales = scan.nextInt();
                        }


                    }



                    System.out.println("Delivery (S/N) ?");
                    System.out.println("Seleccione S o N:");
                    delivery = scan.next().charAt(0);

                    if(delivery == 'S'){
                        System.out.println("Introduzca el destino:");
                        String region = scan.next();
                        System.out.println("#### RESUMEN DE LA COMPRA ####");
                        if(producto == 1){
                            vale1 = "VALE PAVO";
                        }else{
                            vale1 = "VALE PACk";
                        }
                        System.out.println("(*) PRODUCTO      : "+vale1);
                        System.out.println("(*) CANTIDAD      : "+vales);
                        System.out.println("(*) KILO POR VALE : "+Kilos+"k.");
                        System.out.println("(*) DELIVERY      : "+delivery);
                        System.out.println("(*) DESTINO       : "+region);
                        int precioEntrega = Deliver(Regiones,precio,region);
                        double totalDelivery = Total(producto,vales,Kilos, PrecioValepavo, PrecioValepack,IGV, descuento8, descuento9) + precioEntrega;
                        System.out.println("(*) TOTAL A PAGAR : S/"+ totalDelivery);
                        System.out.println("****el total incluye IGV****");
                        System.out.println("");

                    }else if(delivery == 'N'){
                        System.out.println("#### RESUMEN DE LA COMPRA ####");
                        if(producto == 1){
                            vale1 = "VALE PAVO";
                        }else{
                            vale1 = "VALE PACK";
                        }
                        System.out.println("(*) PRODUCTO      : "+vale1);
                        System.out.println("(*) CANTIDAD      : "+vales);
                        System.out.println("(*) KILO POR VALE : "+Kilos+"k.");
                        System.out.println("(*) DELIVERY      : "+delivery);
                        System.out.println("(*) TOTAL A PAGAR : S/"+Total(producto,vales,Kilos, PrecioValepavo, PrecioValepack,IGV, descuento8, descuento9));
                        System.out.println("****el total incluye IGV****");
                        System.out.println("");
                    }

                    break;

                case 2:
                    Inventario(kilos,stock);
                    System.out.println("");

                    break;

                case 3:
                    return;

                default:
                    System.out.println("Porfavor introduzca un numero de las opciones");


            }

        }
    }

    public static int OPCIONES(){
        System.out.println ("------------- VENTA DE VALES ------------");
        System.out.println ("1.COMPRAR");
        System.out.println ("2.VER STOCK");
        System.out.println ("3.Exit");
        System.out.println ("Seleccione las opciones que desea usar:");
        Scanner ran = new Scanner(System.in);
        int number = ran.nextInt();
        return number;
    }

    public static double Total(int producto, int vales,int Kilos,int precio1, int precio2, double IGV, double desc8, double desc9){
        double total=0;
        double precioSinIGV=0;
        double precionConDesc=0;

        //SIN DESCUENTO
        if(producto==1 && Kilos!=8 && Kilos!=9){
            precioSinIGV = (vales * Kilos)*precio1;
            total = precioSinIGV + (precioSinIGV*IGV);

        }else if (producto==2 && Kilos!=8 && Kilos!=9){
            precioSinIGV = (vales * Kilos)*precio2;
            total = precioSinIGV + (precioSinIGV*IGV);

            //CON DESCUENTO
        }else if (producto==1 && Kilos==8){
            precionConDesc = precio1 - (precio1*desc8);
            precioSinIGV = (vales * Kilos)*precionConDesc;
            total = precioSinIGV + (precioSinIGV*IGV);

        } else if (producto==2 && Kilos==8){
            precionConDesc = precio2 - (precio1*desc8);
            precioSinIGV = (vales * Kilos)*precionConDesc;
            total = precioSinIGV + (precioSinIGV*IGV);

        }else if (producto==1 && Kilos==9){
            precionConDesc = precio1 - (precio1*desc9);
            precioSinIGV = (vales * Kilos)*precionConDesc;
            total = precioSinIGV + (precioSinIGV*IGV);

        }else if (producto==2 && Kilos==9){
            precionConDesc = precio2 - (precio1*desc9);
            precioSinIGV = (vales * Kilos)*precionConDesc;
            total = precioSinIGV + (precioSinIGV*IGV);
        }


        return total;

    }

    public static int Deliver(String Regiones[],int precio[],String region){
        int re = 0;
        for (int i=0; i<Regiones.length; i++){
            if(Regiones[i].equals(region)){
                re = precio[i];
            }

        }
        return re;
    }

    public static void Inventario(int kilos[], int stock[]){
        int cantidad = 0;
        System.out.println("###### lista de Productos ######");
        System.out.println("");
        System.out.println("    Kilos    Stock");
        System.out.println("    -----    -----");

        for(int i=0; i<kilos.length; i++ ){
            System.out.println("      "+kilos[i]+"       "+stock[i]);
            cantidad = cantidad + stock[i];

        }
        System.out.println("");
        System.out.println("--(*)"+cantidad + " pavos en total--");



    }

    public static void restaStock(){

    }








}