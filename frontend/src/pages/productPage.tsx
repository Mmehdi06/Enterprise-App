import { useQuery } from '@tanstack/react-query';
import {fetchProducts} from "@/api/product.ts";
import ProductCard from "@/components/product/ProductCard.tsx";



export default function ProductList() {
    const { isPending, isError, data, error } = useQuery({
        queryKey: ['products'],
        queryFn: fetchProducts,
    })
    if (isPending) return <div>Loading...</div>;
    if (isError) return <div>Error: {error.message}</div>;

    return (
        <div>
            <h1>Product List</h1>
            <ul>
                {data.map(product => (
                    <ProductCard product={product}/>
                ))}
            </ul>
        </div>
    );
};


