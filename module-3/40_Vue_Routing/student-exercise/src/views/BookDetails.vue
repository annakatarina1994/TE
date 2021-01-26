<template>
  <!-- <div>
    <h2 class="book-title">{{ book.title }}</h2>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <h3 class="book-author">{{ book.author }}</h3>
    <p v-if="!book.read">You have NOT read this book.</p>
    <p v-if="book.read">You have read this book!</p>
  </div> -->
  <div>
      <book-card v-for="book in $store.state.books" v-bind:book="book" v-bind:key="book.isbn"/>
  </div>

</template>

<script>
import BookCard from '../components/BookCard.vue';

export default {
  components: { BookCard },
  props: ["book"]
};
</script>

<style>
</style>