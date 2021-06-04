<template>
  <div class="home">
    <div class="header">
      <h1>Bienvenido a Nordics</h1>
      <p>Mira que bonitas nuestras fotos de las intalaciones, compra aqui :)</p>
    </div>
    <div class="row">
      <div class="column">
        <img src="@/assets/barberia.jpg" style="width: 100%" />
        <img src="@/assets/barberia2.jpg" style="width: 100%" />
        <img src="@/assets/barberia3.jpg" style="width: 100%" />
      </div>
      <div class="column">
        <img src="@/assets/barberia2.jpg" style="width: 100%" />
        <img src="@/assets/barberia.jpg" style="width: 100%" />
        <img src="@/assets/barberia4.jpg" style="width: 100%" />
      </div>
      <div class="column">
        <img src="@/assets/barberia3.jpg" style="width: 100%" />
        <img src="@/assets/barberia.jpg" style="width: 100%" />
        <img src="@/assets/barberia2.jpg" style="width: 100%" />
      </div>
      <div class="column">
        <img src="@/assets/barberia4.jpg" style="width: 100%" />
        <img src="@/assets/barberia3.jpg" style="width: 100%" />
        <img src="@/assets/barberia2.jpg" style="width: 100%" />
      </div>
    </div>
    <div class="middle">
      <h1>Aqui puede seleccionar de nuestros productos y servicios</h1>
    </div>

    <div class="containergrande">
      <router-link tag="div" to="/products" class="container">
        <img src="@/assets/espuma.jpg" alt="" class="image" />
        <div class="overlay">
          <div class="text">Productos</div>
        </div>
      </router-link>
      <router-link tag="div" to="/services" class="container">
        <img src="@/assets/barberia4.jpg" alt="" class="image" />
        <div class="overlay">
          <div class="text">Servicios</div>
        </div>
      </router-link>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Home",
  components: {},
});
</script>

<style scoped>
* {
  box-sizing: border-box;
}
.home {
  padding: 4rem;
}
.header {
  text-align: center;
  padding: 32px;
}
.middle {
  margin-top: 32px;
  text-align: center;
}
.row {
  display: flex;
  flex-wrap: wrap;
  padding: 0 4px;
}

/* Create four equal columns that sits next to each other */
.column {
  flex: 25%;
  max-width: 25%;
  padding: 0 4px;
}
.column img {
  margin-top: 8px;
  vertical-align: middle;
  width: 100%;
}
@media screen and (max-width: 800px) {
  .column {
    flex: 50%;
    max-width: 50%;
  }
}
/* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .column {
    flex: 100%;
    max-width: 100%;
  }
}
.containergrande {
  display: flex;
  padding: 1rem;
}
.container {
  display: flex;
  position: relative;
  width: 100%;
  margin: 2rem;
}
.image {
  display: block;
  width: 100%;
  height: auto;
}

.overlay {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  height: 100%;
  width: 100%;
  opacity: 0;
  transition: 0.5s ease;
  background-color: #287df5;
}
.container:hover .overlay {
  opacity: 1;
}
.text {
  color: white;
  font-size: 20px;
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  text-align: center;
}
</style>
