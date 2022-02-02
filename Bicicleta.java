public class Bicicleta extends Veiculo{ //a classe bicicleta herda os metodos da classe Veiculo
    private String[] bike = {"   __o\n"," _`\\<,_       Bike\n","(*)/ (*)\n\n"}; //desenho do veiculo

    //construtor da classe que define os valores defaul
    public Bicicleta(int ident,int qtdeROdas,int distIni){
      super(ident,qtdeROdas,distIni);
    }

    //método para mover o veiculo Bicicleta na corrida
    public void moverVeiculo() {
        String espacoB = "    ";
        if (verificaRodasCalibradas())
        {
            System.out.println("O veiculo "+getIdentificacao()+" se movimentou");
            for(int i = 0; i<bike.length; i++)
            {
                bike[i] = espacoB + bike[i];
            }
            desenharVeiculo();
            setdistanciaPercorrida(1);
        }
    }

    //desenha o tipo de veiculo Bicicleta
    public void desenharVeiculo(){
        for(int i=0;i<bike.length;i++)
        {
            System.out.print(bike[i]);
        }
    }

    //imprime os dados do veiculo Bicicleta
    public void imprimirDados(){
        System.out.println("A bicicleta com id "+getIdentificacao()+" possui "+getQtdRodas()+" rodas e percorreu: "+getDistanciaPercorrida() +" espaços");
    }
}
