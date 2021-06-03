<template>
  <section class="products">
    <h2 class="products-title">Productos Disponibles</h2>
    <div class="products-collection">
      <ProductCard
        v-for="product in products"
        :key="product.name"
        :product="product"
      ></ProductCard>
    </div>
  </section>
</template>

<script lang="ts">
import { defineComponent, onMounted, Ref, ref } from "vue";
import { useProducts } from "@/uses/useProducts";
import ProductCard from "@/components/products/ProductCard.vue";

export default defineComponent({
  name: "Products",
  components: {
    ProductCard,
  },
  setup() {
    const { products } = useProducts();
    return { products };
  },
});
</script>

<style scoped>
.products {
  max-width: 90rem;
  margin: 0 auto;
  padding: 5rem 1rem;
}
.products-title {
  font-size: 2rem;
}
.products-collection {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(18rem, 1fr));
  gap: 1.5rem;
}
</style>
