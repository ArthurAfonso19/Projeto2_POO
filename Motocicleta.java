import java.util.Random;
public class Motocicleta extends VeiculoMotorizado implements IPVA{ //herda da calsse VeiculoMotorizado e implementa IPVA
    private String[] moto = {"   ,_oo\n",".-/c-//::          Motocicleta\n","(_)'==(_)\n\n"};  //Desenho do veiculo
    private boolean IPVA;  //informação se o IPVA do veiculo está pago ou não

    //método construtor da classe motocicleta
    public Motocicleta(int ident,int qtdeRodas, int distanciaIni){
        super(ident,qtdeRodas,distanciaIni);
        Random x = new Random();
        int i =  x.nextInt(100);
        if(i % 2 == 0) {
            this.IPVA = true;
        }
        else{
            this.IPVA = false;
        }
    }

    //calcula o valor do IPVA do veiculo
    public double calcularValorIPVA() {return (valorBase * cte_Motocicleta);}

    //movimentar o veiculo motocicleta na corrida
    public void moverVeiculo() {
        String espacoB = "      ";
        if(getCombustivel()>.25){
            if(this.IPVA == true)
            {
                if(verificaRodasCalibradas())
                {
                    System.out.println("O veiculo "+getIdentificacao()+" se movimentou");
                    for(int i = 0; i< moto.length; i++)
                    {
                        moto[i] = espacoB +moto[i];
                    }
                    desenharVeiculo();
                    setdistanciaPercorrida(1);
                    setCombustivel(.25);
                }
            }
            else System.out.println("O veiculo "+getIdentificacao()+" não possui IPVA pago");
        }
        else System.out.println("O veiculo "+getIdentificacao()+" não possui combustivel suficiente");

    }

    //desenhar o veiculo motocicleta
    public void desenharVeiculo() {
        for(int i=0;i<moto.length;i++)
        {
            System.out.print(moto[i]);
        }
    }

    //imprimir as informações do veiculo motocicleta
    public void imprimirDados() {
        if(this.IPVA){
            System.out.println("A motocicleta com id "+getIdentificacao()+" possui "+getQtdRodas()+" rodas, percorreu: "
                    +getDistanciaPercorrida() +" espaços e seu IPVA está pago e possui o valor de "+calcularValorIPVA());
        }
        else System.out.println("A motocicleta com id "+getIdentificacao()+" possui "+getQtdRodas()+" rodas, percorreu: "
                +getDistanciaPercorrida() +" espaços e seu IPVA não está pago");

    }
}
