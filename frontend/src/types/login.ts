export interface LoginRequest {
    username: string; // or email if you prefer
    password: string;
}

export interface LoginResponse {
    // Define the structure of the response you expect from the server
    token: string; // Example: JWT token
    user: {
        id: string;
        email: string;
        // Add other user properties as needed
    };
}