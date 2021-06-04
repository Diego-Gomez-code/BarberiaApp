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
    <input type="button" value="Reservar" v-on:click="reservar">
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
    },
    async reservar(){
      console.log("entre a reservar");
      this.horario = {
        service_id: this.servicio.id,
        datetime_start: this.fecha + " " +this.hora,
        type: "p",
        schedule_id: "prueba"
      };
      const url = "http://localhost:8090/schedule/create";
      const payload = JSON.stringify(this.horario);
      const r = await fetch(url,{
        method: "POST",
        body: payload,
        headers: {
          "Content-type": "application/json",
        }
      });
      const response = await r.json();
      console.log(response);
    },
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