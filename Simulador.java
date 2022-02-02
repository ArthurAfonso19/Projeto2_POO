import java.util.Scanner;
import java.util.Random;

public class Simulador{
  private static final int max = 20;
  private static final float combIni = 3.5F;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int opcao = 0;
    int aux = 0;
    Veiculo[] listaCorrida = new Veiculo[max];
    int id;
    char modelo;
    //menu iterativo para acessar as funções
    do{
      System.out.println("===> SIMULADOR <===");
      System.out.println(" ");
      System.out.println("1 - Incluir um veiculo");
      System.out.println("2 - Remover um veiculo");
      System.out.println("3 - Abastecer um veiculo");
      System.out.println("4 - Movimentar um veículo específico");
      System.out.println("5 - Movimentar veiculos por tipo");
      System.out.println("6 - Movimentar todos os veiculos");
      System.out.println("7 - Imprimir todos os dados de todos os veiculos");
      System.out.println("8 - Imprimir dados de veiculos por tipo");//solicitar qualveículo e qual pneu
      System.out.println("9 - Esvaziar/calibrar um pneu especıfico");
      System.out.println("10 - Calibrar todos os pneus de veıculos por tipo");
      System.out.println("11 - Esvaziar todos os pneus de veıculos por tipo");
      System.out.println("12 - Sair da aplição");
      System.out.println("Digite sua opçao: ");
      opcao = sc.nextInt();
      System.out.println(" ");
      switch (opcao) {
          case 1:

              System.out.println("Incluindo um veiculo...");
              System.out.println("-----------------------------------------");
              Random aleatorio = new Random(System.nanoTime());
              int ident = aleatorio.nextInt(100);
              for(int i = 0; i < listaCorrida.length;i++){
                if((listaCorrida[i] != null) && (listaCorrida[i].getIdentificacao() == ident))
                {
                  ident = aleatorio.nextInt(100);
                }
              }

              char tipo;
              System.out.println("Informe o tipo do veiculo a ser adicionado: ");
              tipo = sc.next().charAt(0);

              for (int i = 0; i < listaCorrida.length; i++)
              {
                  if (listaCorrida[i] == null)
                  {
                    if(tipo == 'B'){
                      listaCorrida[i] = new Bicicleta(ident,tipo);
                    }
                    else if (tipo == 'M'){
                      listaCorrida[i] = new Motocicleta(ident,tipo);
                    }
                    else if (tipo == 'C'){
                      listaCorrida[i] = new CarroPasseio(ident,tipo);
                    }
                    else if(tipo == 'E'){
                      listaCorrida[i] = new Esportivo(ident,tipo);
                    }

                    System.out.println("O veiculo de numero "+ident+" foi adicionado na posicao "+i);
                    aux++;
                    break;
                  }
              }

              if(aux>=20) System.out.println("Cheio, remova um veiculo caso queira adicionar mais");
              System.out.print("\n\n");
              break;

          case 2:
                System.out.println("Removendo um veiculo...");
                System.out.println("-----------------------------");
                System.out.println("Informe o numero do veiculo a ser removido: ");
                id = sc.nextInt();
                for(int i = 0; i < listaCorrida.length; i++)
                {
                    if(listaCorrida[i] != null)
                    {
                      if (listaCorrida[i].getIdentificacao() == id)
                      {
                        listaCorrida[i] = null;
                        System.out.println("O veiculo "+id+" foi removido.");
                        aux--;
                      }
                    }

                }

                System.out.print("\n\n");
                break;

            case 3:

              System.out.println("Abastecendo um veiculo...");
              System.out.println("---------------------------------");
              System.out.println("Informe o id do veiculo que sera abastecido: ");
              id = sc.nextInt();
              double comb;
              System.out.println("Informe a quantidade de combustivel que sera abastecido: ");
              comb = sc.nextFloat();

              for(int i=0; i<listaCorrida.length; i++){
                if(listaCorrida[i] != null)
                {
                    if(listaCorrida[i].getIdentificacao() == id)
                    {
                      if(listaCorrida[i].getModelo() != 'B')
                      {
                        listaCorrida[i].setCombustivel(comb);
                        System.out.println("O veiculo "+ id + " foi abastecido e agora possui "+listaCorrida[i].getCombustivel() + " litros");
                      }
                      else if(listaCorrida[i].getModelo() == 'B')
                      {
                        System.out.println("O veiculo e uma bicicleta e por isso nao pode ser abastecido.");
                      }
                    }
                }
              }
              System.out.print("\n\n");

              break;

            case 4:

              System.out.println("Movimentando um veiculo especifico...");
              System.out.println("--------------------------------------");
              System.out.println("Informe o id do veiculo que vai se movimentar: ");
              id = sc.nextInt();
              for (int i=0; i<listaCorrida.length; i++)
              {
                if(listaCorrida[i] != null)
                {
                  if(listaCorrida[i].getIdentificacao() == id)
                  {
                    movimentarVeiculos(listaCorrida[i]);
                  }
                }
              }

              break;

            case 5:
              System.out.println("Movimentando veiculos por tipo...");
              System.out.println("------------------------------------");
              break;

            case 6:
              System.out.println("Movimentando todos os veiculos...");
              System.out.println("-------------------------------------");

              break;

            case 7:
              System.out.println("Imprimindo todos os dados de todos os veiculos...");
              System.out.println("--------------------------------------------------");
              for(int i=0; i < listaCorrida.length; i++)
              {
                if(listaCorrida[i] != null)
                {
                  System.out.println("Identificação -> " +listaCorrida[i].getIdentificacao());
                  listaCorrida[i].imprimirDados();
                  System.out.println("\n");
                }
              }
              System.out.print("\n\n");

              break;

            case 8:
              System.out.println("Imprimimindo dados de veiculos por tipo...");
              System.out.println("---------------------------------------------");
              System.out.println("Informe o tipo de veiculo que sera impresso os dados: ");
              modelo = sc.next().charAt(0);

              for(int i=0; i<listaCorrida.length; i++){
                if(listaCorrida[i] != null)
                {
                  if (listaCorrida[i].getModelo() == modelo)
                  {
                    System.out.println("Identificação -> " +listaCorrida[i].getIdentificacao());
                    listaCorrida[i].imprimirDados();
                    System.out.println("\n");
                  }
                }
              }

              System.out.print("\n\n");
              break;

            case 9:
              System.out.println("Evaziando/calibrando um pneu especifico...");
              System.out.println("----------------------------------------------");
              System.out.println("Informe a id do veiculo: ");
              id = sc.nextInt();
              int roda;
              System.out.println("Informe a roda que sera calibrada/esvaziada: ");
              roda = sc.nextInt();
              int caliEsva;
              System.out.println("Digite 1 para calibrar e 0 para esvaziar: ");
              caliEsva = sc.nextInt();
              for(int i=0; i<listaCorrida.length; i++){
                if(listaCorrida[i] != null){
                  if(listaCorrida[i].getIdentificacao() == id){
                    listaCorrida[i].calibrarOuEsvaziarRodas(caliEsva,roda,listaCorrida[i].getModelo());
                  }
                }
              }
              break;

            case 10:
              System.out.println("Calibrando todos os pneus de veiculos por tipo...");
              System.out.println("----------------------------------------------------");
              System.out.println("Informe o modelo dos veiculos que serao calibrada os pneus: ");
              modelo = sc.next().charAt(0);

              for(int i=0; i<listaCorrida.length; i++)
              {
                if(listaCorrida[i] != null)
                {
                  if(listaCorrida[i].getModelo() == modelo){
                    listaCorrida[i].calibrarOuEsvaziarRodas(true,modelo);
                  }
                }
              }
              break;

            case 11:
              System.out.println("Esvaziando todos os pneus de veiculos por tipo...");
              System.out.println("---------------------------------------------------");
              System.out.println("Informe o modelo dos veiculos que serao calibrada os pneus: ");
              modelo = sc.next().charAt(0);

              for(int i=0; i<20; i++)
              {
                if(listaCorrida[i] != null)
                {
                  if(listaCorrida[i].getModelo() == modelo){
                    listaCorrida[i].calibrarOuEsvaziarRodas(false,modelo);
                  }
                }
              }
              break;

            case 12:
              System.out.println("Imprimindo pista de corrida...");
              System.out.println("----------------------------------------------------");
              break;

            default:
              System.out.println("Opcao invalida");
              break;
          }
        }while(opcao != 12);
      }

      static void movimentarVeiculos(Veiculo c){
        boolean verificarPneus = true;
        int distancia = 0;
        if(c.getModelo() == 'B'){
          distancia = 2;
        }
        else if (c.getModelo() == 'M'){
          distancia = 3;
        }
        else if (c.getModelo() == 'C'){
          distancia = 5;
        }
        else if(c.getModelo() == 'E'){
          distancia = 10;
        }

        if (c.getQtdRodas() == 2){
            for(int i=0; i<2; i++){
              if(!c.getRodas(i).getCalibragem()){
                System.out.println("O veiculo "+c.getIdentificacao()+" possui o pneu "+i+" descalibrado, não movimenta");
                verificarPneus = false;
                break;
              }
            }
        }
        else if(c.getQtdRodas() == 2){
          for(int i=0; i<4; i++){
            if(!c.getRodas(i).getCalibragem()){
              System.out.println("O veiculo "+c.getIdentificacao()+" possui o pneu "+i+" descalibrado, não movimenta");
              verificarPneus = false;
              break;
            }
          }
        }


        if(verificarPneus == true){
          if(c.getModelo() != 'B'){
            if(c.getIpva()){
              double combNecessario = 0;
              if (c.getModelo() == 'M'){
                combNecessario = distancia * 0.25;
              }
              else if (c.getModelo() == 'C'){
                combNecessario = distancia * 0.75;
              }
              else if(c.getModelo() == 'E'){
                combNecessario = distancia * 2.3;
              }

              if(c.getCombustivel() >= combNecessario){
                System.out.println("O veiculo "+c.getIdentificacao()+" se movimentou "+distancia+" blocos de distancia.");
                c.setCombustivel(combNecessario);
                c.setdistanciaPercorrida(distancia);
              }
              else{
                System.out.println("O veiculo "+c.getIdentificacao()+" nao se movimenta, sem combustivel.");
              }
            }
          }
          else{
            c.setdistanciaPercorrida(distancia);
            System.out.println("O veiculo "+c.getIdentificacao()+" se movimentou "+distancia+" blocos de distancia.");
          }
        }
        else{
          System.out.println("O veiculo "+c.getIdentificacao()+" nao se movimenta, IPVA nao pago.");
        }
      }
    }
