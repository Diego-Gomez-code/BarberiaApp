import { Service } from "@/types/Service";
import serviceApi from "@/services/services.json";
import { services_all} from "@/config/urls";

export const apiServices = {
    getServices: function (): Promise<Service[]> {
        return new Promise((resolve) => {
            resolve(serviceApi)
        });
    },
    getServicesApi(): Promise<Service[]> {
        const url = process.env.VUE_APP_BASE_URL.concat(services_all);
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
