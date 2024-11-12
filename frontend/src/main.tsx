import { router } from "./router";
import {RouterProvider} from "@tanstack/react-router";
import {createRoot} from "react-dom/client";
import {StrictMode} from "react";
import "./index.css"

const rootElement = document.getElementById("root")!;


createRoot(rootElement).render(
        <StrictMode>
            <RouterProvider router={router} />
        </StrictMode>
);