<template>
  <article class="card">
    <a href="#" v-bind:class="detalles" @click="detalles">
      <router-link v-bind:to="'/services/detail/'+actualService.id">details</router-link>
      <img :src="actualService.image" alt="" class="card-img" />
      <div class="card-info">
        <h3>{{ actualService.name }}</h3>
        <p class="card-lead">{{ actualService.description }}</p>
      </div>
    </a>
  </article>
  <router-view/>
</template>

<script lang="ts">
import { defineComponent, Ref, ref, onBeforeMount } from "vue";
import { Service } from "@/types/Service";

export default defineComponent({
  name: "ServicesCard",
  props: {
    service: {
      type: Object as () => Service,
      required: true,
    },
  },
  setup(props) {
    const serviceCard: Ref<Service | null> = ref(null);
    onBeforeMount(() => {
      serviceCard.value = Object.assign({}, props.service);
      serviceCard.value.image = require(`@/assets/${serviceCard.value.image}`);
    });
    return { actualService: serviceCard };
  },
});
</script>

<style scoped>
.card {
  min-height: 10rem;
  background: #fff;
  /*box-shadow: 0 0.2rem 1rem rgba(0, 0, 0, 0.05);*/
  cursor: pointer;
  transition: transform 0.3s, box-shadow 0.3s;
  border-radius: 10px;
}
.card a {
  color: #333;
  text-decoration: none;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  padding: 0.5rem;
  height: 100%;
}
.card:hover,
.card:focus {
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
  transform: translateY(-0.5rem);
}
.card:focus {
  outline: 5px solid black;
}
.card-img {
  width: 50%;
}
.card-info {
  padding: 0 1rem 1rem;
  text-align: justify;
}
</style>
