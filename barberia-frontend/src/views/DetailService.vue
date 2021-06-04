<template>
  <section class="details">
    <h1>DETALLES DEL SERVICIO</h1>
    {{service}}
    <div>
      <p>Servicio: {{servicio.name}}</p>
      <p>descripción: {{servicio.description}}</p>
      <p>precio: {{servicio.price}}</p>
    </div>
    <input type="date" placeholder="fecha inicio" v-model="fecha" name="fech">
    <input type="time" placeholder="hora" v-model="hora" name="hour">
    <button v-on:click="ver">Reservar</button>
    <p>valor de fecha: {{fecha}} y de la hora {{hora}}</p>
  </section>
</template>


<script>

import {useService} from "@/uses/useService";

export default {
  name: "DetailService",
  components:{

  },
  data() {
    return {
      id: "",
      servicio: [],
      fecha: "va1",
      hora: "va2",
      horario: []
    }
  },
  created() {
    this.data = this.$route.params.id;
    console.log('data', this.data);
    this.getServicio();
  },
  methods:{
    async getServicio() {
      const url = "http://localhost:8090/service/find/" + this.data;
      const r = await fetch(url);
      this.servicio = await r.json();
      console.log('service', this.servicio);
    }
  },
  ver(){
    console.log("entre a la funcion ver");
  },
}
</script>

<style scoped>
.details {
  max-width: 90rem;
  margin: 0 auto;
  padding: 5rem 1rem;
}
</style>