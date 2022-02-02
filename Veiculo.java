import java.util.Random;

public abstract class Veiculo{
    private final int identificacao; //um numero aleatório de 0 a 19
    private Roda[] rodas;            //array de rodas dos veiculos
    private final int qtdRodas;      //quantidade de rodas dos veiculos
    private int distanciaPercorrida;  //distancia que foi percorrida pelos veiculos

    //método construtor, define os valores default dos veiculos
    public Veiculo(int ident, int quantidadeRodas, int distanciaPercorrida){
        this.identificacao = ident;
        this.distanciaPercorrida=distanciaPercorrida;
        this.qtdRodas=quantidadeRodas;
        this.rodas = new Roda[qtdRodas];
        for(int i=0;i<rodas.length;i++)
        {
            rodas[i]=new Roda();
        }
    }

    //mover veiculos, cada objeto veiculo implementa seu método
    public abstract void moverVeiculo();

    //desenha os veiculos, cada classe implementa seu método
    public abstract void desenharVeiculo();

    //imprime as informações do veiculo, cada classe implementa seu método
    public abstract void imprimirDados();

    //retorna a quantidade de rodas
    public int getQtdRodas() { return qtdRodas;}

    //retorna o ID do veiculo
    public int getIdentificacao(){return this.identificacao;}

    //retorna o valor da variavel distancia percorrida
    public int getDistanciaPercorrida() { return distanciaPercorrida;}

    //incrementa a variavel distancia percorrida com seu valor mais um valor passado
    public void setdistanciaPercorrida(int dist){this.distanciaPercorrida += dist;}

    //Calibra ou esvazia uma roda especifica passada pela variavel numRoda
    public void calibrar(int numRoda,boolean caliEsva){ rodas[numRoda].setCalibragem(caliEsva); }

    //calibra uma roda especifica passada pela variavel numRoda
    public void calibrar(int numRoda){ rodas[numRoda].setCalibragem(true); }

    //esvazia uma roda especifica passada pela variavel numRoda
    public void esvaziar(int numRoda){ rodas[numRoda].setCalibragem(false); }

    //verifica de todas as rodas estão calibradas ou não
    public boolean verificaRodasCalibradas()
    {
        for(int i = 0; i<rodas.length; i++){
            if(!rodas[i].getCalibragem()){
                System.out.println("A roda "+i+" do veiculo "+getIdentificacao()+" não está calibrada");
                return false;
            }
        }
        return true;
    }
}
