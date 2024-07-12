import { Paper } from '@mui/material';
import { useEffect, useState } from 'react';
import CustomButton from '../../components/button/custom-button';
import CustomInput from '../../components/input/custom-input';
import CustomTable from '../../components/table/custom-table';
import { TypeButton } from '../../enum/type-button';
import { Fornecedor } from '../../model/fornecedor';
import { Produto } from '../../model/produto';
import { ProdutoFornecedor } from '../../model/produtoFornecedor';
import { getFornecedores } from '../../service/fornecedor/fornecedorservice';
import { getProdutos } from '../../service/produto/produtoservice';
import theme from '../../theme';
import { HeadCell } from '../../utils/headerCell';
import { DashboardContainer, Divisor, FilterSection } from './styles';

export const Dashboard = () => {
    const [produtos, setProdutos] = useState<Produto[]>([]);
    const [fornecedores, setFornecedores] = useState<Fornecedor[]>([]);
    const [dados, setDados] = useState<ProdutoFornecedor[]>([]);
    const [loadProd, isLoadProd] = useState<boolean>(false);
    const [loadForn, isLoadForn] = useState<boolean>(false);

    const [searchTerm, setSearchTerm] = useState<string>('');

    const handleSearchChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setSearchTerm(event.target.value);
    };

    const filteredProdutos = dados.filter((produto) =>
        Object.values(produto).some((value) =>
            value.toString().toLowerCase().includes(searchTerm.toLowerCase())
        )
    );

    useEffect(() => {
        getProdutos(0, 10, "nome", "asc").then((response) => {
            setProdutos(response.content);
        }).catch(e => console.log(e))
            .finally(() => {
                isLoadProd(true)
            });
    }, []);

    useEffect(() => {
        getFornecedores().then((response) => {
            setFornecedores(response);
        }).catch(e => console.log(e))
            .finally(() => {
                isLoadForn(true);
            });
    }, []);

    useEffect(() => {
        if (loadForn && loadProd) {
            const prodForn: Array<ProdutoFornecedor> = produtos.map(prod => {
                const forn = fornecedores.find(f => f.id === prod.fornecedor);
                return new ProdutoFornecedor(
                    prod.id,
                    prod.nome,
                    prod.descricao,
                    prod.preco,
                    prod.quantidade,
                    prod.categoria,
                    forn?.nome,
                    forn?.codigoPais,
                    forn?.nomePais
                )
            });
            setDados(prodForn);
        }
    }, [loadForn, loadProd, produtos, fornecedores]);

    const columns = ['nome', 'descricao', 'preco', 'quantidade', 'categoria', 'nomeFornecedor', 'nomePais']

    const headCells: HeadCell[] = [
        { id: 'nome', numeric: false, label: 'Nome' },
        { id: 'descricao', numeric: false, label: 'Descrição' },
        { id: 'preco', numeric: true, label: 'Preço' },
        { id: 'quantidade', numeric: true, label: 'Quantidade' },
        { id: 'categoria', numeric: false, label: 'Categoria' },
        { id: 'nomeFornecedor', numeric: false, label: 'Fornecedor' },
        { id: 'nomePais', numeric: false, label: 'Região do fornecedor' },
    ];

    return (
        <DashboardContainer>
            <Paper style={{ padding: theme.spacing_sm }}>
                <FilterSection>
                    <CustomInput accessibilityLabel='Filtro-de-pesquisa' label='Pesquisar' type='text' onChange={handleSearchChange} value={searchTerm} />
                    <CustomButton accessibilityLabel='botão que leva ao cadastro de produtos ' disabled={false} title='Cadastrar Produto' type={TypeButton.PRIMARY} onPress={() => { console.log("nada por aqui por enquanto ") }} />
                </FilterSection>
                <Divisor />
                <CustomTable dados={filteredProdutos} headers={headCells} columns={columns} />
            </Paper>
        </DashboardContainer>
    );

    // <CustomButton accessibilityLabel='teste ' disabled={false} title='Teste' type={TypeButton.PRIMARY} key={10} onPress={() => { }} />
    // <CustomInput accessibilityLabel='input' label='IPUT TESTE' disabled={false} required={true} type='text' key={231} />
}

export default Dashboard;