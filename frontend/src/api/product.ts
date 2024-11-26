import { Product } from '../types/Product';

export const fetchProducts = async (): Promise<Product[]> => {
    const response = await fetch('http://localhost:8080/api/products');
    console.log(response)
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    return response.json();
};