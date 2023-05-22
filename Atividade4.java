public class Atividade4 {
    private Node cabeca;

    public Atividade4() {
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
            cabeca.next = cabeca;
            cabeca.prev = cabeca;
        } else {
            novoNo.next = cabeca.next;
            novoNo.prev = cabeca;
            cabeca.next.prev = novoNo;
            cabeca.next = novoNo;
        }
    }

    public void concatenar(Atividade4 lista) {
        if (cabeca == null) {
            cabeca = lista.cabeca;
        } else if (lista.cabeca != null) {
            Node cauda1 = cabeca.prev;
            Node cauda2 = lista.cabeca.prev;

            cabeca.prev = lista.cabeca.prev;
            lista.cabeca.prev = cauda1;
            cauda2.next = cabeca;
            cabeca.next.prev = cauda2;
        }
    }

    public void intercalarListasOrdenadas(Atividade4 lista1, Atividade4 lista2) {
        Node no1 = lista1.cabeca;
        Node no2 = lista2.cabeca;

        Atividade4 listaIntercalada = new Atividade4();

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

    public Atividade4 copiar() {
        if (cabeca == null) {
            return null;
        }

        Atividade4 listaCopiada = new Atividade4();
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

    public void exibirReverso() {
        if (cabeca == null) {
            return;
        }

        Node atual = cabeca.prev;
        do {
            System.out.print(atual.data + " ");
            atual = atual.prev;
        } while (atual != cabeca.prev);
        System.out.println();
    }
}