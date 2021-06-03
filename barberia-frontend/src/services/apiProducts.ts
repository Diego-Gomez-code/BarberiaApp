import { Product } from "@/types/Product";
import productsApi from "@/services/products.json";
import { products_all } from "@/config/urls";

export const apiProducts = {
  getProducts(): Promise<Product[]> {
    return new Promise((resolve) => {
      resolve(productsApi);
    });
  },
  getProductsApi(): Promise<Product[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(products_all);
    const config = {
      method: "GET",
    };
    return fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("errorsito");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  },
};
