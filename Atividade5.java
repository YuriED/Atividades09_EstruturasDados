public class Atividade5 {
    private Node cabeca;

    public Atividade5() {
        cabeca = new Node(-1);
        cabeca.next = cabeca;
    }

    public boolean estaVazia() {
        return cabeca.next == cabeca;
    }

    public void inserirNoInicio(int data) {
        Node novoNo = new Node(data);
        novoNo.next = cabeca.next;
        cabeca.next = novoNo;
    }

    public void inserirNoFim(int data) {
        Node novoNo = new Node(data);
        Node atual = cabeca;
        while (atual.next != cabeca) {
            atual = atual.next;
        }
        novoNo.next = cabeca;
        atual.next = novoNo;
    }

    public void exibir() {
        if (estaVazia()) {
            System.out.println("Lista vazia.");
            return;
        }

        Node atual = cabeca.next;
        while (atual != cabeca) {
            System.out.print(atual.data + " ");
            atual = atual.next;
        }
        System.out.println();
    }
}
