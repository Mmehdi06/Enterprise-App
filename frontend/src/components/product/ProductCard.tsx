import {Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle} from "@/components/ui/card.tsx";

import { Product} from "@/types/Product.ts";

interface ProductCardProps {
    product: Product;
}
const ProductCard: React.FC<ProductCardProps> = ({product}) => {
    return (
        <Card>
            <CardHeader>
                <CardTitle>{product.name}</CardTitle>
                <CardDescription>{product.description}</CardDescription>
            </CardHeader>
            <CardContent>
                <p>{product.category}</p>
                <p>{product.price}</p>
            </CardContent>
            <CardFooter>
                <p>{product.available}</p>
            </CardFooter>
        </Card>

    )
}

export default ProductCard