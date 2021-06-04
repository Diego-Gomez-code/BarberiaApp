<template>
  <section class="services">
    <h2 class="services-title">Servicios Disponibles</h2>
    <div class="services-collection">
      <ServicesCard
          v-for="service in services"
          :key="service.name"
          :service="service">
      </ServicesCard>
    </div>
  </section>
</template>

<script lang="ts">
import { defineComponent, onMounted, Ref, ref } from "vue";
import { useServices } from "@/uses/useServices";
import  ServicesCard from "@/components/services/ServicesCard.vue";

export default defineComponent({
  name: "Services",
  components: {
    ServicesCard,
  },
  setup() {
    const { services } = useServices();
    return { services };
  },
});
</script>

<style scoped>
.services {
  max-width: 90rem;
  margin: 0 auto;
  padding: 5rem 1rem;
}
.services-title {
  font-size: 2rem;
}
.services-collection {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(18rem, 1fr));
  gap: 1.5rem;
}
</style>
