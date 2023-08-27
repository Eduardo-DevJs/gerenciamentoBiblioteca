package util;

import LivroBiblioteca.LivroBiblioteca;
import entidade.Livro;

import java.util.Scanner;

public class Util {
    Scanner read = new Scanner(System.in);
    Livro livro = new Livro();
    LivroBiblioteca livroBiblioteca = new LivroBiblioteca();

    public void options() {
        char res;
        do {
            System.out.println("1 - Criar Livro");
            System.out.println("2 - Mostrar Acervo");
            System.out.println("3 - Atualizar Livro");
            System.out.println("4 - Deletar Livro");
            System.out.println("");
            System.out.print("Digite um opção: ");
            int option = Integer.parseInt(read.nextLine());


            switch (option) {
                case 1:
                    System.out.println("Titulo do Livro: ");
                    livro.setTitulo(read.nextLine());
                    System.out.println("Autor do Livro: ");
                    livro.setAutor(read.nextLine());
                    System.out.println("Ano do Livro: ");
                    livro.setAno_publicacao(Integer.parseInt(read.nextLine()));

                    livroBiblioteca.cadastrarLivro(livro);
                    break;
                case 2:
                    for (Livro livroBibliotecaLivro : livroBiblioteca.getLivros()) {
                        System.out.println("ID: " + livroBibliotecaLivro.getId_livro());
                        System.out.println("Titulo: " + livroBibliotecaLivro.getTitulo());
                        System.out.println("Autor: " + livroBibliotecaLivro.getAutor());
                        System.out.println("Lançamento: " + livroBibliotecaLivro.getAno_publicacao());
                        System.out.println("--------------------------------------------------------");

                    }
                    break;
                case 3:
                    System.out.println("Deseja atualizar qual Livro? [ID]");
                    livro.setId_livro(read.nextInt());

                    System.out.println("Novo titulo: ");
                    livro.setTitulo(read.nextLine());
                    System.out.println("Novo autor: ");
                    livro.setAutor(read.nextLine());
                    System.out.println("Novo ano de publicacao: ");
                    livro.setAno_publicacao(read.nextInt());

                    livroBiblioteca.atualizarLivros(livro);
                    break;
                case 4:
                    System.out.println("Deseja Excluir qual Livro? [ID]");
                    int id = read.nextInt();

                    System.out.println("Tem certeza deseja exlcuir livro? [s/n]");
                    char resp = read.nextLine().charAt(0);

                    if (resp == 's') {
                        livroBiblioteca.deletarLivro(id);
                    } else {
                        System.out.println("Livro não será exluido");
                    }
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
            }

            System.out.println("Deseja Continuar? [S/N]");
            res = read.nextLine().charAt(0);
        } while (res != 'n');
    }
}
