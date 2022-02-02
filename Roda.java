import java.util.Random;
public class Roda{
    //Atributos da classe
    private boolean calibragem = true; //1 para calibrado e 0 para não calibrado

    //métodos construtor da classe Roda
    public Roda() {
        Random x = new Random();
        int i = x.nextInt(100);
        if (i % 2 == 0) {
            this.calibragem = true;
        } else {
            this.calibragem = false;
        }
    }

    //obter informação se a roda esta calibrada ou não
    public boolean getCalibragem(){ return calibragem;}

    //Definir o valor da calibragem da roda (True ou false)
    public void setCalibragem(boolean calibragem){this.calibragem = calibragem;}
}
