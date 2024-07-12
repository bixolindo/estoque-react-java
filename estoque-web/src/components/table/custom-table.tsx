import { Paper, TableBody, TableContainer, TableHead, TableRow, TableSortLabel } from "@mui/material";
import { useState } from "react";
import { Produto } from "../../model/produto";
import { HeadCell } from "../../utils/headerCell";
import { StyledTable, StyledTableCell, StyledTableRow } from "./styles";


type Order = 'asc' | 'desc';

interface Props {
    onCLickItem?: Function;
    headers: HeadCell[];
    dados: Array<any>;
    columns: string[];
    paginationLimit?: number;
}

const descendingComparator = <T,>(a: T, b: T, orderBy: keyof T) => {
    if (b[orderBy] < a[orderBy]) {
        return -1;
    }
    if (b[orderBy] > a[orderBy]) {
        return 1;
    }
    return 0;
};

const getComparator = <Key extends keyof any>(
    order: Order,
    orderBy: Key
): ((a: { [key in Key]: any }, b: { [key in Key]: any }) => number) => {
    return order === 'desc'
        ? (a, b) => descendingComparator(a, b, orderBy)
        : (a, b) => -descendingComparator(a, b, orderBy);
};

const stableSort = <T,>(array: T[], comparator: (a: T, b: T) => number) => {
    const stabilizedThis = array.map((el, index) => [el, index] as [T, number]);
    stabilizedThis.sort((a, b) => {
        const order = comparator(a[0], b[0]);
        if (order !== 0) return order;
        return a[1] - b[1];
    });
    return stabilizedThis.map((el) => el[0]);
};



export const CustomTable = ({ onCLickItem, headers, columns, dados, paginationLimit = 10 }: Props) => {

    const [order, setOrder] = useState<Order>('asc');
    const [orderBy, setOrderBy] = useState<keyof any>('nome');
    const [selected, setSelected] = useState<string[]>([]);

    const handleRequestSort = (
        event: React.MouseEvent<unknown>,
        property: keyof Produto
    ) => {
        const isAsc = orderBy === property && order === 'asc';
        setOrder(isAsc ? 'desc' : 'asc');
        setOrderBy(property);
    };


    const handleClick = (event: React.MouseEvent<unknown>, id: string) => {
        const selectedIndex = selected.indexOf(id);
        let newSelected: string[] = [];

        if (selectedIndex === -1) {
            newSelected = newSelected.concat(selected, id);
        } else if (selectedIndex === 0) {
            newSelected = newSelected.concat(selected.slice(1));
        } else if (selectedIndex === selected.length - 1) {
            newSelected = newSelected.concat(selected.slice(0, -1));
        } else if (selectedIndex > 0) {
            newSelected = newSelected.concat(
                selected.slice(0, selectedIndex),
                selected.slice(selectedIndex + 1)
            );
        }

        setSelected(newSelected);
    };

    const isSelected = (id: string) => selected.indexOf(id) !== -1;

    return (
        <TableContainer component={Paper} style={{ boxShadow: 'none', width: 'auto' }}>
            <StyledTable aria-label="customized table">
                <TableHead>
                    <TableRow>
                        {headers.map((headercell) => (
                            <StyledTableCell
                                key={headercell.id}
                                sortDirection={orderBy === headercell.id ? order : false}
                            >
                                <TableSortLabel
                                    active={orderBy === headercell.id}
                                    direction={orderBy === headercell.id ? order : 'asc'}
                                    onClick={(event) => handleRequestSort(event, headercell.id)}
                                >
                                    {headercell.label}
                                </TableSortLabel>
                            </StyledTableCell>
                        ))}
                    </TableRow>
                </TableHead>
                <TableBody>
                    {stableSort(dados, getComparator(order, orderBy)).map(
                        (data, index) => {
                            const isItemSelected = isSelected(data.id);
                            return (
                                <StyledTableRow
                                    key={data.id}
                                    hover
                                    onClick={(event) => handleClick(event, data.id)}
                                    role="checkbox"
                                    aria-checked={isItemSelected}
                                    tabIndex={-1}
                                    selected={isItemSelected}>
                                    {columns.map((element, index) => (
                                        index === 0
                                            ? <StyledTableCell key={element + index} component="th" scope="row">
                                                {data[`${element}`]}
                                            </StyledTableCell>
                                            : <StyledTableCell key={element + index} >{data[`${element}`]}</StyledTableCell>
                                    ))}

                                </StyledTableRow>
                            )
                        })}

                </TableBody>
            </StyledTable>
        </TableContainer>
    );
}

export default CustomTable;