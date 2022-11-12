package tarea3;

public abstract class Moneda {

    public Moneda getSerie() {
        return this;
    }

    public abstract int getValor();
}

class M500 extends Moneda {

    @Override
    public int getValor() {
        return 500;
    }
}

class M100 extends Moneda {

    @Override
    public int getValor() {
        return 100;
    }
}

class M1000 extends Moneda {

    @Override
    public int getValor() {
        return 1000;
    }
}