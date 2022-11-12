package tarea3;

public class Comprador {
    
    private int vuelto = 0;
    private String sabBebida;

    public Comprador(Moneda m, int numBebida, Maquina exp) {
        try{
            Bebidas b = exp.Comprar(m, numBebida);
        if (b != null) {
            sabBebida = b.beber();


        } else {
            sabBebida = "nada";

            while (exp.vuelto != 0) {
                vuelto =vuelto + exp.Vuelto();
            }
        }
        }catch(NoHayBebidaException | PagoIncorrectoException | PagoInsuficienteException e){
            sabBebida=null;
            System.out.println(e.getMessage());
        }
         while (exp.Vuelto() != 0) {
                vuelto += 100;
            }
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste() {
        return sabBebida;
    }
}