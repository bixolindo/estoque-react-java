import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL;

export const getProdutos = async (page: number, size: number, sortBy: string, sortDir: string) => {
    const response = await axios.get(`${API_URL}/produtos?page=${page}&size=${size}&sortBy=${sortBy}&sortDir=${sortDir}`);

    return response.data;
}