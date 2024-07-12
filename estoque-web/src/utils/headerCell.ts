import { Produto } from "../model/produto";

export interface HeadCell {
    id: keyof Produto | any;
    label: string;
    numeric: boolean;
}