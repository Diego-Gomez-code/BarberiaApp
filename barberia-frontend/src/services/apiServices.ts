import { services_all} from "@/config/urls";
import servicesApi from "@/services/services.json"
import {Service} from "@/types/Service";

export const apiServices = {
    getServices: function (): Promise<Service[]> {
        return new Promise((resolve) => {
            resolve(servicesApi)
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
