package tarea3;

public class Maquina {

    private CocaCola coca;
    private Fanta fanta;
    private Sprite sprite;
    public int vuelto;
    public int dineroIngresado;
    public int precio;
    public int disponibles;

    public Maquina(CocaCola coca, Fanta fanta, Sprite sprite, int precio, int disponibles) {
        this.coca = coca;
        this.fanta = fanta;
        this.sprite = sprite;
        this.precio = precio;
        this.disponibles=disponibles;
    }

    public Bebidas Comprar(Moneda m,int eleccion) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException {
        if(m==null){
            dineroIngresado=0;
        }else{
        dineroIngresado=m.getValor();
        }
        if (dineroIngresado == 0) {
            //excepcion
            throw new PagoIncorrectoException("No se ingreso el dinero.");
            }
        Bebidas bebida;
        switch (eleccion) {
            case 1:
                bebida = new CocaCola(disponibles);
                vuelto= this.dineroIngresado-precio;
                break;
            case 2:
                bebida = new Fanta(disponibles);
                vuelto= dineroIngresado-precio;
                break;
            case 3:
                bebida= new Sprite(disponibles);
                vuelto= dineroIngresado-precio;
                break;
            default:
                bebida=null;
        }
            if (precio>dineroIngresado&&dineroIngresado>0){
                //excepcion
                vuelto = dineroIngresado;
                throw new PagoInsuficienteException("Pago insuficiente.");
            }
            if (disponibles == 0) {
                //excepcion
                vuelto = dineroIngresado;
                throw new NoHayBebidaException("No quedan bebidas.");
            }
            return bebida;
}
        public int Vuelto(){
           if(vuelto==0){
               return 0;
           }else{
               vuelto= vuelto-100;
               return 100;
           }
        }
    }