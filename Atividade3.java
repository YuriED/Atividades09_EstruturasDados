public class Atividade3 {
    private Node cabeca;

    public Atividade3() {
        cabeca = null;
    }

    public int contarElementos() {
        if (cabeca == null) {
            return 0;
        }

        int contador = 1;
        Node atual = cabeca.next;
        while (atual != cabeca) {
            contador++;
            atual = atual.next;
        }
        return contador;
    }

    public void inserirNoInicio(int data) {
        Node novoNo = new Node(data);
        if (cabeca == null) {
            cabeca = novoNo;
            novoNo.next = cabeca;
        } else {
            novoNo.next = cabeca.next;
            cabeca.next = novoNo;
        }
    }

    public void concatenar(Atividade3 lista) {
        if (cabeca == null) {
            cabeca = lista.cabeca;
        } else if (lista.cabeca != null) {
            Node cauda1 = cabeca.next;
            Node cauda2 = lista.cabeca.next;

            cabeca.next = lista.cabeca.next;
            lista.cabeca.next = cauda1;
            cauda2.next = cabeca;

            cabeca = lista.cabeca;
        }
    }

    public void intercalarListasOrdenadas(Atividade3 lista1, Atividade3 lista2) {
        Node no1 = lista1.cabeca;
        Node no2 = lista2.cabeca;

        Atividade3 listaIntercalada = new Atividade3();

        while (no1.next != lista1.cabeca && no2.next != lista2.cabeca) {
            if (no1.data <= no2.data) {
                listaIntercalada.inserirNoInicio(no1.data);
                no1 = no1.next;
            } else {
                listaIntercalada.inserirNoInicio(no2.data);
                no2 = no2.next;
            }
        }

        while (no1.next != lista1.cabeca) {
            listaIntercalada.inserirNoInicio(no1.data);
            no1 = no1.next;
        }

        while (no2.next != lista2.cabeca) {
            listaIntercalada.inserirNoInicio(no2.data);
            no2 = no2.next;
        }

        listaIntercalada.inserirNoInicio(no1.data);
        listaIntercalada.inserirNoInicio(no2.data);

        cabeca = listaIntercalada.cabeca;
    }

    public Atividade3 copiar() {
        if (cabeca == null) {
            return null;
        }

        Atividade3 listaCopiada = new Atividade3();
        Node atual = cabeca.next;

        while (atual != cabeca) {
            listaCopiada.inserirNoInicio(atual.data);
            atual = atual.next;
        }

        listaCopiada.inserirNoInicio(cabeca.data);
        return listaCopiada;
    }

    public void exibir() {
        if (cabeca == null) {
            return;
        }

        Node atual = cabeca;
        do {
            System.out.print(atual.data + " ");
            atual = atual.next;
        } while (atual != cabeca);
        System.out.println();
    }

    public static void main(String[] args) {
        Atividade3 lista1 = new Atividade3();
        lista1.inserirNoInicio(3);
        lista1.inserirNoInicio(2);
        lista1.inserirNoInicio(1);

        Atividade3 lista2 = new Atividade3();
        lista2.inserirNoInicio(6);
        lista2.inserirNoInicio(5);
        lista2.inserirNoInicio(4);

        System.out.println("Lista 1:");
        lista1.exibir(); 

        System.out.println("Número de elementos na lista 1: " + lista1.contarElementos()); 

        System.out.println("Lista 2:");
        lista2.exibir(); 

        System.out.println("Número de elementos na lista 2: " + lista2.contarElementos());

        lista1.concatenar(lista2);
        System.out.println("Lista concatenada:");
        lista1.exibir(); 

        Atividade3 listaCopiada = lista1.copiar();
        System.out.println("Lista copiada:");
        listaCopiada.exibir(); 

        Atividade3 lista3 = new Atividade3();
        lista3.inserirNoInicio(8);
        lista3.inserirNoInicio(7);

        Atividade3 listaIntercalada = new Atividade3();
        listaIntercalada.intercalarListasOrdenadas(lista1, lista3);
        System.out.println("Lista intercalada:");
        listaIntercalada.exibir(); 
    }
}