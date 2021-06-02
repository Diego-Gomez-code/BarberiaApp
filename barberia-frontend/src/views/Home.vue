<template>
  <div class="home">
    <img alt="Vue logo" class="img-ini" src="../assets/barberia.jpg" />
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App" />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import HelloWorld from "@/components/HelloWorld.vue"; // @ is an alias to /src

export default defineComponent({
  name: "Home",
  components: {
    HelloWorld,
  },
});
</script>

<style scoped>
.home {
  align-items: center;
  justify-content: center;
}
.img-ini {
  height: 40rem;
  width: 100%;
}
</style>
