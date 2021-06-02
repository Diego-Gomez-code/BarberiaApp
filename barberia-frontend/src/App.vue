<template>
  <div id="nav">
    <div>
      <router-link to="/">Home</router-link>
      <router-link to="/products">Productos</router-link>
      <router-link to="/services">Servicios</router-link>
    </div>
  </div>
  <router-view />
</template>

<style lang="scss">
body {
  background: aliceblue;
  margin: 0 !important;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}

#nav {
  padding: 30px;
  background: #333333;
  a {
    font-weight: bold;
    margin: 10px;
    text-decoration: none;
    color: rgb(255, 255, 255);
    &.router-link-exact-active {
      color: #287df5;
    }
  }
}
</style>
