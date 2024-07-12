export class Produto {
    id: string;
    nome: string;
    descricao: string;
    preco: number;
    quantidade: number;
    categoria: string;
    fornecedor: string;
    dataCriacao: Date;

    constructor(
        id: string,
        nome: string,
        descricao: string,
        preco: number,
        quantidade: number,
        categoria: string,
        fornecedor: string,
        dataCriacao: Date = new Date()
    ) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.dataCriacao = dataCriacao;
    }
}
