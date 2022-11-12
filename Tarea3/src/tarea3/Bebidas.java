package tarea3;

public abstract class Bebidas {
    public int numSerie;
    public int numDisponible;

    public Bebidas(int numDisponible) {
        this.numDisponible = numDisponible;
    }
    public abstract String beber();
}
    
class CocaCola extends Bebidas{  

    public CocaCola(int numDisponible) {
        super(numDisponible);
    }
    @Override
    public String beber(){
        return "Coca-Cola";
    }
    }
class Fanta extends Bebidas{  

    public Fanta(int numDisponible) {
        super(numDisponible);
    }
    @Override
    public String beber(){
        return "Fanta";
    }
    }
class Sprite extends Bebidas{

    public Sprite(int numDisponible) {
        super(numDisponible);
    }
    @Override
    public String beber(){
        return "Sprite";
    }
    }