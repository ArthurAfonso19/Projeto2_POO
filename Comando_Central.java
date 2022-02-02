import java.util.Scanner;
import java.util.Random;
// OPÇÃO 1,2,3,4,5,6,7,8,9,10,11,12,13 TESTADAS E OK!
public class Comando_Central {
    private static final int max = 20;
    static Veiculo[] listaCorrida = new Veiculo[max];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String opcao;
        int aux = 0;
        int id;

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
            System.out.println("8 - Imprimir dados de veiculos por tipo");
            System.out.println("9 - Esvaziar/calibrar um pneu especıfico");
            System.out.println("10 - Calibrar todos os pneus de veıculos por tipo");
            System.out.println("11 - Esvaziar todos os pneus de veıculos por tipo");
            System.out.println("12 - Imprimir pista de Corrida");
            System.out.println("13 - Sair da aplicação");
            System.out.println("Digite sua opçao: ");
            opcao = sc.next();
            System.out.println(" ");
            switch (opcao) {
                case "1":

                    System.out.println("Incluindo um veiculo...");
                    System.out.println("-----------------------------------------");
                    Random aleatorio = new Random(System.nanoTime());
                    int ident = aleatorio.nextInt(100);
                    System.out.println("Bicicleta (B) | Motocicleta (M) | Carro Passeio (C) | Esportivo(E)");
                    System.out.println("Informe o tipo do veiculo a ser adicionado: ");
                    char tipo;
                    tipo = sc.next().charAt(0);
                    if(tipo == 'B' || tipo == 'M' || tipo == 'C' || tipo =='E'){
                        if(!verificaExisteIdent(ident)) { //verifica se o ID já esta no vetor, caso sim não insere o veiculo
                            adicionarVeiculo(ident,tipo);
                            aux++;
                        }
                        else System.out.println("Veiculo não adicionado,o id "+ident+" ja foi sorteado");
                    }
                    else System.out.println("Tipo de veiculo incorreto!");

                    if(aux>=21) System.out.println("Cheio, remova um veiculo caso queira adicionar mais");
                    System.out.print("\n\n");
                    break;

                case "2": //Remover um veiculo pelo seu ID
                    System.out.println("Removendo um veiculo...");
                    System.out.println("-----------------------------");
                    System.out.println("Informe o numero do veiculo a ser removido: ");
                    id = sc.nextInt();
                    if(verificaExisteIdent(id)){
                        removerVeiculo(id);
                        aux--;
                    }
                    else System.out.println("O veiculo "+id+" não esta na corrida");
                    System.out.print("\n\n");
                    break;

                case "3": //Abastecer um veiculo pelo seu ID

                    System.out.println("Abastecendo um veiculo...");
                    System.out.println("---------------------------------");
                    System.out.println("Informe o id do veiculo que sera abastecido: ");
                    id = sc.nextInt();
                    float comb;
                    System.out.println("Informe a quantidade de combustivel que sera abastecido: ");
                    comb = sc.nextFloat();
                    if(verificaExisteIdent(id)){
                        abastecerVeiculo(id,comb);
                    }
                    else System.out.println("O veiculo "+id+" não esta na corrida");
                    System.out.print("\n\n");
                    break;

                case "4": //movimentar um veiculo especifico pelo sei id
                    System.out.println("Movimentando um veiculo especifico...");
                    System.out.println("--------------------------------------");
                    System.out.println("Informe o id do veiculo que vai se movimentar: ");
                    id = sc.nextInt();
                    if(verificaExisteIdent(id)){
                        movimentarVeiculo(id);
                    }
                    else System.out.println("O veiculo "+id+" não esta na corrida");
                    System.out.print("\n\n");
                    break;

                case "5": //movimenta todos os veiculos de um tipo especificado
                    System.out.println("Movimentando veiculos por tipo...");
                    System.out.println("------------------------------------");
                    System.out.println("Informe o tipo do veiculo: Bicicleta (B) | Motocicleta (M) | Carro Passeio (C) | Esportivo(E)");
                    tipo = sc.next().charAt(0);
                    movimentarVeiculoPorTipo(tipo);
                    System.out.print("\n\n");
                    break;

                case "6": //movimentar todos os veiculos
                    System.out.println("Movimentando todos os veiculos...");
                    System.out.println("-------------------------------------");
                    movimentarVeiculo();
                    System.out.print("\n\n");
                    break;

                case "7":  //imprimir os dados de todos os veiculos
                    System.out.println("Imprimindo todos os dados de todos os veiculos...");
                    System.out.println("--------------------------------------------------");
                    imprimirTodosDados();
                    System.out.print("\n\n");
                    break;

                case "8": //imprimir todos os dados de um veiculo pelo seu tipo
                    System.out.println("Imprimimindo dados de veiculos por tipo...");
                    System.out.println("---------------------------------------------");
                    System.out.println("Informe o tipo do veiculo: Bicicleta (B) | Motocicleta (M) | Carro Passeio (C) | Esportivo(E)");
                    tipo = sc.next().charAt(0);
                    imprimirDadosPorTipo(tipo);
                    System.out.print("\n\n");
                    break;

                case "9":  //esvaziar ou calibrar um pneu pelo id do veiculo
                    System.out.println("Evaziando/calibrando um pneu especifico...");
                    System.out.println("----------------------------------------------");
                    System.out.println("Informe o id do veiculo: ");
                    id = sc.nextInt();
                    int roda;
                    System.out.println("Informe a roda que sera calibrada/esvaziada: ");
                    roda = sc.nextInt();
                    int caliEsva;
                    System.out.println("Digite 1 para calibrar e 0 para esvaziar: ");
                    caliEsva = sc.nextInt();
                    if (verificaExisteIdent(id)){
                        calibrarEspecifico(id,roda,caliEsva);
                    }
                    else System.out.println("O veiculo "+id+" não esta na corrida");
                    System.out.print("\n\n");
                    break;

                case "10": //calibrar todos os pneus de todos os veiculos do mesmo tipo
                    System.out.println("Calibrando todos os pneus de veiculos por tipo...");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Informe o tipo do veiculo: Bicicleta (B) | Motocicleta (M) | Carro Passeio (C) | Esportivo(E)");
                    tipo = sc.next().charAt(0);
                    calibrarOuEsvaziarPorTipo(true,tipo);
                    System.out.print("\n\n");
                    break;

                case "11":  //esvaziar todos os pneus de todos os veiculos do mesmo tipo
                    System.out.println("Esvaziando todos os pneus de veiculos por tipo...");
                    System.out.println("---------------------------------------------------");
                    System.out.println("Informe o tipo do veiculo: Bicicleta (B) | Motocicleta (M) | Carro Passeio (C) | Esportivo(E)");
                    tipo = sc.next().charAt(0);
                    calibrarOuEsvaziarPorTipo(false,tipo);
                    System.out.print("\n\n");
                    break;

                case "12": //imprimir a pista de corrida com todos os dados
                    System.out.println("Imprimindo pista de corrida...");
                    System.out.println("----------------------------------------------------");
                    imprimirPistaCorrida();
                    System.out.print("\n\n");
                    break;
                case "13":
                    System.out.println("Saindo da Operação...");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }while(!opcao.equalsIgnoreCase("13"));
    }

    //criar um objeto veiculo pelo seu tipo com um ID aleatorio
    private static void adicionarVeiculo(int ident, char tipo) {
        for (int i = 0; i < listaCorrida.length; i++)
        {
            if (listaCorrida[i] == null)
            {
                if(tipo == 'B'){
                    listaCorrida[i] = new Bicicleta(ident,2,0); //cria um objeto do tipo bicicleta na lista de corrida
                    System.out.println("A Bicicleta com id "+ident+" foi adicionado na posicao "+i);
                }
                else if (tipo == 'M'){
                    listaCorrida[i] = new Motocicleta(ident,2,0);//cria um objeto do tipo motocicleta na lista de corrida
                    System.out.println("A Motocicleta com id "+ident+" foi adicionado na posicao "+i);
                }
                else if (tipo == 'C'){
                    listaCorrida[i] = new CarroPasseio(ident,4,0);//cria um objeto do tipo CarroPasseio na lista de corrida
                    System.out.println("O Carro de Passeio com id "+ident+" foi adicionado na posicao "+i);
                }
                else if(tipo == 'E'){
                    listaCorrida[i] = new Esportivo(ident,4,0);//cria um objeto do tipo Esportivo na lista de corrida
                    System.out.println("O Esportivo com id "+ident+" foi adicionado na posicao "+i);
                }
                break;
            }
        }
    }

    //remover um veiculo especifico pelo seu ID
    private static void removerVeiculo(int id) {
        boolean flag = false;
        for(int i = 0; i < listaCorrida.length; i++) //percorre até o tamanho maximo da lista de veiculos
        {
            if(listaCorrida[i] != null) //se tem algum objeto nessa posição do array de veiculos
            {
                if(listaCorrida[i].getIdentificacao()==id) //verifica se o veiculo na lista de corrida é o veiculo passado com ID
                {
                    listaCorrida[i] = null;     //remove o veiculo da corrida
                    System.out.println("O veiculo "+id+" foi removido.");
                }
                flag = true;
            }
        }
        if(!flag){ System.out.println("Pista de corrida vazia"); }
    }

    //abastecer um veiculo especifico pelo seu ID
    private static void abastecerVeiculo(int id, float comb) {
        boolean flag = false;
        for(int i=0; i<listaCorrida.length; i++){
            if(listaCorrida[i]  != null )
            {
                if(listaCorrida[i].getIdentificacao()==id)
                {
                    if(listaCorrida[i] instanceof  VeiculoMotorizado){
                        ((VeiculoMotorizado) listaCorrida[i]).setCombustivel(comb);
                        System.out.println("O veiculo "+ id + " foi abastecido e agora possui "+((VeiculoMotorizado)listaCorrida[i]).getCombustivel() + " litros");
                    }
                    else System.out.println("Não dá pra abstecer uma Bicicleta!");
                }
                flag = true;
            }
        }
        if(!flag){ System.out.println("Pista de corrida vazia"); }
    }

    //mover um veiculo especifico pelo seu ID
    private static void movimentarVeiculo(int id) {
        boolean flag = false;
        for(int i=0 ;i<listaCorrida.length;i++)
        {
            if(listaCorrida[i]!=null){
                if(listaCorrida[i].getIdentificacao()==id) { listaCorrida[i].moverVeiculo(); }
                flag = true;
            }
        }
        if(!flag){ System.out.println("Pista de corrida vazia"); }
    }
    private static void movimentarVeiculo() { //mover todos os veiculos
        boolean flag = false;
        for(int i=0 ;i<listaCorrida.length;i++)
        {
            if (listaCorrida[i] != null) {
                listaCorrida[i].moverVeiculo();
                flag=true;
            }
        }
        if(!flag){ System.out.println("Pista de corrida vazia"); }
    }

    //movimentar todos veiculos do mesmo tipo
    private static void movimentarVeiculoPorTipo(char tipoV){
        boolean flag = false;

        for(int i=0;i<listaCorrida.length;i++)
        {
            if (listaCorrida[i] != null) {
                if (tipoV == 'B') {
                    if(listaCorrida[i] instanceof  Bicicleta) //se o objeto na listaCorrida for do tipo bicicleta
                    {
                        listaCorrida[i].moverVeiculo();
                    }
                }
                else  if(tipoV == 'M'){
                    if(listaCorrida[i] instanceof  Motocicleta)//se o objeto na listaCorrida for do tipo motocicleta
                    {
                        listaCorrida[i].moverVeiculo();
                    }
                }
                else if(tipoV =='C'){
                    if(listaCorrida[i] instanceof  CarroPasseio)//se o objeto na listaCorrida for do tipo CarroPasseio
                    {
                        listaCorrida[i].moverVeiculo();
                    }
                }
                else if(tipoV =='E'){
                    if(listaCorrida[i] instanceof  Esportivo)//se o objeto na listaCorrida for do tipo Esportivo
                    {
                        listaCorrida[i].moverVeiculo();
                    }
                }
                else System.out.println("Tipo do veiculo Inválido"); //caso seja digitado um valor diferente para o tipoV
                flag = true;
            }
        }
        if(!flag){ System.out.println("Pista de corrida vazia"); }
    }

    //imprimir todos os dados de todos os veiculos
    private static void imprimirTodosDados() {
        boolean flag = false;
        for (int i = 0; i < listaCorrida.length; i++) {
            if (listaCorrida[i] != null) {
                if (listaCorrida[i] instanceof Bicicleta) { //se o objeto na listaCorrida for do tipo Bicicleta
                    listaCorrida[i] .imprimirDados();
                }
                else if (listaCorrida[i] instanceof Motocicleta) {//se o objeto na listaCorrida for do tipo Moocicleta
                    listaCorrida[i] .imprimirDados();
                }
                else if (listaCorrida[i] instanceof CarroPasseio) {//se o objeto na listaCorrida for do tipo CarroPasseio
                    listaCorrida[i] .imprimirDados();
                }
                else if (listaCorrida[i] instanceof Esportivo) { //se o objeto na listaCorrida for do tipo Esportivo
                    listaCorrida[i] .imprimirDados();
                }
                flag = true;
            }
        }
        if(!flag){ System.out.println("Pista de corrida vazia"); }
    }

    //imprimir todos os dados de todos os veiculos do mesmo tipo
    private static void imprimirDadosPorTipo(char tipoV) {
        boolean flag = false;
        for (int i = 0; i < listaCorrida.length; i++) {
            if (listaCorrida[i] != null) {

                if (tipoV == 'B') {
                    if(listaCorrida[i] instanceof  Bicicleta)
                    {
                        listaCorrida[i] .imprimirDados();
                    }
                }
                else  if(tipoV == 'M'){
                    if(listaCorrida[i] instanceof  Motocicleta)
                    {
                        listaCorrida[i] .imprimirDados();
                    }
                }
                else if(tipoV =='C'){
                    if(listaCorrida[i] instanceof  CarroPasseio)
                    {
                        listaCorrida[i] .imprimirDados();
                    }
                }
                else if(tipoV =='E'){
                    if(listaCorrida[i] instanceof  Esportivo)
                    {
                        listaCorrida[i] .imprimirDados();
                    }
                }
                else System.out.println("Tipo do veiculo Inválido");
                flag = true;
            }
        }
        if(!flag){ System.out.println("Pista de corrida vazia"); }
    }

    //Calibrar um Pneu especifico pelo ID do veiculo e o numero da roda
    private static void calibrarEspecifico(int id,int numRoda, int caliEsva) {
        boolean flag = false;
        for(int i = 0; i < listaCorrida.length;i++){
            if (listaCorrida[i] != null) {
                if(listaCorrida[i].getIdentificacao()==id)
                {
                    if(caliEsva ==1) { //se caliEsva for 1 vou calibrar
                       if(numRoda<4){  //Verificar pq um veiculo não tem mais que 4 rodas
                          if(numRoda<2){  //Bicicleta e motocicleta não tem mais que duas rodas
                              if (listaCorrida[i] instanceof Bicicleta) {
                                  {
                                      listaCorrida[i].calibrar(numRoda); //calibrar a roda Numroda da bicicleta
                                      System.out.println("A roda "+numRoda+" da Bicicleta foi calibrada");
                                  }
                              }
                              if (listaCorrida[i] instanceof Motocicleta) {
                                  {
                                      listaCorrida[i].calibrar(numRoda);
                                      System.out.println("A roda "+numRoda+" da Motocicleta foi calibrada");
                                  }
                              }
                          }
                           if (listaCorrida[i] instanceof CarroPasseio) {
                               {
                                   listaCorrida[i].calibrar(numRoda);
                                   System.out.println("A roda "+numRoda+" do Carro de Passeio foi calibrada");
                               }
                           }
                           if (listaCorrida[i] instanceof Esportivo) {
                               {
                                   listaCorrida[i].calibrar(numRoda);
                                   System.out.println("A roda "+numRoda+" do Esportivo foi calibrada");
                               }
                           }
                       }
                       else System.out.println("Roda inválida");
                    }
                    else {
                        if(numRoda<4){
                            if(numRoda<2){
                                if (listaCorrida[i] instanceof Bicicleta) {
                                    {
                                        listaCorrida[i].esvaziar(numRoda);
                                        System.out.println("A roda "+numRoda+" da Bicicleta foi esvaziada");
                                    }
                                }
                                if (listaCorrida[i] instanceof Motocicleta) {
                                    {
                                        listaCorrida[i].esvaziar(numRoda);
                                        System.out.println("A roda "+numRoda+" da Motocicleta foi esvaziada");
                                    }
                                }
                            }
                            if (listaCorrida[i] instanceof CarroPasseio) {
                                {
                                    listaCorrida[i].esvaziar(numRoda);
                                    System.out.println("A roda "+numRoda+" do Carro de Passeio foi esvaziada");
                                }
                            }
                            if (listaCorrida[i] instanceof Esportivo) {
                                {
                                    listaCorrida[i].esvaziar(numRoda);
                                    System.out.println("A roda "+numRoda+" do Esportivo foi esvaziada");
                                }
                            }
                        }
                        else System.out.println("Roda inválida");
                    }
                    flag = true;
                }
            }
        }
        if(!flag){ System.out.println("Pista de corrida vazia"); }
    }

    //Calibrar ou esvaziar todas as rodas de determinado tipo de veiculo
    private  static void calibrarOuEsvaziarPorTipo(boolean caliEsva, char tipo){
        boolean flag = false;
        for (int i = 0; i < listaCorrida.length; i++) {
            if (listaCorrida[i] != null) {
                if (tipo == 'B') {
                    if (listaCorrida[i] instanceof Bicicleta) {
                        for(int j=0;j<2;j++)
                        {
                            listaCorrida[i].calibrar(j,caliEsva);
                        }
                    }
                }
                else if (tipo == 'M') {
                    if (listaCorrida[i] instanceof Motocicleta) {
                        for(int j=0;j<2;j++)
                        {
                            listaCorrida[i].calibrar(j,caliEsva);
                        }
                    }
                }
                else if(tipo == 'C') {
                    if (listaCorrida[i] instanceof CarroPasseio) {
                        for(int j=0;j<4;j++)
                        {
                            listaCorrida[i].calibrar(j,caliEsva);
                        }
                    }
                }
                else if(tipo =='E') {
                    if (listaCorrida[i] instanceof Esportivo) {
                        for(int j=0;j<4;j++)
                        {
                            listaCorrida[i].calibrar(j,caliEsva);
                        }
                    }
                }
                else System.out.println("Tipo do veiculo Inválido");
                flag = true;
            }
        }
        if(!flag){ System.out.println("Pista de corrida vazia"); }
    }

    //imprimir a pista de corrida com todos os veiculos presentes em listaCorrida
    private static void imprimirPistaCorrida(){
        boolean flag = false;
        for (int i = 0; i < listaCorrida.length; i++) {
            if (listaCorrida[i] != null) {
                listaCorrida[i].desenharVeiculo();
                flag = true;
            }
        }
        if(!flag){ System.out.println("Pista de corrida vazia"); }
    }

    //verificar se o ID passado está presente na listaCorrida
    private static boolean verificaExisteIdent(int ident) {

        for(int i = 0; i < listaCorrida.length;i++){
            if((listaCorrida[i] != null) && (listaCorrida[i].getIdentificacao() == ident)) { return true;}
        }
        return false;
    }
}
