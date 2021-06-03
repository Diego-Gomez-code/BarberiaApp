import { onMounted, ref, Ref } from "vue";
import {Service} from "@/types/Service";
import { apiServices } from "@/services/apiServices";

export function useServices(){
    const services: Ref<Service[]> = ref([]);

    onMounted(async () => {
        services.value = await apiServices.getServices();
        //services.value = await apiServices.getServicesApi();
    });

    return {services};

}