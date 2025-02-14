package Piezas;
import Otros.Color;
import Tablero.Movimiento;
import Tablero.Tablero;
import java.util.Collection;

public abstract class Pieza {
    
    protected final TipoDePieza tipoDePieza;
    protected final int posiciónPieza;
    protected final Color colorPieza;
    protected final boolean esPrimerMovimiento = false;
    private final int cachedHashCode;
     
    Pieza(final TipoDePieza tipoDePieza, final int posiciónPieza, final Color colorPieza){
        this.tipoDePieza = tipoDePieza;
        this.posiciónPieza = posiciónPieza;
        this.colorPieza = colorPieza;
        this.cachedHashCode = computeHashCode();
    }
    
    public int computeHashCode(){
        int resultado = tipoDePieza.hashCode();
        resultado = 31 * resultado + colorPieza.hashCode();
        resultado = 31 * resultado + posiciónPieza;
        resultado = 31 * resultado + (esPrimerMovimiento ? 1 : 0);
        return resultado;
    }
    
    @Override
    public boolean equals(final Object otro){
        if(this == otro){
            return true;
        }
        if(!(otro instanceof Pieza)){
            return false;
        }
        final Pieza otraPieza = (Pieza) otro;
        return posiciónPieza == otraPieza.getPosiciónPieza() && tipoDePieza == otraPieza.getTipoDePieza()&&
               colorPieza == otraPieza.getColorPieza() && esPrimerMovimiento == otraPieza.esPrimerMovimiento();
    }
    
    @Override
    public int hashCode(){
        return this.cachedHashCode;
    }
    
    public TipoDePieza getTipoDePieza(){
        return this.tipoDePieza;
    }
    
    public int getPosiciónPieza(){
        return this.posiciónPieza;
    }
    
    public Color getColorPieza(){
        return this.colorPieza;
    }
    
    public boolean esPrimerMovimiento(){
        return this.esPrimerMovimiento;
    }
    
    public abstract Collection<Movimiento> calcularMovimientosLegales(final Tablero tablero);

    public abstract Pieza moverPieza(Movimiento movimiento);
     
    public enum TipoDePieza{
        ALFIL("A"){
            @Override
            public boolean esRey(){
                return false;
            }

            @Override
            public boolean esTorre() {
                return false;
            }
        },
        CABALLO("C"){
             @Override
             public boolean esRey(){
                return false;
            }

            @Override
            public boolean esTorre() {
                return false;
            }
        },
        PEÓN("P"){
             @Override
             public boolean esRey(){
                return false;
            }

            @Override
            public boolean esTorre() {
                return false;
            }
        },
        DAMA("D"){
             @Override
             public boolean esRey(){
                return false;
            }

            @Override
            public boolean esTorre() {
                return false;
            }
        },
        REY("R"){
             @Override
             public boolean esRey(){
                return true;
            }

            @Override
            public boolean esTorre() {
                return false;
            }
        },
        TORRE("T"){
             @Override
             public boolean esRey(){
                return false;
            }

            @Override
            public boolean esTorre() {
                return true;
            }
        };
       
        private final String nombreDePieza;
        
        TipoDePieza(final String nombreDePieza){

            this.nombreDePieza = nombreDePieza;
        }
        
        @Override
        public String toString(){
            return this.nombreDePieza;
        }
        
        public abstract boolean esRey();
        public abstract boolean esTorre();

    }
}
    
 
    

