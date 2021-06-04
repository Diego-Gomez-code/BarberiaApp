import { service_id} from "@/config/urls";
import serviceApi from "@/services/services.json"
import {Service} from "@/types/Service";

export const apiService = {
    getServices: function (): Promise<Service[]> {
        return new Promise((resolve) => {
            resolve(serviceApi)
        });
    },
    getServicesApi(): Promise<Service[]> {
        const url = process.env.VUE_APP_BASE_URL.concat(service_id).concat();
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
