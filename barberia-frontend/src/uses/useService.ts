import { onMounted, ref, Ref } from "vue";
import {Service} from "@/types/Service";
import { apiServices } from "@/services/apiServices";

export function useService(){
    const service: Ref<Service[]> = ref([]);
    onMounted(async () => {
        service.value = await apiServices.getServices();
        //services.value = await apiServices.getServicesApi();
    });
    return {service};
}