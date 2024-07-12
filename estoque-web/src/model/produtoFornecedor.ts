export class ProdutoFornecedor {
    id: string;
    nome: string;
    descricao: string;
    preco: number;
    quantidade: number;
    categoria: string;
    nomeFornecedor?: string;
    codigoPais?: string;
    nomePais?: string;

    constructor(
        id: string,
        nome: string,
        descricao: string,
        preco: number,
        quantidade: number,
        categoria: string,
        nomeFornecedor?: string,
        codigoPais?: string,
        nomePais?: string,
    ) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.nomeFornecedor = nomeFornecedor;
        this.codigoPais = codigoPais;
        this.nomePais = nomePais;
    }
}