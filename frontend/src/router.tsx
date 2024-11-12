
import {
    createRouter, createRoute, createRootRoute, Link, Outlet,
} from '@tanstack/react-router'
import {
    QueryClient,
    QueryClientProvider,
} from '@tanstack/react-query'
import {TanStackRouterDevtools} from "@tanstack/router-devtools";
import ProductPage from "@/pages/productPage.tsx";
import {Login} from "@/pages/Login.tsx";

const queryClient = new QueryClient()


const rootRoute = createRootRoute({
    component: () => (
        <QueryClientProvider client={queryClient}>
            <div className="p-2 flex gap-2">
                <Link to="/" className="[&.active]:font-bold">
                    Home
                </Link>{' '}
                <Link to="/about" className="[&.active]:font-bold">
                    About
                </Link>
                <Link to="/products" className="[&.active]:font-bold">
                    Products
                </Link>
                <Link to="/login" className="[&.active]:font-bold">
                    Login
                </Link>

            </div>
            <hr />
            <Outlet />
            <TanStackRouterDevtools />
        </QueryClientProvider>
    ),
})


const aboutRoute = createRoute({
    getParentRoute: () => rootRoute,
    path: '/about',
    component: function About() {
        return <div className="p-2">Hello from About!</div>
    },
})
const indexRoute = createRoute({
    getParentRoute: () => rootRoute,
    path: '/',
    component: function Index() {
        return (
            <div className="p-2">
                <h3>Welcome Home!</h3>
            </div>
        )
    },
})
 const productRoute = createRoute({
     getParentRoute: () => rootRoute,
     path: '/products',
     component: ProductPage
 })

const loginRegisterRoute = createRoute({
    getParentRoute: () => rootRoute,
    path: '/login',
    component: Login
})

const routeTree = rootRoute.addChildren([indexRoute, aboutRoute, productRoute, loginRegisterRoute])

export const router = createRouter({ routeTree })

declare module '@tanstack/react-router' {
    interface Register {
        router: typeof router
    }
}



