import java.util.Random;

public abstract class VeiculoMotorizado extends Veiculo{ //herda da classe veiculo

    //Atributos da classe
    private boolean ipva = true; //1 para ipva pago 0 para ipv nao pago
    private double combIni;      //cumbustivel que os veiculos iniciam

    //metodo construtor de VeiculoMotorizado
    public VeiculoMotorizado(int ident, int qtdeRodas,int distIni){
      super(ident,qtdeRodas,distIni);
      Random aleatorio = new Random();
      int sorteio;
      sorteio = aleatorio.nextInt(100);
      if(sorteio % 2 == 0)
      {
        this.ipva = true;
      }
      else
      {
        this.ipva = false;
      }
      this.combIni = 3.5;
    }

    //metodo cpom sobrecarga **setCombustive**
    //incrementa o valor da variavel combIni com o valor recebido
    public void setCombustivel(float comb){this.combIni += comb;}

    //decrementa o valor da variavel combIni com o valor recebido
    public void setCombustivel(double comb){this.combIni -= comb;}

    //retorna o valor da variavel combIni
    public double getCombustivel(){ return combIni;}

    //retorna o valor da variavel IPVA
    public boolean getIpva(){ return ipva;}
}
