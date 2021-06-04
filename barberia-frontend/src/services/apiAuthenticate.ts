import { User } from "@/types/User";
import { login_path, products_all } from "@/config/urls";
import { Product } from "@/types/Product";
import usersApi from "@/services/users.json";

export const apiAuthenticate = {
  authenticate(user: User) {
      return new Promise((resolve) => {
          resolve(usersApi);
      });
      /*const url = process.env.VUE_APP_BASE_URL.concat(login_path);
    const config = {
      method: "POST",
      body: JSON.stringify(user),
    };

    return fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Ha fallado sus credenciales");
        }
      })
      .catch((error) => {
        throw error;
      });*/
  },
};
