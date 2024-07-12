export class Fornecedor {
    id: string;
    nome: string;
    codigoPais: string;
    nomePais: string;
    bandeiraPais: string;

    constructor(
        id: string,
        nome: string,
        codigoPais: string,
        nomePais: string,
        bandeiraPais: string,
    ) {
        this.id = id;
        this.nome = nome;
        this.codigoPais = codigoPais;
        this.nomePais = nomePais;
        this.bandeiraPais = bandeiraPais;
    }
}