import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableRow, { tableRowClasses } from '@mui/material/TableRow';
import styled from 'styled-components';
import theme from '../../theme';
import Table, { tableClasses } from '@mui/material/Table';

const StyledTable = styled(Table)`
  border: ${props => props.theme.stroke_100} solid ${props => props.theme.color_neutral_medium_04};
  border-radius: ${props => props.theme.radius_300};
  &.${tableClasses.root}{
    padding: ${theme.spacing_xs};
    border-collapse: separate;
  }
`;

const StyledTableCell = styled(TableCell)`
  &.${tableCellClasses.head} {
    background-color: ${props => props.theme.color_neutral_lightest};
    color: ${props => props.theme.color_neutral_medium_02};
    padding: ${props => props.theme.spacing_micro};
    font-size: ${props => props.theme.font_size_xs};
    text-align: left;
    font-weight: ${props => props.theme.font_weight_medium};

    border-bottom: ${props => props.theme.stroke_200} solid ${props => props.theme.color_neutral_medium_04};
  }
  
  &.${tableCellClasses.body} {
    font-size: ${props => props.theme.font_size_xs};
    text-align: left;
    font-weight: ${props => props.theme.font_weight_light};
    color: ${props => props.theme.color_neutral_medium_01};
    padding: ${props => props.theme.spacing_micro};
  }
`;

const StyledTableRow = styled(TableRow)`
  &.${tableRowClasses.root} {
    background-color: ${props => props.theme.color_neutral_lightest};
    border: ${props => props.theme.stroke_100} solid ${props => props.theme.color_neutral_medium_04};
    border-radius: ${props => props.theme.radius_300};
    padding: ${props => props.theme.spacing_xxs};
    font-size: ${props => props.theme.font_size_xs};

    &:nth-of-type(even) {
      background-color: ${props => props.theme.color_neutral_lightest};
    }
  }

  &.${tableRowClasses.head} {
    background-color: ${props => props.theme.color_neutral_lightest};
  }

  &.${tableRowClasses.selected} {
    background-color: ${props => props.theme.color_neutral_lightest};
  }

  &.${tableRowClasses.hover} {
    background-color: ${props => props.theme.color_neutral_lightest};
  }

  &.${tableRowClasses.footer} {
    background-color: ${props => props.theme.color_neutral_lightest};
  }
`;

export { StyledTable, StyledTableCell, StyledTableRow };

